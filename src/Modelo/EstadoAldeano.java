package Modelo;

public interface EstadoAldeano {
	
	public void repararEdificio(Aldeano aldeano, Edificio edificio);
	public int recolectarOro();
	public void construirCuartel(Aldeano aldeano,Zona zona, Mapa mapa);
	public void construirPlazaCentral(Aldeano aldeano, Zona zona, Mapa mapa);
	public void realizarTareas(Aldeano aldeano,Jugador jugador);
	public int recolectarOro();
	public boolean aldeanoLibre();
}
