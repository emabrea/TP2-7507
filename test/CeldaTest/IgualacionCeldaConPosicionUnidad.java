package CeldaTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.Celda;
import Modelo.Cuartel;
import Modelo.Insertable;
import Modelo.PosicionEdificio;
import Modelo.PosicionUnidad;

public class IgualacionCeldaConPosicionUnidad {

	@Test
	public void test01IgualacionDeCeldaQueGuardaUnaUnidadConPosicionUnidadIgualEsTrue(){
		
		Insertable unidad = new Aldeano();
		PosicionUnidad posicionUnidad = new PosicionUnidad(0, 0);
	    
		Celda celda = new Celda(unidad, posicionUnidad);
		
		PosicionUnidad posicionAIgualar = new PosicionUnidad(0, 0);
		
		Assert.assertTrue(celda.equals(posicionAIgualar));
		
	}
	
	@Test
	public void test02IgualacionDeCeldaQueGuardaUnaUnidadConPosicionUnidadDistintaEsFalse(){
		
		Insertable unidad = new Aldeano();
		PosicionUnidad posicionUnidad = new PosicionUnidad(0, 0);
	    
		Celda celda = new Celda(unidad, posicionUnidad);
		
		PosicionUnidad posicionAIgualar = new PosicionUnidad(0, 1);
		
		Assert.assertFalse(celda.equals(posicionAIgualar));
		
	}
	
	@Test
	public void test03IgualacionDeCeldaQueGuardaUnEdificioConPosicionesUnidadIgualesEsTrue(){
		
		Insertable edificio = new Cuartel();
	    
		Celda celda = new Celda(edificio, new PosicionEdificio(0, 0, 4));
		
		PosicionUnidad posicion1 = new PosicionUnidad(0, 0);
		PosicionUnidad posicion2 = new PosicionUnidad(0, 1);
		PosicionUnidad posicion3 = new PosicionUnidad(1, 0);
		PosicionUnidad posicion4 = new PosicionUnidad(1, 1);
		
		Assert.assertTrue(celda.equals(posicion1));
		Assert.assertTrue(celda.equals(posicion2));
		Assert.assertTrue(celda.equals(posicion3));
		Assert.assertTrue(celda.equals(posicion4));
		
	}
	
	@Test
	public void test04IgualacionDeCeldaQueGuardaUnEdificioConPosicionDeUnidadDistintaEsFalse(){
		
		Insertable edificio = new Cuartel();
	    
		Celda celda = new Celda(edificio, new PosicionEdificio(0, 0, 4));
		
		PosicionUnidad posicionAIgualar = new PosicionUnidad(0, -1);
		
		Assert.assertFalse(celda.equals(posicionAIgualar));
		
	}
}
