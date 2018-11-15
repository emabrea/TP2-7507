package Modelo;

import java.util.ArrayList;

public class AldeanoRecolectandoOro implements EstadoAldeano{

	int cantidadDeOroRecolectado = 20;
	
	@Override
	public void repararEdificio(Mapa mapa, Celda celda, Edificio edificio) {
		throw new AldeanoRecolectandoOroException();
	}

	@Override
	public ArrayList<Zona> posiblesZonasAConstruirCuartel(Mapa mapa, Celda celda) {
		throw new AldeanoRecolectandoOroException();
	}
	
	@Override
	public ArrayList<Zona> posiblesZonasAConstruirPlazaCentral(Mapa mapa, Celda celda) {
		throw new AldeanoRecolectandoOroException();
	}

	@Override
	public int recolectarOro() {
		return cantidadDeOroRecolectado;
	}

	@Override
	public void construirCuartel(Zona zona, Mapa mapa) {
		throw new AldeanoRecolectandoOroException();
	}

	@Override
	public void construirPlazaCentral(Zona zona, Mapa mapa) {
		throw new AldeanoRecolectandoOroException();
	}

	public boolean aldeanoLibre(){
		return false;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		jugador.aumentarOro(this.recolectarOro());		
	}

}
