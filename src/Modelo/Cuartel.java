package Modelo;

import java.util.ArrayList;

public class Cuartel extends Edificio {

	public Cuartel(Zona zona) {
		super(zona, 250, 50, 50, 3);
	}

	static int base = 2;
	static int altura = 2;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}

	public ArrayList<Celda> posiblesCeldasParaCrearArquero(Mapa mapa) {
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2, mapa);
		 
		if(celdasPosibles.isEmpty()){
			throw new NoSePuedeCrearElArqueroCeldasPerifericasOcupadasException();
		}
		
		return celdasPosibles;
	}
	
	public ArrayList<Celda> posiblesCeldasParaCrearEspadachin(Mapa mapa) {
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2, mapa);
		 
		if(celdasPosibles.isEmpty()){
			throw new NoSePuedeCrearElEspadachinCeldasPerifericasOcupadasException();
		}
		
		return celdasPosibles;
	}
	
	public void crearArquero(Mapa mapa, Celda celda) {
		mapa.insertar(celda);
	}
	
	public void crearEspadachin(Mapa mapa, Celda celda) {
		mapa.insertar(celda);
	}

}
