package Modelo;

import java.util.ArrayList;

public class Aldeano extends Unidad{
	
	EstadoAldeano estado;

	public Aldeano(Celda celda, Jugador jugador){
		super(celda, 50, 25, jugador);
		this.estado = new AldeanoLibre();
	}
	
	public void actualizarEstado(EstadoAldeano estadoNuevo) {
		this.estado = estadoNuevo;
	}
	
	public void repararEdificio(Edificio edificio){
		this.estado.repararEdificio(this, edificio);
	}

	public ArrayList<Zona> posiblesZonasAConstruirCuartel(Mapa mapa){

		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();

		Celda celdaDeBusqueda = ((Celda)this.posicion).crearCeldaIgual();
		celdaDeBusqueda.desplazarVerticalmente(altura);
		celdaDeBusqueda.desplazarHorizontalmente(-base);

		Zona zonaDeBusqueda = new Zona(celdaDeBusqueda, 2 * base + 1, 2* altura + 1);

		ArrayList<Zona> zonasPosibles = mapa.buscarZonasPosibles(celdaDeBusqueda, zonaDeBusqueda, base, altura);

		if(zonasPosibles.isEmpty()){
			throw new NoEsPosibleConstruirException();
		}
		return zonasPosibles;
	}
	
	public ArrayList<Zona> posiblesZonasAConstruirPlazaCentral(Mapa mapa){

		int base = PlazaCentral.getTamanioBase();
		int altura = PlazaCentral.getTamanioAltura();

		Celda celdaDeBusqueda = ((Celda)this.posicion).crearCeldaIgual();
		celdaDeBusqueda.desplazarVerticalmente(altura);
		celdaDeBusqueda.desplazarHorizontalmente(-base);

		Zona zonaDeBusqueda = new Zona(celdaDeBusqueda, 2 * base + 1, 2* altura + 1);

		ArrayList<Zona> zonasPosibles = mapa.buscarZonasPosibles(celdaDeBusqueda, zonaDeBusqueda, base, altura);

		if(zonasPosibles.isEmpty()){
			throw new NoEsPosibleConstruirException();
		}
		return zonasPosibles;
	}
	
	public void construirCuartelEnZona(Zona unaZona, Mapa mapa){
		this.estado.construirCuartel(this, unaZona, mapa);
	}
	
	public void construirPlazaCentralEnZona(Zona unaZona, Mapa mapa){
		this.estado.construirPlazaCentral(this, unaZona, mapa);
	}
	
	public int recolectarOro(){
		return this.estado.recolectarOro();
	}

	public boolean posicionValidaParaRepararEdificio(Edificio edificio) {
		return edificio.estaAlLadoDe((Celda)this.posicion);
	}

	public void comienzaAReparar(Edificio edificio) {
		this.actualizarEstado(new AldeanoReparando(edificio));
	}

	public void desocuparse() {
		this.actualizarEstado(new AldeanoLibre());
	}

	public void realizarTareas(Jugador jugador){
		this.estado.realizarTareas(this,jugador);
	}

	public boolean Libre(){
		return this.estado.aldeanoLibre();
	}

	public boolean posicionValidaParaConstruirEdificioEnZona(Zona zona) {
		return zona.estaAlLadoDe(((Celda)this.posicion));
	}

	public void comienzaAConstruirUnCuartelEnZona(Zona zona) {
		this.actualizarEstado(new AldeanoConstruyendoCuartel(zona));
	}

	public void comienzaAConstruirUnaPlazaCentralEnZona(Zona zona) {
		this.actualizarEstado(new AldeanoConstruyendoPlazaCentral(zona));
	}
}
