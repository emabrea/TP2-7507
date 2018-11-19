package Modelo;

public interface EstadoArmaDeAsedio {

	public void moverArriba(Mapa mapa,ArmaDeAsedio arma);	
	public void moverAbajo(Mapa mapa,ArmaDeAsedio arma);	
	public void moverDerecha(Mapa mapa,ArmaDeAsedio arma);	
	public void moverIzquierda(Mapa mapa,ArmaDeAsedio arma);	
	public void moverArribaDerecha(Mapa mapa,ArmaDeAsedio arma);	
	public void moverArribaIzquierda(Mapa mapa,ArmaDeAsedio arma);	
	public void moverAbajoDerecha(Mapa mapa,ArmaDeAsedio arma);	
	public void moverAbajoIzquierda(Mapa mapa,ArmaDeAsedio arma);
}
