package Modelo;

public class AldeanoRecolectandoOro implements EstadoAldeano{

	int cantidadDeOroRecolectado = 20;
	
	@Override
	public void repararEdificio(Mapa mapa, Celda celda, Edificio edificio, EstadoAldeano estadoNuevo) {
		throw new AldeanoReparandoException();
	}

	@Override
	public void construirCuartel(Mapa mapa, Celda celda, EstadoAldeano estadoNuevo) {
		throw new AldeanoReparandoException();
	}
	
	@Override
	public void construirPlazaCentral(Mapa mapa, Celda celda, EstadoAldeano estadoNuevo) {
		throw new AldeanoReparandoException();
	}

	@Override
	public int recolectarOro(EstadoAldeano estadoNuevo) {
		return cantidadDeOroRecolectado;
	}

}
