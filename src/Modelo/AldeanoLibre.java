package Modelo;

public class AldeanoLibre implements EstadoAldeano{

	int cantidadDeOroRecolectado = 20;

	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano) {
		if(!aldeano.posicionValidaParaRepararEdificio(edificio)){
			throw new AldeanoDebeEstarAlLadoDelEdificioARepararException();
		}
		aldeano.comienzaAReparar(edificio);
		aldeano.realizarTareas();
	}

	@Override
	public int recolectarOro() {
		return cantidadDeOroRecolectado;
	}

	@Override
	public void construirCuartel(Zona zona, Aldeano aldeano, Jugador jugador) {
		if(!aldeano.posicionValidaParaConstruirEdificioEnZona(zona)){
			throw new AldeanoDebeEstarAlLadoDeLaZonaParaPoderConstruirElEdificioException();
		}
		aldeano.comienzaAConstruirUnCuartelEnZona(zona);
		aldeano.realizarTareas();
	}

	@Override
	public void construirPlazaCentral(Zona zona, Aldeano aldeano, Jugador jugador) {
		if(!aldeano.posicionValidaParaConstruirEdificioEnZona(zona)){
			throw new AldeanoDebeEstarAlLadoDeLaZonaParaPoderConstruirElEdificioException();
		}
		aldeano.comienzaAConstruirUnaPlazaCentralEnZona(zona);
		aldeano.realizarTareas();
	}

	@Override
	public boolean aldeanoLibre(){
		return true;
	}

	@Override
	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		jugador.aumentarOro(this.recolectarOro());
	}

}
