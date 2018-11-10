package Modelo;

import Modelo.Aldeano;

public class PlazaCentral implements Edificio {

	int tamanio = 4;
	
	public Aldeano crearAldeano() {
		return (new Aldeano());
	}

	public int getTamanio() {
		return tamanio;
	}

}
