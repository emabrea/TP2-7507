package Modelo;

public class AldeanoConstruyendoPlazaCentral implements EstadoAldeano{

	final int turnosNecesarios = 3;
	int turnosConstruyendo ;
	Zona zonaEnQueSeConstruye ;

	public AldeanoConstruyendoPlazaCentral(Zona zona){
		this.zonaEnQueSeConstruye = zona;
		this.turnosConstruyendo = 0;
	}

	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano) {
		throw new AldeanoEstaConstruyendoPlazaCentralException();
	}	

	@Override
	public int recolectarOro() {
		throw new AldeanoEstaConstruyendoPlazaCentralException();
	}

	@Override
	public void construirCuartel(Zona zona,Aldeano aldeano,  Jugador jugador) {
		throw new AldeanoEstaConstruyendoPlazaCentralException();
	}

	@Override
	public void construirPlazaCentral(Zona zona,Aldeano aldeano, Jugador jugador) {
		if(zona != this.zonaEnQueSeConstruye){
			throw new AldeanoEstaConstruyendoUnaPlazaCentralEnOtraZonaException();
		}
		else{
			throw new AldeanoYaEstaConstruyendoUnaPlazaCentralEnEsaZonaException();
		}
		
	}

	public boolean aldeanoLibre(){
		return false;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		this.turnosConstruyendo += 1;
		if(this.turnosConstruyendo == this.turnosNecesarios ){
			Mapa.obtenerInstancia().insertar(this.zonaEnQueSeConstruye);
			PlazaCentral plazaCentral = new PlazaCentral(this.zonaEnQueSeConstruye.getCeldaArribaIzquierda(),jugador );
			jugador.agregarObjetivo(plazaCentral) ;
			aldeano.actualizarEstado(new AldeanoRecolectandoOro());
		}
	}
}
