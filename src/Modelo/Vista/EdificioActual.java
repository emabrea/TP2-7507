package Vista;

import Modelo.Edificio.*;

public class EdificioActual{
	Edificio edificio;

	private static EdificioActual instancia = new EdificioActual();

	public void actualizar(Edificio edificio){
		this.edificio = edificio;
	}

	public static EdificioActual obtenerInstancia(){
		return instancia;
	}

	public Edificio edificio(){
		return this.edificio;
	}

}