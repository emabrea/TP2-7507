package UnidadesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.ArmaDeAsedio;
import Modelo.Celda;
import Modelo.CeldaInvalidaException;
import Modelo.CeldaOcupadaException;
import Modelo.Espadachin;
import Modelo.Mapa;
import Modelo.Arquero;

public class MovimientoYDireccionTest {

	@Test
	public void test01MoverUnidadUnCasilleroHaciaArribaYCasilleroEsValidoEsTrue(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		unidad.moverArriba(mapa);
		
		Celda celdaNueva = new Celda(0, 1);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertFalse(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test02MoverUnidadUnCasilleroHaciaAbajoYCasilleroEsValidoEsTrue(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 1);
		Aldeano unidad = new Aldeano(celdaInicial);
		
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		unidad.moverAbajo(mapa);
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(0, 1);
		
		Assert.assertFalse(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
		
	}
	
	@Test
	public void test03MoverUnidadUnCasilleroHaciaLaDerechaYCasilleroEsValidoEsTrue(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		unidad.moverDerecha(mapa);
		
		Celda celdaNueva = new Celda(1, 0);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertFalse(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test04MoverUnidadUnCasilleroHaciaArribaYCasilleroEsValidoEsTrue(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(1, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		unidad.moverIzquierda(mapa);
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(1, 0);
		
		Assert.assertFalse(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test05MoverUnidadUnCasilleroHaciaArribaIzquierdaYCasilleroEsValidoEsTrue(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(1, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		unidad.moverArribaIzquierda(mapa);
		
		Celda celdaNueva = new Celda(0, 1);
		Celda celdaVieja = new Celda(1, 0);
		
		Assert.assertFalse(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test06MoverUnidadUnCasilleroHaciaArribaDerechaYCasilleroEsValidoEsTrue(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 0);
		Espadachin unidad = new Espadachin(celdaInicial);
		
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		unidad.moverArribaDerecha(mapa);
		
		Celda celdaNueva = new Celda(1, 1);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertFalse(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test07MoverUnidadUnCasilleroHaciaAbajoIzquierdaYCasilleroEsValidoEsTrue(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(1, 1);
		ArmaDeAsedio unidad = new ArmaDeAsedio(celdaInicial);
		
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		unidad.moverAbajoIzquierda(mapa);
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(1, 1);
		
		Assert.assertFalse(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test08MoverUnidadUnCasilleroHaciaAbajoDerechaYCasilleroEsValidoEsTrue(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 1);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		unidad.moverAbajoDerecha(mapa);
		
		Celda celdaNueva = new Celda(1, 0);
		Celda celdaVieja = new Celda(0, 1);
		
		Assert.assertFalse(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaNueva));
	}
	
	@Test
	public void test09MoverUnidadUnCasilleroHaciaArribaYCasilleroEstaOcupadoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 0);
		Celda celdaOcupar = new Celda(0, 1);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaOcupar);
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaOcupar));
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArriba(mapa);
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 1);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test10MoverUnidadUnCasilleroHaciaArribaYCasilleroEsInvalidoEsFalse(){
		
		Mapa mapa = new Mapa();
		int altura = mapa.getTamanioAltura();
		Celda celdaInicial = new Celda(0, altura);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
	
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArriba(mapa);
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, altura);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test11MoverUnidadUnCasilleroHaciaAbajoYCasilleroEstaOcupadoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 1);
		Celda celdaOcupar = new Celda(0, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaOcupar);
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaOcupar));
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajo(mapa);
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(0, 1);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test12MoverUnidadUnCasilleroHaciaAbajoYCasilleroEsInvalidoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
	
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajo(mapa);
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test13MoverUnidadUnCasilleroHaciaLaDerechaYCasilleroEstaOcupadoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 0);
		Celda celdaOcupar = new Celda(1, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaOcupar);
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaOcupar));
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverDerecha(mapa);
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(1, 0);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test14MoverUnidadUnCasilleroHaciaLaDerechaYCasilleroEsInvalidoEsFalse(){
		
		Mapa mapa = new Mapa();
		int base = mapa.getTamanioBase();
		Celda celdaInicial = new Celda(base, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
	
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverDerecha(mapa);
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(base, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test15MoverUnidadUnCasilleroHaciaLaIzquierdaYCasilleroEstaOcupadoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(1, 0);
		Celda celdaOcupar = new Celda(0, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaOcupar);
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaOcupar));
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverIzquierda(mapa);
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(1, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test16MoverUnidadUnCasilleroHaciaLaIzquierdaYCasilleroEsInvalidoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
	
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverIzquierda(mapa);
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test17MoverUnidadUnCasilleroHaciaArribaDerechaYCasilleroEstaOcupadoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 0);
		Celda celdaOcupar = new Celda(1, 1);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaOcupar);
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaOcupar));
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArribaDerecha(mapa);
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(1, 1);
		Celda celdaVieja = new Celda(0, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test18MoverUnidadUnCasilleroHaciaArribaDerechaYCasilleroEsInvalidoEsFalse(){
		
		Mapa mapa = new Mapa();
		int altura = mapa.getTamanioAltura();
		Celda celdaInicial = new Celda(0, altura);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
	
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArribaDerecha(mapa);
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, altura);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test19MoverUnidadUnCasilleroHaciaArribaIzquierdaYCasilleroEstaOcupadoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(1, 0);
		Celda celdaOcupar = new Celda(0, 1);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaOcupar);
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaOcupar));
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArribaIzquierda(mapa);
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 1);
		Celda celdaVieja = new Celda(1, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test20MoverUnidadUnCasilleroHaciaArribaIzquierdaYCasilleroEsInvalidoEsFalse(){
		
		Mapa mapa = new Mapa();
		int altura = mapa.getTamanioAltura();
		Celda celdaInicial = new Celda(0, altura);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
	
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverArriba(mapa);
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(0, altura);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test21MoverUnidadUnCasilleroHaciaAbajoDerechaYCasilleroEstaOcupadoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(0, 1);
		Celda celdaOcupar = new Celda(1, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaOcupar);
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaOcupar));
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajoDerecha(mapa);
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(1, 0);
		Celda celdaVieja = new Celda(0, 1);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test22MoverUnidadUnCasilleroHaciaAbajoDerechaYCasilleroEsInvalidoEsFalse(){
		
		Mapa mapa = new Mapa();
		int base = mapa.getTamanioAltura();
		Celda celdaInicial = new Celda(base, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
	
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajoDerecha(mapa);
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(base, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test23MoverUnidadUnCasilleroHaciaAbajoIzquierdaYCasilleroEstaOcupadoEsFalse(){
		
		Mapa mapa = new Mapa();
		Celda celdaInicial = new Celda(1, 1);
		Celda celdaOcupar = new Celda(0, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaOcupar);
		mapa.insertar(celdaInicial);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaOcupar));
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajoIzquierda(mapa);
		} catch (CeldaOcupadaException e) { }
		
		Celda celdaNueva = new Celda(0, 0);
		Celda celdaVieja = new Celda(1, 1);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(mapa.posicionOcupada(celdaNueva));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
	
	@Test
	public void test24MoverUnidadUnCasilleroHaciaArribaYCasilleroEsInvalidoEsFalse(){
		
		Mapa mapa = new Mapa();
		int base = mapa.getTamanioAltura();
		Celda celdaInicial = new Celda(base, 0);
		Arquero unidad = new Arquero(celdaInicial);
		
		mapa.insertar(celdaInicial);
	
		Assert.assertTrue(mapa.posicionOcupada(celdaInicial));
		
		try{
			unidad.moverAbajoIzquierda(mapa);
		} catch (CeldaInvalidaException e) { }
		
		Celda celdaVieja = new Celda(base, 0);
		
		Assert.assertTrue(mapa.posicionOcupada(celdaVieja));
		Assert.assertTrue(unidad.estaEnPosicion(celdaVieja));
	}
}
