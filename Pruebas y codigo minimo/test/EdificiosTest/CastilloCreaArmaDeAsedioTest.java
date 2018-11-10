package EdificiosTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.ArmaDeAsedio;
import Modelo.Castillo;

public class CastilloCreaArmaDeAsedioTest {
	
	@Test
	public void test01CastilloCreaArmaDeAsedio(){
		Castillo castillo = new Castillo();
		
		ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();
		
		Assert.assertNotNull(armaDeAsedio);
	}

}
