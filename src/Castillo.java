package Modelo;

public class Castillo extends Edificio{
	
	public Castillo(Zona zona) {
		super(zona, 1000, 0, 15, 0);
	}

	int tamanio = 8;

	public int getTamanio() {
		return tamanio;
	}

}
