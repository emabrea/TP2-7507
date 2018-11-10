package Modelo;

import java.util.ArrayList;

public class Mapa {
	
	int altura;
	int base;
	ArrayList<Celda> celdas;
	
	public Mapa(int altura, int base){
		this.altura = altura;
		this.base = base;
		celdas = new ArrayList<Celda>();
		
	}
	
	public static Mapa crearMapaAncho() {
		int altura = 50;
		int base = 100;
		return new Mapa(altura, base);
	}

	public static Mapa crearMapaAlto(){
		int altura = 100;
		int base = 50;
		return new Mapa(altura, base);
	}

	public void insertar(Insertable unObjeto, Posicion unaPosicion) {
		if(this.posicionOcupada(unaPosicion)){
			throw new PosicionOcupadaException();
		}
		celdas.add(new Celda(unObjeto, unaPosicion));
		
	}

	private boolean posicionNoEsValida(Posicion posicion) {
		return (! posicion.enRango(this.altura, this.base));
	}

	public boolean posicionOcupada(Posicion unaPosicion) {
		if(this.posicionNoEsValida(unaPosicion)){
			throw new PosicionInvalidaException();
		}
		return (celdas.contains(unaPosicion));
	}
	
}
