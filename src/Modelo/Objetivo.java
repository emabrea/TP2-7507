package Modelo;

public class Objetivo {
	
	Posicion posicion;
	int vida;
	int vidaMaxima;
	int costo;
	
	public Objetivo(Posicion posicion, int vida, int costo){
		this.vida = vida;
		this.vidaMaxima = vida;
		this.costo = costo;
		this.posicion = posicion;
	}
	
	
}
