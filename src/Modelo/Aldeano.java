package Modelo;

import java.util.ArrayList;

public class Aldeano extends Unidad{
	
	EstadoAldeano estado;
	
	public Aldeano(Celda celda){
		super(celda, 50, 25);
		this.estado = new AldeanoLibre();
	}
	
	public void actualizarEstado(EstadoAldeano estadoNuevo) {
		this.estado = estadoNuevo;
	}
	
	public void repararEdificio(Mapa mapa, Edificio edificio){
		this.actualizarEstado(new AldeanoReparando());
		this.estado.repararEdificio(mapa, (Celda)this.posicion, edificio);
	}

	public ArrayList<Zona> posiblesZonasAConstruirCuartel(Mapa mapa){
		this.actualizarEstado(new AldeanoConstruyendoCuartel());
		ArrayList<Zona> posiblesZonas = this.estado.posiblesZonasAConstruirCuartel(mapa, (Celda)this.posicion);
		return posiblesZonas;
	}
	
	public ArrayList<Zona> posiblesZonasAConstruirPlazaCentral(Mapa mapa){
		this.actualizarEstado(new AldeanoConstruyendoPlazaCentral());
		ArrayList<Zona> posiblesZonas = this.estado.posiblesZonasAConstruirPlazaCentral(mapa, (Celda)this.posicion);
		return posiblesZonas;
	}
	
	public void construirCuartelEnZona(Zona unaZona, Mapa mapa){
		this.actualizarEstado(new AldeanoConstruyendoCuartel());
		this.estado.construirCuartel(unaZona, mapa);
	}
	
	public void construirPlazaCentralEnZona(Zona unaZona, Mapa mapa){
		this.actualizarEstado(new AldeanoConstruyendoPlazaCentral());
		this.estado.construirPlazaCentral(unaZona, mapa);
	}
	
	public int recolectarOro(){
		this.actualizarEstado(new AldeanoRecolectandoOro());
		int cantidadRecolectada = this.estado.recolectarOro();
		return cantidadRecolectada;
	}

	public void realizarTareas(){
		this.estado.realizarTareas(this);
	}

	public boolean Libre(){
		return this.estado.aldeanoLibre();

	}
	
}
