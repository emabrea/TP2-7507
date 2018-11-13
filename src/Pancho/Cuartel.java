package Modelo;

public class Cuartel extends Edificio {

	public Cuartel(Zona zona) {
		super(zona, 250, 50, 50, 3);
	}

	int base = 2;
	int altura = 2;

	public int getTamanioBase() {
		return base;
	}
	
	public int getTamanioAltura() {
		return altura;
	}

}
