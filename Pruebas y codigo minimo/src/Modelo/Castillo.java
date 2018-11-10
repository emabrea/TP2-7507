package Modelo;

public class Castillo implements Edificio{
	
	int tamanio = 8;

	public ArmaDeAsedio crearArmaDeAsedio() {
	
		return (new ArmaDeAsedio());
		
	}

	public int getTamanio() {
		return tamanio;
	}

}
