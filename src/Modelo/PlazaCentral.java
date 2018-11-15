package Modelo;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

	public PlazaCentral(Celda celdaInicial) {
		super(new Zona(celdaInicial, base, altura), 450, 100, 25, 3);
	}

	static int base = 2;
	static int altura = 2;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}

	public ArrayList<Celda> posiblesCeldasParaCrearAldeano(Mapa mapa) {
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2, mapa);
		
		if(celdasPosibles.isEmpty()){
			throw new NoSePuedeCrearElAldeanoCeldasPerifericasOcupadasException();
		}
		
		return celdasPosibles;
	}

	public void crearAldeano(Mapa mapa, Celda celda) {
		mapa.insertar(celda);
	}

}
