package PosicionesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.Celda;
import Modelo.Cuartel;
import Modelo.Insertable;
import Modelo.PosicionEdificio;
import Modelo.PosicionUnidad;

public class IgualacionConCelda {
	
	@Test
	public void test01IgualacionPosicionUnidadConCeldaQueGuardaUnaUnidadYPosicionesSonIgualesEsTrue(){
		
		Insertable unidad = new Aldeano();
		PosicionUnidad posicion = new PosicionUnidad(0, 0);
		
		Celda celda = new Celda(unidad, posicion);
		
		PosicionUnidad posicionAIgualar = new PosicionUnidad(0, 0);
		
		Assert.assertTrue(posicionAIgualar.equals(celda));
		
	}
	
	@Test
	public void test02IgualacionPosicionUnidadConCeldaQueGuardaUnaUnidadYPosicionesSonDistintasEsFalse(){
		
		Insertable unidad = new Aldeano();
		PosicionUnidad posicion = new PosicionUnidad(0, 0);
		
		Celda celda = new Celda(unidad, posicion);
		
		PosicionUnidad posicionAIgualar = new PosicionUnidad(1, 0);
		
		Assert.assertFalse(posicionAIgualar.equals(celda));
		
	}
	
	@Test
	public void test03IgualacionPosicionUnidadConCeldaQueGuardaUnEdificioYPosicionesSonIgualesEsTrue(){
		
		Insertable edificio = new Cuartel();
		PosicionEdificio posicion = new PosicionEdificio(0, 0, 4);
		
		Celda celda = new Celda(edificio, posicion);
		
		PosicionUnidad posicion1 = new PosicionUnidad(0, 0);
		PosicionUnidad posicion2 = new PosicionUnidad(0, 1);
		PosicionUnidad posicion3 = new PosicionUnidad(1, 0);
		PosicionUnidad posicion4 = new PosicionUnidad(1, 1);
		
		Assert.assertTrue(posicion1.equals(celda));
		Assert.assertTrue(posicion2.equals(celda));
		Assert.assertTrue(posicion3.equals(celda));
		Assert.assertTrue(posicion4.equals(celda));
		
	}
	
	@Test
	public void test04IgualacionPosicionUnidadConCeldaQueGuardaUnEdificioYPosicionesSonDistintasEsFalse(){
		
		Insertable edificio = new Cuartel();
		PosicionEdificio posicion = new PosicionEdificio(0, 0, 4);
		
		Celda celda = new Celda(edificio, posicion);
		
		PosicionUnidad posicionUnidad = new PosicionUnidad(0, -1);
		
		Assert.assertFalse(posicionUnidad.equals(celda));
		
	}
	
	@Test
	public void test05IgualacionPosicionEdificioConCeldaQueGuardaUnaUnidadYPosicionesSonIgualesEsTrue(){
		
		Insertable edificio = new Cuartel();
		PosicionEdificio posicion = new PosicionEdificio(0, 0, 4);
		PosicionUnidad posicionUnidad = new PosicionUnidad(0, 0);
		
		Celda celda = new Celda(edificio, posicionUnidad);
		
		Assert.assertTrue(posicion.equals(celda));
	}
	
	@Test
	public void test06IgualacionPosicionEdificioConCeldaQueGuardaUnaUnidadYPosicionesSonDistintasEsFalse(){
		
		Insertable unidad = new Aldeano();
		PosicionEdificio posicion = new PosicionEdificio(0, 0, 4);
		PosicionUnidad posicionUnidad = new PosicionUnidad(0, -1);
		
		Celda celda = new Celda(unidad, posicionUnidad);
		
		Assert.assertFalse(posicion.equals(celda));
		
	}
	
	@Test
	public void test07IgualacionPosicionEdificioConCeldaQueGuardaUnEdificioYPosicionesSonIgualesEsTrue(){
		
		Insertable edificio = new Cuartel();
		PosicionEdificio posicion = new PosicionEdificio(0, 0, 4);
		PosicionEdificio posicionAIgualar = new PosicionEdificio(0, 0, 4);
		
		Celda celda = new Celda(edificio, posicion);
		
		Assert.assertTrue(posicionAIgualar.equals(celda));
	}
	
	@Test
	public void test08IgualacionPosicionEdificioConCeldaQueGuardaUnEdificioYPosicionesSonDistintas(){
		
		Insertable edificio = new Cuartel();
		PosicionEdificio posicion = new PosicionEdificio(0, 0, 4);
		PosicionEdificio posicionAIgualar = new PosicionEdificio(5, 5, 4);
		
		Celda celda = new Celda(edificio, posicion);
		
		Assert.assertFalse(posicionAIgualar.equals(celda));
	}
}
