package MapaTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Mapa;

public class TamanioTest {

		@Before
		public void reset(){
			Mapa.reset();
		}

		@Test
		public void test01TamanioDelMapa(){			
			
			Assert.assertEquals(Mapa.obtenerInstancia().getTamanioBase(), 50);
			Assert.assertEquals(Mapa.obtenerInstancia().getTamanioAltura(), 25);
		}
		
		
}
