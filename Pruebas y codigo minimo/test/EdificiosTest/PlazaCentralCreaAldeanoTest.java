package EdificiosTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.PlazaCentral;

public class PlazaCentralCreaAldeanoTest {

	@Test
	public void test01PlazaCentralCreaAldeano(){
		PlazaCentral plazaCentral = new PlazaCentral();
		
		Aldeano aldeano = plazaCentral.crearAldeano();
		
		Assert.assertNotNull(aldeano);
	}
}
