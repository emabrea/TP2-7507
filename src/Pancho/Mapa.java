package Modelo;

import java.util.ArrayList;

public class Mapa {
	
	int altura = 25s;
	int base = 50;
	ArrayList<Celda> celdas;
	
	public Mapa(){
		celdas = new ArrayList<Celda>();
		
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
