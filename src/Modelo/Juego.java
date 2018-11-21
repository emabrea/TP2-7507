package Modelo;

import java.util.ArrayList;

public class Juego {
	Jugador jugador1;
	Jugador jugador2;
	int cantidadDeOroInicial;	
	
	public Juego(){		
		this.cantidadDeOroInicial = 100;
		this.inicializarJugadores();
	}

	private void inicializarJugadores() {
		this.inicializarJugador1();
		this.inicializarJugador2();
	}

	private void inicializarJugador1() {
		this.jugador1 = new Jugador(this.cantidadDeOroInicial);

		int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
		int baseCastillo = Castillo.getTamanioBase();
		int alturaCastillo = Castillo.getTamanioAltura();

		Celda celdaInicial = new Celda(0, alturaMapa);		
		Castillo castillo = new Castillo(celdaInicial, jugador1);
		jugador1.crearCastillo(castillo);
		
		
		// Primer aldeano
		celdaInicial.desplazarVerticalmente(-alturaCastillo - 1);
		celdaInicial.desplazarDerecha();
		Celda celda1 = celdaInicial.crearCeldaIgual();	
		Mapa.obtenerInstancia().insertar(celda1);
		
		
		// Segundo aldeano
		celdaInicial.desplazarHorizontalmente(baseCastillo);
		Celda celda2 = celdaInicial.crearCeldaIgual();	
		Mapa.obtenerInstancia().insertar(celda2);		
		
		// Tercer aldeano
		celdaInicial.desplazarVerticalmente(alturaCastillo);
		Celda celda3 = celdaInicial.crearCeldaIgual();
		Mapa.obtenerInstancia().insertar(celda3);		
		
		jugador1.agregarObjetivo(new Aldeano(celda1, jugador1 ));
		jugador1.agregarObjetivo(new Aldeano(celda2, jugador1 ));
		jugador1.agregarObjetivo(new Aldeano(celda3, jugador1 ));				
		
		Zona zona = new Zona(celdaInicial, baseCastillo, alturaCastillo);		
	}

	private void inicializarJugador2() {
		this.jugador2 = new Jugador(this.cantidadDeOroInicial);

		int baseCastillo = Castillo.getTamanioBase();
		int alturaCastillo = Castillo.getTamanioAltura();
		int baseMapa = Mapa.obtenerInstancia().getTamanioBase();		
		
		Celda celdaInicial = new Celda(baseMapa - baseCastillo + 1, alturaCastillo - 1);	
		Castillo castillo = new Castillo(celdaInicial, jugador2);	
		jugador2.crearCastillo(castillo);		
		
		// Primer aldeano
		celdaInicial.desplazarHorizontalmente(baseCastillo - 2);
		celdaInicial.desplazarVerticalmente(2);		
		Celda celda1 = celdaInicial.crearCeldaIgual();
		Mapa.obtenerInstancia().insertar(celda1);		
		
		// Segundo aldeano
		celdaInicial.desplazarHorizontalmente(-baseCastillo);
		Celda celda2 = celdaInicial.crearCeldaIgual();	
		Mapa.obtenerInstancia().insertar(celda2);		
		
		// Tercer aldeano
		celdaInicial.desplazarVerticalmente(-alturaCastillo);
		Celda celda3 = celdaInicial.crearCeldaIgual();	
		Mapa.obtenerInstancia().insertar(celda3);		
		
		jugador2.agregarObjetivo(new Aldeano(celda1, jugador2 ));
		jugador2.agregarObjetivo(new Aldeano(celda2, jugador2 ));
		jugador2.agregarObjetivo(new Aldeano(celda3, jugador2) );		

		Zona zona = new Zona(celdaInicial, baseCastillo, alturaCastillo);		
	}

	public Jugador obtenerJugador1(){
		return jugador1;
	}

	public Jugador obtenerJugador2(){
		return jugador2;
	}
	
}
