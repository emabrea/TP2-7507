package Modelo;

import java.util.ArrayList;

public class Edificio extends Objetivo{
	
	int vida;
	int costo;
	int velocidadDeReparacion;
	int turnosEnConstruirse;
	
	public Edificio(Zona zona, int vida, int costo, int velocidadDeReparacion, int turnosEnConstruirse){
		super(zona, vida, costo);
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
}
