package Modelo;

public class AldeanoConstruyendoCuartel implements EstadoAldeano{

	@Override
	public void repararEdificio(Mapa mapa, Celda celda, Edificio edificio, EstadoAldeano estadoNuevo) {
		throw new AldeanoConstruyendoException();
	}

	@Override
	public void construirCuartel(Mapa mapa, Celda celda, EstadoAldeano estadoNuevo) {
		
	}
	
	@Override
	public void construirPlazaCentral(Mapa mapa, Celda celda, EstadoAldeano estadoNuevo) {
		throw new AldeanoConstruyendoException();
	}

	@Override
	public int recolectarOro(EstadoAldeano estadoNuevo) {
		throw new AldeanoConstruyendoException();
	}

}
