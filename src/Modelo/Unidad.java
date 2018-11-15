package Modelo;

public class Unidad extends Objetivo {
	
	Movimiento movimiento;
	
	public Unidad(Celda celda, int vida, int costo, Jugador jugador){
		super(celda, vida, costo, jugador);
		this.movimiento = new Movimiento();
	}
	
	public boolean estaEnPosicion(Celda celda) {
		return celda.igualA(this.posicion);
	}
	
	public void moverArriba(Mapa mapa){
		this.movimiento.moverArriba(mapa, (Celda)this.posicion);
	}
	
	public void moverAbajo(Mapa mapa){
		this.movimiento.moverAbajo(mapa, (Celda)this.posicion);
	}
	
	public void moverDerecha(Mapa mapa){
		this.movimiento.moverDerecha(mapa, (Celda)this.posicion);
	}
	
	public void moverIzquierda(Mapa mapa){
		this.movimiento.moverIzquierda(mapa, (Celda)this.posicion);
	}
	
	public void moverArribaDerecha(Mapa mapa){
		this.movimiento.moverArribaDerecha(mapa, (Celda)this.posicion);
	}
	
	public void moverArribaIzquierda(Mapa mapa){
		this.movimiento.moverArribaIzquierda(mapa, (Celda)this.posicion);
	}
	
	public void moverAbajoDerecha(Mapa mapa){
		this.movimiento.moverAbajoDerecha(mapa, (Celda)this.posicion);
	}
	
	public void moverAbajoIzquierda(Mapa mapa){
		this.movimiento.moverAbajoIzquierda(mapa, (Celda)this.posicion);
	}
	
}
