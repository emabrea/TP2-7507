package Modelo;

import java.util.ArrayList;

public class Zona implements Posicion{
	
	ArrayList<Celda> celdas;
	int base;
	int altura;

	public Zona(Celda celdaInicial, int base, int altura) {
		this.base = base;
		this.altura = altura;
		this.celdas = new ArrayList<Celda>();
		this.inicializarPosiciones(celdaInicial);
	}
	
	private void inicializarPosiciones(Celda celdaInicial) {
		for(int i = 0 ; i < this.altura ; i++){
			for(int j = 0 ; j < this.base ; j++){
				Celda nuevaCelda = celdaInicial.crearCeldaIgual();
				nuevaCelda.desplazarHorizontalmente(j);
				nuevaCelda.desplazarVerticalmente(i);
				this.celdas.add(nuevaCelda);
			}
		}
		
	}

	@Override
	public boolean igualA(Celda unaCelda) {
		for(Celda celda: celdas){
			if(unaCelda.igualA(celda)) return true;
		}
		return false;
	}
	
	@Override
	public boolean igualA(Zona unaZona){
		for(Celda celda: celdas){
			if(unaZona.igualA(celda)) return true;
		}
		return false;
	}

	@Override
	public boolean enRango(int altura, int base) {
		for(Celda celda: celdas){
			if(! celda.enRango(altura, base)) return false;
		}
		return true;
	}

	@Override
	public boolean igualA(Posicion unaPosicion) {
		return unaPosicion.igualA(this);
	}

}