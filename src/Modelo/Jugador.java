package Modelo;

import java.util.ArrayList;

public class Jugador {

	Castillo castillo;
	ArrayList<Aldeano> aldeanos;
	ArrayList<Objetivo> objetivos;
	int cantidadDeOro;
	
	public Jugador(Castillo castillo, ArrayList<Aldeano> aldeanos, int cantidadDeOro){
		this.castillo = castillo;
		this.aldeanos = aldeanos;
		this.cantidadDeOro = cantidadDeOro;
	}

	public boolean perdiste(){
		return castillo.derrumbado();
	}
	
	public void recolectarOro(){
		for(Aldeano aldeano: aldeanos){
			cantidadDeOro += aldeano.recolectarOro();
		}
	}
}
