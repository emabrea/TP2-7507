package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;

public class ArmaDeAsedio extends Unidad implements AtacanteDeEdificios, UnidadAtacable {

	EstadoArmaDeAsedio estado;
	private int alcance = 5;

	public ArmaDeAsedio(Celda celda, Jugador jugador) {
		super(celda, 150, 200, jugador);
		this.estado = new ArmaDeAsedioDesmontada();
	}

	public void actualizarEstado(EstadoArmaDeAsedio estadoNuevo) {
		this.estado = estadoNuevo;
	}

	public void atacar(EdificioAtacable edificioAtacable) {
		if(((Pieza)edificioAtacable).esPiezaPropia(this.jugador)){
			throw new NoEsPosibleAtacarPiezasAmigas();
		}
		if(!this.distanciaAPiezaEsMenorIgualA(this.alcance,(Pieza)edificioAtacable)){
			throw new NoEsPosibleAtacarEdificioFueraDelAlcanceException();
		}
		edificioAtacable.recibirDanio(this);
	}

	public void recibirDanio(Arquero arquero) {
		this.reducirVidaEn(15);
		this.verificarVida();
	}

	public void recibirDanio(Espadachin espadachin) {
		this.reducirVidaEn(25);
		this.verificarVida();
	}

	public void recibirDanio(Castillo castillo) {
		this.reducirVidaEn(20);
		this.verificarVida();
	}

	public void moverArriba() {
		this.estado.moverArriba(this);
		super.moverArriba();
	}

	public void moverAbajo() {
		this.estado.moverAbajo(this);
		super.moverAbajo();
	}

	public void moverDerecha() {
		this.estado.moverDerecha(this);
		super.moverDerecha();
	}

	public void moverIzquierda() {
		this.estado.moverIzquierda(this);
		super.moverIzquierda();
	}

	public void moverArribaDerecha() {
		this.estado.moverArribaDerecha(this);
		super.moverArribaDerecha();
	}

	public void moverArribaIzquierda() {
		this.estado.moverArribaIzquierda(this);
		super.moverArribaIzquierda();
	}

	public void moverAbajoDerecha() {
		this.estado.moverAbajoDerecha(this);
		super.moverAbajoDerecha();
	}

	public void moverAbajoIzquierda(){
		this.estado.moverAbajoIzquierda(this);
		super.moverAbajoIzquierda();
	}
}
