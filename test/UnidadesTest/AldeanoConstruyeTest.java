package UnidadesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.AldeanoEstaOcupadoException;

public class AldeanoConstruyeTest {
	
		@Test
		public void test01AldeanoConstruyePlazaCentral(){
			Aldeano aldeano = new Aldeano();
			
			Assert.assertFalse(aldeano.estaOcupado());
			
			aldeano.construirPlazaCentral();
			
			Assert.assertTrue(aldeano.estaOcupado());
		}
		
		@Test
		public void test01AldeanoConstruyeCuartel(){
			Aldeano aldeano = new Aldeano();
			
			Assert.assertFalse(aldeano.estaOcupado());
			
			aldeano.construirCuartel();
			
			Assert.assertTrue(aldeano.estaOcupado());
		}
		
		@Test
		public void test02AldeanoConstruyendoYSeLoMandaAConstruir(){
			Aldeano aldeano = new Aldeano();
			
			aldeano.construirPlazaCentral();
			
			Assert.assertTrue(aldeano.estaOcupado());
			
			try{
				aldeano.construirCuartel();
			} catch(AldeanoEstaOcupadoException e) {}
			
		}
}
