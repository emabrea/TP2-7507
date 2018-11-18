package Modelo;

import java.util.ArrayList;

public interface EstadoAldeano {
	
	public void repararEdificio(Edificio edificio,Aldeano aldeano);
	public int recolectarOro();	
	public void construirCuartel(Zona zona, Aldeano aldeano, Jugador jugador);
	public void construirPlazaCentral(Zona zona, Aldeano aldeano, Jugador jugador);
	public void realizarTareas(Aldeano aldeano,Jugador jugador);
	public boolean aldeanoLibre();
}
