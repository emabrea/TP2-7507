package UnidadesTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.Espadachin;
import Modelo.Arquero;
import Modelo.Posicion;
import Modelo.Unidad;
import Modelo.Movimiento;

public class MovimientoYDireccionTest {
	@Test
		public void test01SeMueveAlaDerecha(){

			Mapa mapa = new Mapa(100,100);
		
			Posicion posicion = new Posicion(20, 20);

			Aldeano aldeano = new Aldeano(posicion);

			Posicion nuevaPosicion = posicion.trasladar(1,0);

			aldeano.mover(nuevaPosicion);

			Assert.assertTrue(mapa.posicionOcupada(nuevaPosicion));
			Assert.assertTrue(nuevaPosicion.equals(new Posicion(21,20)));
			Assert.assertFalse(mapa.posicionOcupada(posicion));			
			
		}


		public void test02SeMueveAlaIzquierda(){

			Mapa mapa = new Mapa(100,100);
		
			Posicion posicion = new Posicion(20, 20);

			Espadachin aldeano = new Espadachin(posicion);

			Posicion nuevaPosicion = posicion.trasladar(-1,0);

			aldeano.mover(nuevaPosicion);

			Assert.assertTrue(mapa.posicionOcupada(nuevaPosicion));
			Assert.assertTrue(nuevaPosicion.equals(new Posicion(19,20)));
			Assert.assertFalse(mapa.posicionOcupada(posicion));			
			
		}

		public void test03SeMueveArriba(){

			Mapa mapa = new Mapa(100,100);
		
			Posicion posicion = new Posicion(20, 20);

			Arquero aldeano = new Arquero(posicion);

			Posicion nuevaPosicion = posicion.trasladar(0,1);

			aldeano.mover(nuevaPosicion);

			Assert.assertTrue(mapa.posicionOcupada(nuevaPosicion));
			Assert.assertTrue(nuevaPosicion.equals(new Posicion(20,21)));
			Assert.assertFalse(mapa.posicionOcupada(posicion));			
			
		}


		public void test04SeMueveAbajo(){

			Mapa mapa = new Mapa(100,100);
		
			Posicion posicion = new Posicion(20, 20);

			Aldeano aldeano = new Aldeano(posicion);

			Posicion nuevaPosicion = posicion.trasladar(0,-1);

			aldeano.mover(nuevaPosicion);

			Assert.assertTrue(mapa.posicionOcupada(nuevaPosicion));
			Assert.assertTrue(nuevaPosicion.equals(new Posicion(20,19)));
			Assert.assertFalse(mapa.posicionOcupada(posicion));			
			
		}

		public void test05SeMueveALaDerechaArriba(){

			Mapa mapa = new Mapa(100,100);
		
			Posicion posicion = new Posicion(20, 20);

			Aldeano aldeano = new Aldeano(posicion);

			Posicion nuevaPosicion = posicion.trasladar(1,1);

			aldeano.mover(nuevaPosicion);

			Assert.assertTrue(mapa.posicionOcupada(nuevaPosicion));
			Assert.assertTrue(nuevaPosicion.equals(new Posicion(21,21)));
			Assert.assertFalse(mapa.posicionOcupada(posicion));			
			
		}

		public void test06SeMueveALaDerechaAbajo(){

			Mapa mapa = new Mapa(100,100);
		
			Posicion posicion = new Posicion(20, 20);

			Aldeano aldeano = new Aldeano(posicion);

			Posicion nuevaPosicion = posicion.trasladar(1,-1);

			aldeano.mover(nuevaPosicion);

			Assert.assertTrue(mapa.posicionOcupada(nuevaPosicion));
			Assert.assertTrue(nuevaPosicion.equals(new Posicion(21,19)));
			Assert.assertFalse(mapa.posicionOcupada(posicion));			
			
		}

		public void test07SeMueveALaIzquierdaArriba(){

			Mapa mapa = new Mapa(100,100);
		
			Posicion posicion = new Posicion(20, 20);

			Aldeano aldeano = new Aldeano(posicion);

			Posicion nuevaPosicion = posicion.trasladar(-1,1);

			aldeano.mover(nuevaPosicion);

			Assert.assertTrue(mapa.posicionOcupada(nuevaPosicion));
			Assert.assertTrue(nuevaPosicion.equals(new Posicion(19,21)));
			Assert.assertFalse(mapa.posicionOcupada(posicion));			
			
		}

		public void test08SeMueveALaIzquierdaAbajo(){

			Mapa mapa = new Mapa(100,100);
		
			Posicion posicion = new Posicion(20, 20);

			Arquero aldeano = new Arquero(posicion);

			Posicion nuevaPosicion = posicion.trasladar(-1,-1);

			aldeano.mover(nuevaPosicion);

			Assert.assertTrue(mapa.posicionOcupada(nuevaPosicion));
			Assert.assertTrue(nuevaPosicion.equals(new Posicion(19,19)));
			Assert.assertFalse(mapa.posicionOcupada(posicion));			
			
		}






}
