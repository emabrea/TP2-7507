package Modelo.Unidad;
import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;

public class Unidad extends Pieza{
	
	Movimiento movimiento;
	Boolean seHaMovido = false;

	public Unidad(Celda celda, int vida, int costo,Jugador jugador){
		super(celda, vida, costo,jugador);
		this.movimiento = new Movimiento();
	}
	
	public boolean estaEnPosicion(Celda celda) {
		return celda.igualA(this.posicion);
	}

	public void verificarMovimiento(Celda posicionAnterior){

		if(!posicionAnterior.igualA(this.posicion)){
			this.seHaMovido = true;			
		}	
	}

	public void habilitarMovimiento(){
		this.seHaMovido = false;
	}


	public void moverArriba(){
		
		if(!seHaMovido){
			Celda posicionAnterior = ((Celda)this.posicion).crearCeldaIgual();
			this.movimiento.moverArriba((Celda)this.posicion);
			this.verificarMovimiento(posicionAnterior);
		}
	}

	public void moverAbajo(){

		if(!seHaMovido){
			Celda posicionAnterior = ((Celda)this.posicion).crearCeldaIgual();
			this.movimiento.moverAbajo((Celda)this.posicion);
			this.verificarMovimiento(posicionAnterior);
		}

	}
	
	public void moverDerecha(){

		if(!seHaMovido){
			Celda posicionAnterior = ((Celda)this.posicion).crearCeldaIgual();
			this.movimiento.moverDerecha((Celda)this.posicion);
			this.verificarMovimiento(posicionAnterior);
		}
	}
	
	public void moverIzquierda(){
		
		if(!seHaMovido){
			Celda posicionAnterior = ((Celda)this.posicion).crearCeldaIgual();
			this.movimiento.moverIzquierda((Celda)this.posicion);
			this.verificarMovimiento(posicionAnterior);
		}
	}
	
	public void moverArribaDerecha(){
		
		if(!seHaMovido){
			Celda posicionAnterior = ((Celda)this.posicion).crearCeldaIgual();
			this.movimiento.moverArribaDerecha((Celda)this.posicion);
			this.verificarMovimiento(posicionAnterior);
		}
	}
	
	public void moverArribaIzquierda(){
				
		if(!seHaMovido){
			Celda posicionAnterior = ((Celda)this.posicion).crearCeldaIgual();
			this.movimiento.moverArribaIzquierda((Celda)this.posicion);
			this.verificarMovimiento(posicionAnterior);
		}

	}
	
	public void moverAbajoDerecha(){
		if(!seHaMovido){
			Celda posicionAnterior = ((Celda)this.posicion).crearCeldaIgual();
			this.movimiento.moverAbajoDerecha((Celda)this.posicion);
			this.verificarMovimiento(posicionAnterior);
		}
	}
	
	public void moverAbajoIzquierda(){
		
		if(!seHaMovido){
			Celda posicionAnterior = ((Celda)this.posicion).crearCeldaIgual();
			this.movimiento.moverAbajoIzquierda((Celda)this.posicion);
			this.verificarMovimiento(posicionAnterior);
		}

	}

	public void verificarVida(){
		if(this.vida < 1 ){
			this.jugador.eliminarPieza(this);
			Mapa.obtenerInstancia().eliminar(this.posicion);
		}
	}
}
