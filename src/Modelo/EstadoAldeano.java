package Modelo;

import java.util.ArrayList;

public interface EstadoAldeano {
	
	public void repararEdificio(Mapa mapa, Celda celda, Edificio edificio);
	public int recolectarOro();
	public ArrayList<Zona> posiblesZonasAConstruirCuartel(Mapa mapa, Celda celda);
	public ArrayList<Zona> posiblesZonasAConstruirPlazaCentral(Mapa mapa, Celda celda);
	public void construirCuartel(Zona zona, Mapa mapa);
	public void construirPlazaCentral(Zona zona, Mapa mapa);
	public void realizarTareas(Aldeano aldeano,Jugador jugador);
	public boolean aldeanoLibre();
}
