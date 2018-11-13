package MapaTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Mapa;
import Modelo.Zona;
import Modelo.Celda;
import Modelo.CeldaInvalidaException;
import Modelo.CeldaOcupadaException;

public class ColocarUnidadesYEdificiosTest {

	@Test
	public void test01ColocarUnidadEnMapaVacioEnPosicionValida(){
		Mapa mapa = new Mapa();
		
		Celda posicion = new Celda(5, 6);
		
		mapa.insertar(posicion);
		
		Assert.assertTrue(mapa.posicionOcupada(posicion));
		
	}
	
	@Test
	public void test02ColocarCuartelEnMapaAnchoYVacioEnPosicionValida(){
		Mapa mapa = new Mapa();
		
		Celda celdaInicial= new Celda(5, 6);
		Zona zona = new Zona(celdaInicial, 2, 2);
		
		Celda celda2= new Celda(5, 7);
		Celda celda3= new Celda(6, 6);
		Celda celda4= new Celda(6, 7);
		
		mapa.insertar(zona);
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		Assert.assertTrue(mapa.posicionOcupada(celda2));
		Assert.assertTrue(mapa.posicionOcupada(celda3));
		Assert.assertTrue(mapa.posicionOcupada(celda4));			
	}
	
	@Test
	public void test03ColocarPlazaCentralEnMapaVacioEnPosicionValida(){
		Mapa mapa = new Mapa();
		
		Celda celdaInicial= new Celda(5, 6);
		Zona zona = new Zona(celdaInicial, 2, 2);
		
		
		Celda celda2= new Celda(5, 7);
		Celda celda3= new Celda(6, 6);
		Celda celda4= new Celda(6, 7);
		
		mapa.insertar(zona);
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		Assert.assertTrue(mapa.posicionOcupada(celda2));
		Assert.assertTrue(mapa.posicionOcupada(celda3));
		Assert.assertTrue(mapa.posicionOcupada(celda4));			
	}
	
	@Test
	public void test04ColocarCastilloEnMapaVacioEnPosicionValida(){
		Mapa mapa = new Mapa();
		
		Celda celdaInicial= new Celda(0, 0);
		Zona zona = new Zona(celdaInicial, 4, 4);
		
		mapa.insertar(zona);
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < 4 ; j++){
				Assert.assertTrue(mapa.posicionOcupada(new Celda(i, j)));
			}
		}
		
	}
	
	@Test
	public void test05ColocarUnidadEnMapaVacioEnPosicionInvalida(){
		Mapa mapa = new Mapa();
		
		Celda celda = new Celda(-1, 0);
		
		try{
			mapa.insertar(celda);
		} catch(CeldaInvalidaException e) { }
		
	}
	
	@Test
	public void test06ColocarUnidadEnMapaVacioEnPosicionOcupada(){
		Mapa mapa = new Mapa();
		
		Celda celda = new Celda(0, 0);
		mapa.insertar(celda);
		
		try{
			mapa.insertar(celda);
		} catch(CeldaOcupadaException e) { }
		
	}
	
	@Test
	public void test07ColocarEdificioEnMapaVacioConAlgunaPosicionInvalida(){
		Mapa mapa = new Mapa();
		
		Celda celda = new Celda(-1, 0);
		Zona zona = new Zona(celda, 2, 2);
		
		try{
			mapa.insertar(zona);
		} catch(CeldaInvalidaException e) { }
		
	}
	
	@Test
	public void test08ColocarEdificioEnMapaConAlgunaPosicionOcupada(){
		Mapa mapa = new Mapa();
		
		Celda celda = new Celda(0, 0);
		Zona zona = new Zona(celda, 2, 2);
		mapa.insertar(celda);
		
		try{
			mapa.insertar(zona);
		} catch(CeldaOcupadaException e) { }
		
	}
	
}
