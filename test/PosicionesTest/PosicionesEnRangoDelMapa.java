package PosicionesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Celda;
import Modelo.Mapa;
import Modelo.Zona;

public class PosicionesEnRangoDelMapa {
	
	@Test
	public void test01CeldaEstaDentroDelRangoDelMapaEsTrue(){
		
		Mapa mapa = new Mapa();
		int base = mapa.getTamanioBase();
		int altura = mapa.getTamanioAltura();
		
		Celda celdaInterior = new Celda(5, 5);
		Celda celdaBorde1 = new Celda(0, 0);
		Celda celdaBorde2 = new Celda(base, altura);
		
		Assert.assertTrue(mapa.enRango(celdaInterior));
		Assert.assertTrue(mapa.enRango(celdaBorde1));
		Assert.assertTrue(mapa.enRango(celdaBorde2));
		
	}
	
	@Test
	public void test02CeldaNoEstaDentroDelRangoDelMapaEsFalse(){
		
		Mapa mapa = new Mapa();
		int base = mapa.getTamanioBase();
		int altura = mapa.getTamanioAltura();
		
		Celda celda1 = new Celda(-1, 0);
		Celda celda2 = new Celda(base + 1, 0);
		Celda celda3 = new Celda(0, -1);
		Celda celda4 = new Celda(0, altura + 1);
		
		Assert.assertFalse(mapa.enRango(celda1));
		Assert.assertFalse(mapa.enRango(celda2));
		Assert.assertFalse(mapa.enRango(celda3));
		Assert.assertFalse(mapa.enRango(celda4));
	}
	
	@Test
	public void test03ZonaEstaEnElInteriorDelRangoDelMapaEsTrue(){
		
		Mapa mapa = new Mapa();
		
		Celda celdaInicial = new Celda(5, 5);
		Zona zona = new Zona(celdaInicial, 2, 2);
		
		Assert.assertTrue(mapa.enRango(zona));	
	}
	
	@Test
	public void test04ZonaEstaEnElBordeDelRangoDelMapaEsTrue(){
		
		Mapa mapa = new Mapa();
		int base = mapa.getTamanioBase();
		int altura = mapa.getTamanioAltura();
		
		Celda celda1 = new Celda(0, 0);
		Zona zona1 = new Zona(celda1, 2, 1);
		
		Celda celda2 = new Celda(base - 1, altura - 1);
		Zona zona2 = new Zona(celda2, 1, 2);
		
		Assert.assertTrue(mapa.enRango(zona1));
		Assert.assertTrue(mapa.enRango(zona2));
	}
	
	@Test
	public void test05ZonaCompletaAfueraDelRangoDelMapaEsFalse(){
		
		Mapa mapa = new Mapa();
		
		Celda celdaInicial = new Celda(-10, 0);
		Zona zona = new Zona(celdaInicial, 2, 2);		
		
		Assert.assertFalse(mapa.enRango(zona));
	}
	
	@Test
	public void test06ZonaConUnaSolaCeldaDentroDelRangoDelMapaEsFalse(){
		
		Mapa mapa = new Mapa();
		
		Celda celdaInicial = new Celda(-1, -1);
		Zona zona = new Zona(celdaInicial, 2, 2);		
		
		Assert.assertFalse(mapa.enRango(zona));
	}
	
	@Test
	public void test07ZonaConAlgunaCeldaAfueraDelRangoDelMapaEsFalse(){
		
		Mapa mapa = new Mapa();
		int base = mapa.getTamanioBase();
		int altura = mapa.getTamanioAltura();
		
		Celda celdaInicial = new Celda(base, altura);
		Zona zona = new Zona(celdaInicial, 2, 2);		
		
		Assert.assertFalse(mapa.enRango(zona));
	}
	
	@Test
	public void test08ZonaConSoloUnaCeldaAfueraDelRangoDelMapaEsFalse(){
		
		Mapa mapa = new Mapa();
		int altura = mapa.getTamanioAltura();
		
		Celda celdaInicial = new Celda(0, 0);
		Zona zona = new Zona(celdaInicial, 1, altura + 2);		
		
		Assert.assertFalse(mapa.enRango(zona));
	}
}
