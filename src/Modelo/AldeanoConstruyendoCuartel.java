package Modelo;

public class AldeanoConstruyendoCuartel implements EstadoAldeano{

	final int turnosNecesarios = 3;
	int turnosConstruyendo;
	Zona zonaEnQueSeConstruye;

	public AldeanoConstruyendoCuartel(Zona zona) {
		this.zonaAconstruir = zona;
	}

	@Override
	public void repararEdificio(Aldeano aldeano, Edificio edificio) {
		throw new AldeanoConstruyendoException();
	}

	@Override
	public int recolectarOro() {
		throw new AldeanoEstaConstruyendoUnCuartelException();
	}
	// FALTA IMPLEMENTAR CONSTRUIR SIMILAR A REPARAR EDIFICIO
	@Override
	public void construirCuartel(Zona zona, Aldeano aldeano, Jugador jugador) {
		if(zona != this.zonaEnQueSeConstruye){
			throw new AldeanoEstaConstruyendoUnCuartelEnOtraZonaException();
		}
		else{
			throw new AldeanoYaEstaConstruyendoUnCuartelEnEsaZonaException();
		}
	}

	@Override
	public void construirPlazaCentral(Zona zona, Aldeano aldeano, Jugador jugador) {
		throw new AldeanoEstaConstruyendoUnCuartelException();
	}

	public boolean aldeanoLibre(){
		return false;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		this.turnosConstruyendo += 1;
		if(this.turnosConstruyendo == this.turnosNecesarios){
			Mapa.obtenerInstancia().insertar(this.zonaEnQueSeConstruye);
			Cuartel cuartel = new Cuartel(this.zonaEnQueSeConstruye.getCeldaArribaIzquierda(),jugador);
			jugador.agregarObjetivo(cuartel);
			aldeano.actualizarEstado(new AldeanoLibre());
		}
	}
}
