package Modelo;

import java.util.ArrayList;

public class Juego {
	Jugador jugador1;
	Jugador jugador2;
	int cantidadDeOroInicial;
	Mapa mapa;
	
	public Juego(){
		mapa = new Mapa();
		this.cantidadDeOroInicial = 100;
		this.inicializarJugadores();
	}

	private void inicializarJugadores() {
		this.inicializarJugador1();
		this.inicializarJugador2();
	}

	private void inicializarJugador2() {
		int alturaMapa = this.mapa.getTamanioAltura();
		Celda celdaInicial = new Celda(0, alturaMapa);
		Castillo castillo = new Castillo(celdaInicial);
		
		int baseCastillo = Castillo.getTamanioBase();
		int alturaCastillo = Castillo.getTamanioAltura();
		
		ArrayList<Aldeano> aldeanos = new ArrayList<Aldeano>();
		ArrayList<Celda> celdas = new ArrayList<Celda>();
		
		// Primer aldeano
		celdaInicial.desplazarVerticalmente(-alturaCastillo - 1);
		celdaInicial.desplazarDerecha();
		Celda celda1 = celdaInicial.crearCeldaIgual();
		aldeanos.add(new Aldeano(celda1));
		celdas.add(celda1);
		
		// Segundo aldeano
		celdaInicial.desplazarHorizontalmente(baseCastillo);
		Celda celda2 = celdaInicial.crearCeldaIgual();
		aldeanos.add(new Aldeano(celda2));
		celdas.add(celda2);
		
		// Tercer aldeano
		celdaInicial.desplazarVerticalmente(alturaCastillo);
		Celda celda3 = celdaInicial.crearCeldaIgual();
		aldeanos.add(new Aldeano(celda3));
		celdas.add(celda3);
		
		this.jugador1 = new Jugador(castillo, aldeanos, this.cantidadDeOroInicial);
		
		
		Zona zona = new Zona(celdaInicial, baseCastillo, alturaCastillo);
		this.insertarPosicionesEnMapa(zona, celdas);
	}

	private void inicializarJugador1() {
		
		int baseCastillo = Castillo.getTamanioBase();
		int alturaCastillo = Castillo.getTamanioAltura();
		int baseMapa = this.mapa.getTamanioBase();
		
		Celda celdaInicial = new Celda(baseMapa - baseCastillo + 1, alturaCastillo - 1);
		Castillo castillo = new Castillo(celdaInicial);
		
		ArrayList<Aldeano> aldeanos = new ArrayList<Aldeano>();
		ArrayList<Celda> celdas = new ArrayList<Celda>();
		
		// Primer aldeano
		celdaInicial.desplazarHorizontalmente(baseCastillo - 2);
		celdaInicial.desplazarVerticalmente(2);
		
		Celda celda1 = celdaInicial.crearCeldaIgual();
		aldeanos.add(new Aldeano(celda1));
		celdas.add(celda1);
		
		// Segundo aldeano
		celdaInicial.desplazarHorizontalmente(-baseCastillo);
		Celda celda2 = celdaInicial.crearCeldaIgual();
		aldeanos.add(new Aldeano(celda2));
		celdas.add(celda2);
		
		// Tercer aldeano
		celdaInicial.desplazarVerticalmente(-alturaCastillo);
		Celda celda3 = celdaInicial.crearCeldaIgual();
		aldeanos.add(new Aldeano(celda3));
		celdas.add(celda3);
		
		this.jugador2 = new Jugador(castillo, aldeanos, this.cantidadDeOroInicial);
		
		Zona zona = new Zona(celdaInicial, baseCastillo, alturaCastillo);
		this.insertarPosicionesEnMapa(zona, celdas);
	}

	private void insertarPosicionesEnMapa(Zona zona, ArrayList<Celda> celdas) {
		this.mapa.insertar(zona);
		for(Celda celda: celdas){
			mapa.insertar(celda);
		}
	}
	
}
