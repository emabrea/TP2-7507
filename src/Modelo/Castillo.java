package Modelo;

import java.util.ArrayList;

public class Castillo extends Edificio implements AtacanteDeEdificios,AtacanteDeUnidades, EdificioAtacable{

	private int alcance = 5;

	public Castillo(Celda celdaInicial, Jugador jugador) {
		super(new Zona(celdaInicial, base, altura), 1000, 0,jugador, 15, 0);
	}

	static int base = 4;
	static int altura = 4;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}
	
	public ArrayList<Celda> posiblesCeldasParaCrearArmaDeAsedio(){
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2);
		 
		if(celdasPosibles.isEmpty()){
			throw new NoSePuedeCrearElArmaDeAsedioCeldasPerifericasOcupadasException();
		}
		
		return celdasPosibles;
	}

	public void crearArmaDeAsedio(Celda celda) {
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celda, this.jugador);
		this.jugador.agregarObjetivo(armaDeAsedio);
		Mapa.obtenerInstancia().insertar(celda);
	}

	public boolean derrumbado() {
		return (this.vida < 1);
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
		this.reducirVidaEn(10);
	}

	public void recibirDanio(Espadachin espadachin){
		this.reducirVidaEn(15);
	}

	public void recibirDanio(ArmaDeAsedio armaDeAsedio){
		this.reducirVidaEn(75);
	}

	public void recibirDanio(Castillo castillo){
		this.reducirVidaEn(20);
	}

}
