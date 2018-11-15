package Modelo;

public class AldeanoConstruyendoCuartel implements EstadoAldeano{

	int turnosConstruyendo ;
	Zona zonaAconstruir ;

	public AldeanoConstruyendoCuartel(Zona zona) {
		this.zonaAconstruir = zona;
	}

	@Override
	public void repararEdificio(Aldeano aldeano, Edificio edificio) {
		throw new AldeanoConstruyendoException();
	}

	@Override
	public int recolectarOro() {
		throw new AldeanoConstruyendoException();
	}
	// FALTA IMPLEMENTAR CONSTRUIR SIMILAR A REPARAR EDIFICIO
	@Override
	public void construirCuartel(Zona zona, Mapa mapa) {
		this.zonaAconstruir = zona;
		this.turnosConstruyendo = 0;
		mapa.insertar(zona);
	}

	@Override
	public void construirPlazaCentral(Zona zona, Mapa mapa) {
		throw new AldeanoConstruyendoException();
	}

	public boolean aldeanoLibre(){
		return false;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		this.turnosConstruyendo += 1;
		if(this.turnosConstruyendo == 3 ){
			jugador.agregarObjetivo(new Cuartel(this.zonaAconstruir.getCeldaArribaIzquierda())) ;
			aldeano.actualizarEstado(new AldeanoLibre());
		}

	}
}
