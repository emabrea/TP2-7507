package UnidadesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.Celda;
import Modelo.Mapa;

public class AldeanoConstruyeTest {
	
	@Test
	public void test01AldeanoConstruyeCuartelLoConstruyeEnZonaASuLado(){
		
		Mapa mapa = new Mapa();
		Celda celda = new Celda(0, 0);
		Aldeano aldeano = new Aldeano(celda);
		
		Assert.assertTrue(mapa.posicionOcupada(celda));
		
		aldeano.construirCuartel(mapa);
	}
		
}
