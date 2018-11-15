package Modelo;

import java.util.ArrayList;

public class AldeanoConstruyendoCuartel implements EstadoAldeano{

	int turnosConstruyendo ;
	Zona zonaAconstruir ;

	@Override
	public void repararEdificio(Mapa mapa, Aldeano aldeano, Edificio edificio) {
		throw new AldeanoConstruyendoException();
	}

	@Override
	public ArrayList<Zona> posiblesZonasAConstruirCuartel(Mapa mapa, Celda celda) {
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		
		Celda celdaDeBusqueda = celda.crearCeldaIgual();
		celdaDeBusqueda.desplazarVerticalmente(altura);
		celdaDeBusqueda.desplazarHorizontalmente(-base);
		
		Zona zonaDeBusqueda = new Zona(celdaDeBusqueda, 2 * base + 1, 2* altura + 1);
		
		ArrayList<Zona> zonasPosibles = mapa.buscarZonasPosibles(celdaDeBusqueda, zonaDeBusqueda, base, altura);
		
		if(zonasPosibles.isEmpty()){
			throw new NoEsPosibleConstruirException();
		}
		return zonasPosibles;
	}

	@Override
	public ArrayList<Zona> posiblesZonasAConstruirPlazaCentral(Mapa mapa, Celda celda) {
		throw new AldeanoConstruyendoException();
	}

	@Override
	public int recolectarOro() {
		throw new AldeanoConstruyendoException();
	}

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
			aldeano.desocuparse();
		}

	}




}
