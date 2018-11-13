package Modelo;

public interface EstadoAldeano {
	
	public void repararEdificio(Mapa mapa, Celda celda, Edificio edificio, EstadoAldeano estadoActual);
	public int recolectarOro(EstadoAldeano estadoActual);
	public void construirCuartel(Mapa mapa, Celda celda, EstadoAldeano estadoActual);
	public void construirPlazaCentral(Mapa mapa, Celda celda, EstadoAldeano estadoActual);
}
