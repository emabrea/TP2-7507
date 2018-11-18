package Modelo;

import java.util.ArrayList;

public class Cuartel extends Edificio {

	public Cuartel(Celda celdaInicial,Jugador jugador) {
		super(new Zona(celdaInicial, base, altura), 250, 50,jugador, 50, 3);
	}

	static int base = 2;
	static int altura = 2;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}

	public ArrayList<Celda> posiblesCeldasParaCrearArquero() {
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2);
		 
		if(celdasPosibles.isEmpty()){
			throw new NoSePuedeCrearElArqueroCeldasPerifericasOcupadasException();
		}
		
		return celdasPosibles;
	}
	
	public ArrayList<Celda> posiblesCeldasParaCrearEspadachin() {
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2);
		 
		if(celdasPosibles.isEmpty()){
			throw new NoSePuedeCrearElEspadachinCeldasPerifericasOcupadasException();
		}
		
		return celdasPosibles;
	}
	
	public void crearArquero(Celda celda) {
		Arquero arquero = new Arquero(celda, this.jugador);
		this.jugador.agregarObjetivo(arquero);
		Mapa.obtenerInstancia().insertar(celda);
	}
	
	public void crearEspadachin(Celda celda) {
		Espadachin espadachin = new Espadachin(celda, this.jugador);
		this.jugador.agregarObjetivo(espadachin);
		Mapa.obtenerInstancia().insertar(celda);
	}

}
