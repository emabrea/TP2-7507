package Modelo;

import java.util.ArrayList;

public class Mapa {
	
	int altura;
	int base;
	ArrayList<Posicion> posiciones;
	
	public Mapa(){
		this.altura = 25;
		this.base = 50;
		this.posiciones = new ArrayList<Posicion>();
		
	}
	
	public void mover(Celda celdaNueva){
		this.posicionEsValida(celdaNueva);
	}

	public void insertar(Posicion unaPosicion) {
		this.posicionEsValida(unaPosicion);
		this.posiciones.add(unaPosicion);
	}

	private void posicionEsValida(Posicion posicion) {
		if(! posicion.enRango(this.altura, this.base)){
			throw new CeldaInvalidaException();
		}
		if(this.posicionOcupada(posicion)){
			throw new CeldaOcupadaException();
		}
	}

	public boolean posicionOcupada(Posicion unaPosicion) {
		for(Posicion posicion: this.posiciones){
			if(unaPosicion.igualA(posicion)) return true;
		}
		return false;
	}

	public int getTamanioBase() {
		return base;
	}

	public int getTamanioAltura() {
		return altura;
	}

	public boolean enRango(Posicion unaPosicion) {
		return unaPosicion.enRango(this.altura, this.base);
	}
	
}
