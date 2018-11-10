package PosicionesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.PosicionUnidad;

public class DesplazamientosDePosicionDeUnidad {

	@Test
	public void test01DesplazamientoHaciaLaDerechaUnCasillero(){
		
		PosicionUnidad posicion = new PosicionUnidad(0, 0);
		PosicionUnidad posicionDesplazada = new PosicionUnidad(1, 0);
		
		posicion.desplazarHorizontalmente(1);
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test02DesplazamientoHaciaLaIzquierdaUnCasillero(){
		
		PosicionUnidad posicion = new PosicionUnidad(0, 0);
		PosicionUnidad posicionDesplazada = new PosicionUnidad(-1, 0);
		
		posicion.desplazarHorizontalmente(-1);
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test03DesplazamientoHaciaArribaUnCasillero(){
		
		PosicionUnidad posicion = new PosicionUnidad(0, 0);
		PosicionUnidad posicionDesplazada = new PosicionUnidad(0, 1);
		
		posicion.desplazarVerticalmente(1);
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
	
	@Test
	public void test04DesplazamientoHaciaAbajoUnCasillero(){
		
		PosicionUnidad posicion = new PosicionUnidad(0, 0);
		PosicionUnidad posicionDesplazada = new PosicionUnidad(0, -1);
		
		posicion.desplazarVerticalmente(-1);
		
		Assert.assertTrue(posicion.igualA(posicionDesplazada));
	}
}
