package Modelo;

public class Arquero extends Unidad implements AtacanteDeUnidades, AtacanteDeEdificios, UnidadAtacable{

	public Arquero(Celda celda, Jugador jugador) {
		super(celda, 75, 75,jugador);
	}

	public void atacar(UnidadAtacable unidadAtacable){
		unidadAtacable.recibirDanio(this);
	}

	public void atacar(EdificioAtacable edificioAtacable){
		edificioAtacable.recibirDanio(this);
	}

	public void recibirDanio(Arquero arquero){
		this.reducirVidaEn(15);
	}

	public void recibirDanio(Espadachin espadachin){
		this.reducirVidaEn(25);
	}

	public void recibirDanio(Castillo castillo){
		this.reducirVidaEn(20);
	}
}
