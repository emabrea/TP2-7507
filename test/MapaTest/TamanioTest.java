package MapaTest;

import org.junit.Test;

import Modelo.Mapa;

public class TamanioTest {

		@Test
		public void test01LimitesMapa(){				
			Mapa mapa = new Mapa(100,100);

			Assert.assertTrue(mapa.casillaFueraDeRango(150,80));
			Assert.assertTrue(mapa.casillaFueraDeRango(0,80));
			Assert.assertTrue(mapa.casillaFueraDeRango(-8,50));
			Assert.assertTrue(mapa.casillaFueraDeRango(101,100));
			Assert.assertFalse(mapa.casillaFueraDeRango(100,100));
			Assert.assertFalse(mapa.casillaFueraDeRango(50,50));
		}	
				
}
