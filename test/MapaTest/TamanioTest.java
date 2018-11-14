package MapaTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Mapa;

public class TamanioTest {

		@Test
		public void test01TamanioDelMapa(){
			Mapa mapa = new Mapa();
			
			Assert.assertEquals(mapa.getTamanioBase(), 50);
			Assert.assertEquals(mapa.getTamanioAltura(), 25);
		}
		
		
}
