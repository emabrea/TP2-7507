package Modelo.Juego;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import java.util.ArrayList;

public class Jugador {

	
	ArrayList<Aldeano> aldeanos;
	ArrayList<Edificio> edificios;
	ArrayList<Unidad> unidades;
	int cantidadDeOro;
	int poblacion ; 
	Castillo castillo;
	
	public Jugador(int cantidadDeOro){				
		this.aldeanos = new ArrayList<Aldeano>();
		this.unidades= new ArrayList<Unidad>();
		this.edificios= new ArrayList<Edificio>();
		this.cantidadDeOro = cantidadDeOro;	
		this.poblacion = 0;		
	}
	/*
	public boolean perdiste(){
		return castillo.derrumbado();
	}*/

	public void crearCastillo(Castillo castillo){
		this.castillo = castillo;
	}

	public Edificio obtenerEdificio(Zona zona){
		for(Edificio edificio : edificios){
			if(edificio.estaEnPosicion(zona)){
				return edificio;
			}
		}
		return null;
		
	}

	public Unidad obtenerUnidad(Celda celda){
		for(Unidad unidad: unidades){
			if(unidad.estaEnPosicion(celda)){
				return unidad;
			}
		}		
		return null;		
	}
	

	public void agregarPieza(Aldeano aldeano){
		if(this.poblacion == 50){
			throw new PoblacionExcedidaException();
		}
		aldeanos.add(aldeano);
		unidades.add(aldeano);
		this.poblacion +=1;
	}

	public void agregarPieza(Unidad unidad){
		if(this.poblacion == 50){
			throw new PoblacionExcedidaException();
		}
		unidades.add(unidad);
		this.poblacion +=1;
	}

	public void agregarPieza(Edificio edificio){
		edificios.add(edificio);		
	}

	public void eliminarPieza(Aldeano aldeano){
		aldeanos.remove(aldeano);
		this.poblacion -=1;
	}

	public void eliminarPieza(Unidad unidad){
		unidades.remove(unidad);
		this.poblacion -=1;
	}

	public void eliminarPieza(Edificio edificio){
		edificios.remove(edificio);		
	}

	public void aumentarOro(int monto){
		this.cantidadDeOro += monto;
	}

	public int cantidadDeOro(){
		return this.cantidadDeOro;
	}

	public int poblacion(){
		return this.poblacion;
	}
	
}
