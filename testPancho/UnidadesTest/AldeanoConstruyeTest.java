package UnidadesTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.Celda;
import Modelo.Mapa;
import Modelo.Zona;

public class AldeanoConstruyeTest {
	
	@Test
	public void test01AldeanoConstruyeCuartelLoConstruyeEnZonaASuLado(){
		
		Mapa mapa = new Mapa();
		Celda celda = new Celda(0, 0);
		Aldeano aldeano = new Aldeano(celda);
		
		mapa.insertar(celda);
	
		Assert.assertTrue(mapa.posicionOcupada(celda));
		
		// Retorna una zona de posibles posiciones para construir
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirCuartel(mapa);
		
		Zona zonaAConstruir = zonasPosibles.get(0);

		aldeano.construirCuartelEnZona(zonaAConstruir, mapa);
		
		Assert.assertTrue(mapa.posicionOcupada(celda));
		Assert.assertTrue(mapa.posicionOcupada(zonaAConstruir));
	}
	
	@Test
	public void test02AldeanoConstruyePlazaCentralLoConstruyeEnZonaASuLado(){
		
		Mapa mapa = new Mapa();
		Celda celda = new Celda(0, 0);
		Aldeano aldeano = new Aldeano(celda);
		
		mapa.insertar(celda);
	
		Assert.assertTrue(mapa.posicionOcupada(celda));
		
		// Retorna una zona de posibles posiciones para construir
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirPlazaCentral(mapa);
		
		Zona zonaAConstruir = zonasPosibles.get(0);

		aldeano.construirPlazaCentralEnZona(zonaAConstruir, mapa);
		
		Assert.assertTrue(mapa.posicionOcupada(celda));
		Assert.assertTrue(mapa.posicionOcupada(zonaAConstruir));
	}
		
}
