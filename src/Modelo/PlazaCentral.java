package Modelo;

public class PlazaCentral extends Edificio {

	public PlazaCentral(Zona zona) {
		super(zona, 400, 100, 25, 3);
	}

	static int base = 2;
	static int altura = 2;

	public static int getTamanioBase() {
		return base;
	}
	
	static int getTamanioAltura() {
		return altura;
	}

}
