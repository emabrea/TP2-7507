package Modelo;

public class ArmaDeAsedio extends Unidad{

	EstadoArmaDeAsedio estado;
	
	public ArmaDeAsedio(Celda celda, Jugador jugador) {
		super(celda, 150, 200,jugador);
		this.estado = new ArmaDeAsedioDesmontada();
	}

	public void actualizarEstado(EstadoArmaDeAsedio estadoNuevo) {
		this.estado = estadoNuevo;
	}

	public void moverArriba(Mapa mapa){
		this.estado.moverArriba(mapa,this);
		super.moverArriba(mapa);
	}
	
	public void moverAbajo(Mapa mapa){
		this.estado.moverAbajo(mapa, this);
		super.moverAbajo(mapa);
	}
	
	public void moverDerecha(Mapa mapa){
		this.estado.moverDerecha(mapa, this);
		super.moverDerecha(mapa);
	}
	
	public void moverIzquierda(Mapa mapa){
		this.estado.moverIzquierda(mapa, this);
		super.moverIzquierda(mapa);
	}
	
	public void moverArribaDerecha(Mapa mapa){
		this.estado.moverArribaDerecha(mapa,this);
		super.moverArribaDerecha(mapa);
	}
	
	public void moverArribaIzquierda(Mapa mapa){
		this.estado.moverArribaIzquierda(mapa, this);
		super.moverArribaIzquierda(mapa);
	}
	
	public void moverAbajoDerecha(Mapa mapa){
		this.estado.moverAbajoDerecha(mapa, this);
		super.moverAbajoDerecha(mapa);
	}
	
	public void moverAbajoIzquierda(Mapa mapa){
		this.estado.moverAbajoIzquierda(mapa, this);
		super.moverAbajoIzquierda(mapa);
	}




}
