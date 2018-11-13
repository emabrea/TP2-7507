package Modelo;

public class AldeanoLibre implements EstadoAldeano{
	

	@Override
	public void repararEdificio(Mapa mapa, Celda celda, Edificio edificio, EstadoAldeano estadoActual) {
		estadoActual = new AldeanoReparando();
	}

	@Override
	public void construirPlazaCentral(Mapa mapa, Celda celda, EstadoAldeano estadoActual) {
		estadoActual = new AldeanoConstruyendoPlazaCentral();
	}
	
	@Override
	public void construirCuartel(Mapa mapa, Celda celda, EstadoAldeano estadoActual) {
		estadoActual = new AldeanoConstruyendoCuartel();
	}

	@Override
	public int recolectarOro(EstadoAldeano estadoActual) {
		estadoActual = new AldeanoRecolectandoOro();
		return 0;
	}

}
