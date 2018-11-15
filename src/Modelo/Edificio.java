package Modelo;

import java.util.ArrayList;

public class Edificio extends Objetivo{

	private int velocidadDeReparacion;
	private int turnosEnConstruirse;
	
	public Edificio(Zona zona, int vida, int costo, Jugador jugador,int velocidadDeReparacion, int turnosEnConstruirse){
		super(zona, vida, costo, jugador);
		this.velocidadDeReparacion = velocidadDeReparacion;
		this.turnosEnConstruirse = turnosEnConstruirse;
	}
	
	public ArrayList<Celda> posiblesCeldasParaCrearUnidad(Zona zona, int base, int altura, Mapa mapa){
		
		Celda celdaArribaIzquierda = zona.getCeldaArribaIzquierda();
		Celda celdaInicialDeBusqueda = celdaArribaIzquierda.crearCeldaIgual();
		celdaInicialDeBusqueda.desplazarArribaIzquierda();
		
		Zona zonaDeBusqueda = new Zona(celdaInicialDeBusqueda, base ,  altura);
		
		return mapa.buscarPosiblesCeldas(celdaInicialDeBusqueda, zonaDeBusqueda, base, altura);
	}

	public boolean estaAlLadoDe(Celda celda) {
		Zona zonaDelEdificio = (Zona)this.posicion;
		return zonaDelEdificio.estaAlLadoDe(celda);
	}

	public boolean esPosibleAumentarVida() {
		return this.vida < this.vidaMaxima;
	}

	public void aumentarVida() {
		int vidaNueva = this.vida + this.velocidadDeReparacion;
		if(vidaNueva > this.vidaMaxima){
			this.vida = this.vidaMaxima;
		}else{
			this.vida = vidaNueva;
		}
	}
}
