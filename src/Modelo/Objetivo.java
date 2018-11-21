package Modelo;

public class Objetivo {
	
	Posicion posicion;
	int vida;
	int costo;
	int vidaMaxima;
	Jugador jugador;
	
	public Objetivo(Posicion posicion, int vida, int costo, Jugador jugador){
		this.vida = vida;
		this.costo = costo;
		this.posicion = posicion;
		this.vidaMaxima = vida;
		this.jugador = jugador;
	}	
}
