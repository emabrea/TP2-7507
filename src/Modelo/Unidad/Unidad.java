package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;

public class Unidad extends Pieza {
	
	Movimiento movimiento;
	
	public Unidad(Celda celda, int vida, int costo,Jugador jugador){
		super(celda, vida, costo,jugador);
		this.movimiento = new Movimiento();
	}
	
	public boolean estaEnPosicion(Celda celda) {
		return celda.igualA(this.posicion);
	}

	public void moverArriba(){
		this.movimiento.moverArriba((Celda)this.posicion);
	}
	
	public void moverAbajo(){
		this.movimiento.moverAbajo((Celda)this.posicion);
	}
	
	public void moverDerecha(){
		this.movimiento.moverDerecha((Celda)this.posicion);
	}
	
	public void moverIzquierda(){
		this.movimiento.moverIzquierda((Celda)this.posicion);
	}
	
	public void moverArribaDerecha(){
		this.movimiento.moverArribaDerecha((Celda)this.posicion);
	}
	
	public void moverArribaIzquierda(){
		this.movimiento.moverArribaIzquierda((Celda)this.posicion);
	}
	
	public void moverAbajoDerecha(){
		this.movimiento.moverAbajoDerecha((Celda)this.posicion);
	}
	
	public void moverAbajoIzquierda(){
		this.movimiento.moverAbajoIzquierda((Celda)this.posicion);
	}

	public void verificarVida(){
		if(this.vida < 1 ){
			this.jugador.eliminarPieza(this);
			Mapa.obtenerInstancia().eliminar(this.posicion);
		}
	}
}
