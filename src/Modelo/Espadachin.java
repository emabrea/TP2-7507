package Modelo;

public class Espadachin extends Unidad implements AtacanteDeUnidades, AtacanteDeEdificios, UnidadAtacable{

	private int alcance = 1;

	public Espadachin(Celda celda,Jugador jugador) {
		super(celda, 100, 50,jugador);
	}

	public void atacar(UnidadAtacable unidadAtacable){
		if(!this.distanciaAObjetivoEsMenorIgualA(this.alcance,(Objetivo)unidadAtacable)){
			throw new NoEsPosibleAtacarUnidadFueraDelAlcanceException();
		}
		unidadAtacable.recibirDanio(this);
	}

	public void atacar(EdificioAtacable edificioAtacable){
		if(!this.distanciaAObjetivoEsMenorIgualA(this.alcance,(Objetivo)edificioAtacable)){
			throw new NoEsPosibleAtacarEdificioFueraDelAlcanceException();
		}
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
