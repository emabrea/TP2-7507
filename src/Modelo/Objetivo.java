package Modelo;

public class Objetivo {
	
	Posicion posicion;
	int vida;
	int costo;
	int vidaMaxima;
	Jugador jugador;
	
	public Objetivo(Posicion posicion, int vida, int costo, Jugador jugador){
		this.vida = vida;
		this.costo = costo;
		this.posicion = posicion;
		this.vidaMaxima = vida;
		this.jugador = jugador;
	}

	public Posicion obtenerPosicion(){
		return this.posicion;
	}

	public void reducirVidaEn(int unaCantidad){
		int nuevaVida = this.vida - unaCantidad;
		this.vida = nuevaVida;
		// VER QUE HACER EN CASO DE QUE MUERA OBJETIVO.
	}

	public boolean distanciaAObjetivoEsMenorIgualA(int unValor, Objetivo unObjetivo){
		return unObjetivo.distanciaAPosicionEsMenorIgualA(unValor, this.posicion);
	}

	public boolean distanciaAPosicionEsMenorIgualA(int unValor, Posicion posicion) {
		return posicion.distanciaAPosicionEsMenorIgualA(unValor, this.posicion);
	}

	public int obtenerVida(){
		return this.vida;
	}

}
