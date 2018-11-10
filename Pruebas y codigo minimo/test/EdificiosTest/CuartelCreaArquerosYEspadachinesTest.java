package EdificiosTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Arquero;
import Modelo.Cuartel;
import Modelo.Espadachin;

public class CuartelCreaArquerosYEspadachinesTest {
	
	@Test
	public void test01CuartelCreaArquero(){
		Cuartel cuartel = new Cuartel();
		
		Arquero arquero = cuartel.crearArquero();
		
		Assert.assertNotNull(arquero);
	}
	
	@Test
	public void test02CuartelCreaEspadachin(){
		Cuartel cuartel = new Cuartel();
		
		Espadachin espadachin = cuartel.crearEspadachin();
		
		Assert.assertNotNull(espadachin);
	}
}
