package Modelo;

import java.util.ArrayList;

public class Jugador {

	//Castillo castillo;
	//ArrayList<Aldeano> aldeanos;
	ArrayList<Objetivo> objetivos;
	int cantidadDeOro;
	//int poblacion ; 
	
	public Jugador(/*Castillo castillo, ArrayList<Aldeano> aldeanos,*/ int cantidadDeOro){
		//this.castillo = castillo;
		//this.aldeanos = aldeanos;
		this.cantidadDeOro = cantidadDeOro;
		//this.poblacion = aldeanos.size();
		this.objetivos = new ArrayList<Objetivo>();
	}
/*
	public boolean perdiste(){
		return castillo.derrumbado();
	}
	
	public void recolectarOro(){
		for(Aldeano aldeano: aldeanos){
			cantidadDeOro += aldeano.recolectarOro();
		}
	}*/

	public void agregarObjetivo(Objetivo objetivo){
		objetivos.add(objetivo);
		//this.poblacion +=1;
	}

	public void aumentarOro(int monto){
		this.cantidadDeOro += monto;
	}

	public int cantidadDeOro(){
		return this.cantidadDeOro;
	}
	
}
