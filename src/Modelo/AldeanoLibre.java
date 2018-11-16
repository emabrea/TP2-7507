package Modelo;

public class AldeanoLibre implements EstadoAldeano{

	int cantidadDeOroRecolectado = 20;

	@Override
	public void repararEdificio(Aldeano aldeano, Edificio edificio) {
		if(!aldeano.posicionValidaParaRepararEdificio(edificio)){
			throw new AldeanoDebeEstarAlLadoDelEdificioARepararException();
		}
		aldeano.comienzaAReparar(edificio);
		aldeano.repararEdificio(edificio);
	}

	// No tiene sentido que exista un estado aldeano recolectando oro, este lo hace cuando esta libre.
	@Override
	public int recolectarOro() {
		return cantidadDeOroRecolectado;
	}


	// Terminar construirCuartel y contruirPlazaCentral -> similar a repararEdificio.
	@Override
	public void construirCuartel(Aldeano aldeano, Zona zona, Mapa mapa) {
		if(!aldeano.posicionValidaParaConstruirEdificioEnZona(zona)){
			throw new AldeanoDebeEstarAlLadoDeLaZonaParaPoderConstruirElEdificioException();
		}
		aldeano.comienzaAConstruirUnCuartelEnZona(zona);
		aldeano.construirCuartelEnZona(zona);
	}

	@Override
	public void construirPlazaCentral(Aldeano aldeano,Zona zona, Mapa mapa) {
		if(!aldeano.posicionValidaParaConstruirEdificioEnZona(zona)){
			throw new AldeanoDebeEstarAlLadoDeLaZonaParaPoderConstruirElEdificioException();
		}
		aldeano.comienzaAConstruirUnaPlazaCentralEnZona(zona);
		aldeano.construirPlazaCentralEnZona(zona);
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
