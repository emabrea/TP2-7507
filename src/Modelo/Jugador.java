package Modelo;

import java.util.ArrayList;

public class Jugador {

	
	ArrayList<Aldeano> aldeanos;
	ArrayList<Edificio> edificios;
	ArrayList<Unidad> unidades;
	int cantidadDeOro;
	//int poblacion ; 
	//Castillo castillo;
	
	public Jugador(/*Castillo castillo, */ int cantidadDeOro){
		//this.castillo = castillo;		
		this.aldeanos = new ArrayList<Aldeano>();
		this.unidades= new ArrayList<Unidad>();
		this.edificios= new ArrayList<Edificio>();
		this.cantidadDeOro = cantidadDeOro;	
		
	}
	/*
	public boolean perdiste(){
		return castillo.derrumbado();
	}*/

	public Edificio obtenerEdificio(){
		return edificios.get(0);
	}
	

	public void agregarObjetivo(Aldeano aldeano){
		aldeanos.add(aldeano);
		//this.poblacion +=1;
	}

	public void agregarObjetivo(Unidad unidad){
		unidades.add(unidad);
		//this.poblacion +=1;
	}

	public void agregarObjetivo(Edificio edificio){
		edificios.add(edificio);
		//this.poblacion +=1;
	}

	public void eliminarObjetivo(Aldeano aldeano){
		aldeanos.remove(aldeano);
		//this.poblacion -=1;
	}

	public void eliminarObjetivo(Unidad unidad){
		unidades.remove(unidad);
		//this.poblacion -=1;
	}

	public void eliminarObjetivo(Edificio edificio){
		edificios.remove(edificio);
		//this.poblacion -=1;
	}

	public void aumentarOro(int monto){
		this.cantidadDeOro += monto;
	}

	public int cantidadDeOro(){
		return this.cantidadDeOro;
	}
	
}
