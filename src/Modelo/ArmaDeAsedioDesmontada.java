package Modelo;

public class ArmaDeAsedioDesmontada implements EstadoArmaDeAsedio{

	public void moverArriba(Mapa mapa,ArmaDeAsedio arma){
		arma.moverArriba(mapa);
	}
	
	public void moverAbajo(Mapa mapa,ArmaDeAsedio arma){
		arma.moverAbajo(mapa);
	}
	
	public void moverDerecha(Mapa mapa,ArmaDeAsedio arma){
		arma.moverDerecha(mapa);
	}
	
	public void moverIzquierda(Mapa mapa,ArmaDeAsedio arma){
		arma.moverIzquierda(mapa);
	}
	
	public void moverArribaDerecha(Mapa mapa,ArmaDeAsedio arma){
		arma.moverArribaDerecha(mapa);
	}
	
	public void moverArribaIzquierda(Mapa mapa,ArmaDeAsedio arma){
		arma.moverArribaIzquierda(mapa);
	}
	
	public void moverAbajoDerecha(Mapa mapa,ArmaDeAsedio arma){
		arma.moverAbajoDerecha(mapa);
	}
	
	public void moverAbajoIzquierda(Mapa mapa,ArmaDeAsedio arma){
		arma.moverAbajoIzquierda(mapa);
	}

}
