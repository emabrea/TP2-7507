package PosicionesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.PosicionEdificio;
import Modelo.PosicionUnidad;

public class IgualacionEntrePosiciones {

	@Test
	public void test01IgualacionEntreDosPosicionesDeUnidadIgualesDariaTrue(){
		
		PosicionUnidad posicion1 = new PosicionUnidad(5, 5);
		PosicionUnidad posicion2 = new PosicionUnidad(5, 5);
		
		Assert.assertTrue(posicion1.igualA(posicion2));
	}
	
	@Test
	public void test02IgualacionEntreDosPosicionesDeUnidadDistintasDariaFalse(){
		
		PosicionUnidad posicion1 = new PosicionUnidad(5, 5);
		PosicionUnidad posicion2 = new PosicionUnidad(5, 6);
		
		Assert.assertFalse(posicion1.igualA(posicion2));
	}
	
	@Test
	public void test03IgualacionEntrePosicionDeEdificioYPosicionDeUnidad(){
		
		PosicionEdificio posicionEdificio = new PosicionEdificio(1, 2, 4);
		PosicionUnidad posicion1 = new PosicionUnidad(1, 2);
		PosicionUnidad posicion2 = new PosicionUnidad(1, 3);
		PosicionUnidad posicion3 = new PosicionUnidad(2, 2);
		PosicionUnidad posicion4 = new PosicionUnidad(2, 3);
		
		Assert.assertTrue(posicionEdificio.igualA(posicion1));
		Assert.assertTrue(posicionEdificio.igualA(posicion2));
		Assert.assertTrue(posicionEdificio.igualA(posicion3));
		Assert.assertTrue(posicionEdificio.igualA(posicion4));
	}
}
