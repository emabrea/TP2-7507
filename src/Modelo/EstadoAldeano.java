package Modelo;

public interface EstadoAldeano {
	
	public void repararEdificio(Edificio edificio, Aldeano aldeano);
	public void construirCuartel(Zona zona, Aldeano aldeano, Jugador jugador);
	public void construirPlazaCentral(Zona zona, Aldeano aldeano, Jugador jugador);
	public void realizarTareas(Aldeano aldeano,Jugador jugador);
	public int recolectarOro();
	public boolean aldeanoLibre();
}
