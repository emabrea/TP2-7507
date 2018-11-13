package Modelo;

public class PlazaCentral extends Edificio {

	public PlazaCentral(Zona zona) {
		super(zona, 400, 100, 25, 3);
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
