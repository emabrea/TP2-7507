package Modelo;

import java.util.ArrayList;

public class AldeanoReparando implements EstadoAldeano{

	@Override
	public void repararEdificio(Mapa mapa, Celda celda, Edificio edificio) {
	}

	@Override
	public ArrayList<Zona> posiblesZonasAConstruirCuartel(Mapa mapa, Celda celda) {
		throw new AldeanoReparandoException();
	}
	
	@Override
	public ArrayList<Zona> posiblesZonasAConstruirPlazaCentral(Mapa mapa, Celda celda) {
		throw new AldeanoReparandoException();
	}
	
	@Override
	public int recolectarOro() {
		throw new AldeanoReparandoException();		
	}

	@Override
	public void construirCuartel(Zona zona, Mapa mapa) {
		throw new AldeanoReparandoException();	
	}

	@Override
	public void construirPlazaCentral(Zona zona, Mapa mapa) {
		throw new AldeanoReparandoException();	
	}

	public boolean aldeanoLibre(){
		return false;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){//implementar
		return;
	}

}
