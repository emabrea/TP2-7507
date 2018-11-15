package Modelo;

public class Objetivo {

	Posicion posicion;
	int vida;
	int vidaMaxima;
	int costo;
	Jugador jugador;

	public Objetivo(Posicion posicion, int vida, int costo, Jugador jugador){
		this.posicion = posicion;
		this.vida = vida;
		this.vidaMaxima = vida;
		this.costo = costo;
		this.jugador = jugador;
	}
	
	
}
