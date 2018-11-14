package Modelo;

public class Movimiento {

	public void moverArriba(Mapa mapa, Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarArriba();
		mapa.mover(celdaNueva);
		celda.desplazarArriba();
	}	
	public void moverAbajo(Mapa mapa, Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarAbajo();
		mapa.mover(celdaNueva);
		celda.desplazarAbajo();
	}
	public void moverDerecha(Mapa mapa, Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarDerecha();
		mapa.mover(celdaNueva);
		celda.desplazarDerecha();
	}
	public void moverIzquierda(Mapa mapa, Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarIzquierda();
		mapa.mover(celdaNueva);
		celda.desplazarIzquierda();
	}
	public void moverArribaDerecha(Mapa mapa, Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarArribaDerecha();
		mapa.mover(celdaNueva);
		celda.desplazarArribaDerecha();
	}
	public void moverArribaIzquierda(Mapa mapa, Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarArribaIzquierda();
		mapa.mover(celdaNueva);
		celda.desplazarArribaIzquierda();
	}
	public void moverAbajoDerecha(Mapa mapa, Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarAbajoDerecha();
		mapa.mover(celdaNueva);
		celda.desplazarAbajoDerecha();
	}
	public void moverAbajoIzquierda(Mapa mapa, Celda celda) {
		Celda celdaNueva = celda.crearCeldaIgual();
		celdaNueva.desplazarAbajoIzquierda();
		mapa.mover(celdaNueva);
		celda.desplazarAbajoIzquierda();
	}

}
