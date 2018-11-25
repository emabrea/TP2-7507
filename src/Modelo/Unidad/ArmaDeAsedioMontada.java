package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;

public class ArmaDeAsedioMontada implements EstadoArmaDeAsedio{

	public void moverArriba(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverAbajo(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverDerecha(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverIzquierda(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverArribaDerecha(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverArribaIzquierda(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverAbajoDerecha(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}
	
	public void moverAbajoIzquierda(ArmaDeAsedio arma){
		throw new ArmaDeAsedioMontadaNoPuedeMoverse();
	}

}
