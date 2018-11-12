package Modelo;

public class Cuartel implements Edificio {

	int tamanio = 4;
	
	public Arquero crearArquero() {
		return (new Arquero());
	}

	public Espadachin crearEspadachin() {
		
		return (new Espadachin());
	}

	public int getTamanio() {
		return tamanio;
	}

}
