package Modelo;

public class Cuartel extends Edificio {

	public Cuartel(Zona zona) {
		super(zona, 250, 50, 50, 3);
	}

	static int base = 2;
	static int altura = 2;

	static int getTamanioBase() {
		return base;
	}
	
	static int getTamanioAltura() {
		return altura;
	}

}
