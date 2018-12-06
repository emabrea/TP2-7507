package Vista;

import Modelo.Juego.Posicion;

public class PosicionActual{

	Posicion posicion;

	private static PosicionActual instancia = new PosicionActual();

	public void actualizar(Posicion posicion){
		this.posicion = posicion;
	}

	public static PosicionActual obtenerInstancia(){
		return instancia;
	}

	public Posicion posicion(){
		return this.posicion;
	}



}