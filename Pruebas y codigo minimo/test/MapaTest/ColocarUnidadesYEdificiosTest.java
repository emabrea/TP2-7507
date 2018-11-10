package MapaTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidad;

public class ColocarUnidadesYEdificiosTest {

	@Test
	public void test01ColocarUnidadEnMapaAnchoYVacioEnPosicionValida(){
		Mapa mapa = Mapa.crearMapaAncho();
		
		Posicion posicion = new Posicion(5, 6);
		
		mapa.insertar(new Unidad(), posicion);
		
		Assert.assertTrue(mapa.posicionOcupada(posicion));
		
	}
	
	@Test
	public void test01ColocarUnidadEnMapaAltoYVacioEnPosicionValida(){
		Mapa mapa = Mapa.crearMapaAlto();
		
		Posicion posicion = new Posicion(5, 6);
		
		mapa.insertar(new Unidad(), posicion);
		
		Assert.assertTrue(mapa.posicionOcupada(posicion));
		
	}
	
	
}
