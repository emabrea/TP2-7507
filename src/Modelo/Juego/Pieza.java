package Modelo.Juego;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;

public class Pieza {
	
	public Posicion posicion;
	public int vida;
	public int costo;
	public int vidaMaxima;
	public Jugador jugador;
	
	public Pieza(Posicion posicion, int vida, int costo, Jugador jugador){
		this.vida = vida;
		this.costo = costo;
		this.posicion = posicion;
		this.vidaMaxima = vida;
		this.jugador = jugador;
	}

	public Posicion obtenerPosicion(){
		return this.posicion;
	}

	public void reducirVidaEn(int unaCantidad){
		int nuevaVida = this.vida - unaCantidad;
		this.vida = nuevaVida;							
		// VER QUE HACER EN CASO DE QUE MUERA OBJETIVO.
	}

	public boolean distanciaAPiezaEsMenorIgualA(int unValor, Pieza pieza){
		return pieza.distanciaAPosicionEsMenorIgualA(unValor, this.posicion);
	}

	public boolean distanciaAPosicionEsMenorIgualA(int unValor, Posicion posicion) {
		return posicion.distanciaAPosicionEsMenorIgualA(unValor, this.posicion);
	}

	public int obtenerVida(){
		return this.vida;
	}

	public boolean esPiezaPropia(Jugador jugador){
		return this.jugador == jugador;
	}
	
}
