package MapaTest;

import org.junit.Test;

import Modelo.Mapa;

public class TamanioTest {

		@Test
		public void test01MapaMasAnchoQueAlto(){
				
			Mapa mapa = Mapa.crearMapaAncho();
		}
		
		@Test
		public void test02MapaMasAltoQueAncho(){
			
			Mapa mapa = Mapa.crearMapaAlto();
		}
		
		
}
