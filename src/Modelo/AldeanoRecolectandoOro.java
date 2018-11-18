package Modelo;


public class AldeanoRecolectandoOro implements EstadoAldeano{
	int cantidadDeOroRecolectado = 20;
	
	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano) {
		if(!aldeano.posicionValidaParaRepararEdificio(edificio)){
			throw new AldeanoDebeEstarAlLadoDelEdificioARepararException();
		}
		aldeano.comienzaAReparar(edificio);		
	}	

	@Override
	public int recolectarOro() {
		return cantidadDeOroRecolectado;
	}

	@Override
	public void construirCuartel(Zona zona, Aldeano aldeano, Jugador jugador) {
		if(!aldeano.posicionValidaParaConstruirEdificio(zona)){
			throw new AldeanoDebeEstarAlLadoDeLaZonaParaPoderConstruirElEdificioException();
		}
		aldeano.comienzaAConstruirUnCuartelEnZona(zona);		
	}

	@Override
	public void construirPlazaCentral(Zona zona, Aldeano aldeano, Jugador jugador) {
		if(!aldeano.posicionValidaParaConstruirEdificio(zona)){
			throw new AldeanoDebeEstarAlLadoDeLaZonaParaPoderConstruirElEdificioException();
		}
		aldeano.comienzaAConstruirUnaPlazaCentralEnZona(zona);		
	}

	public boolean aldeanoLibre(){
		return true;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		jugador.aumentarOro(aldeano.recolectarOro());
	}

}
