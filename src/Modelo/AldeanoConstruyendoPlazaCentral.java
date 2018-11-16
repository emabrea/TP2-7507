package Modelo;

public class AldeanoConstruyendoPlazaCentral implements EstadoAldeano{

	final int turnosNecesarios = 3;
	int turnosConstruyendo;
	Zona zonaEnQueSeConstruye;

	public AldeanoConstruyendoPlazaCentral(Zona zona) {
		this.zonaAconstruir = zona;
	}

	@Override
	public void repararEdificio(Aldeano aldeano, Edificio edificio) {
		throw new AldeanoConstruyendoException();
	}

	@Override
	public int recolectarOro() {
		throw new AldeanoEstaConstruyendoPlazaCentralException();
	}

	// FALTA IMPLEMENTAR CONSTRUIR SIMILAR A REPARAR EDIFICIO

	@Override
	public void construirCuartel(Zona zona, Aldeano aldeano, Jugador jugador) {
		throw new AldeanoEstaConstruyendoPlazaCentralException();
	}

	@Override
	public void construirPlazaCentral(Zona zona, Aldeano aldeano, Jugador jugador) {
		if(zona != this.zonaEnQueSeConstruye){
			throw new AldeanoEstaConstruyendoUnaPlazaCentralEnOtraZonaException();
		}
		else{
			throw new AldeanoYaEstaConstruyendoUnaPlazaCentralEnEsaZonaException();
		}
	}

	@Override
	public boolean aldeanoLibre(){
		return false;
	}

	@Override
	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		this.turnosConstruyendo += 1;
		if(this.turnosConstruyendo == this.turnosNecesarios){
			Mapa.obtenerInstancia().insertar(this.zonaEnQueSeConstruye);
			PlazaCentral plazaCentral = new PlazaCentral(this.zonaEnQueSeConstruye.getCeldaArribaIzquierda(),jugador);
			jugador.agregarObjetivo(plazaCentral);
			aldeano.actualizarEstado(new AldeanoLibre());
		}
	}
}
