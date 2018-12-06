package Vista;

import Modelo.Unidad.*;

public class UnidadActual{
	Unidad unidad;

	private static UnidadActual instancia = new UnidadActual();

	public void actualizar(Unidad unidad){
		this.unidad = unidad;
	}

	public static UnidadActual obtenerInstancia(){
		return instancia;
	}

	public Unidad unidad(){
		return this.unidad;
	}

}