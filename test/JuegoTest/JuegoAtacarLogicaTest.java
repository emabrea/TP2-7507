package JuegoTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;

public class JuegoAtacarLogicaTest {	

	@Before
	public void reset(){
		Mapa.reset();
	}

	@Test
	public void test01JugadoresNoPuedenAtacarPiezasPropias(){

		Juego juego = new Juego();
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();		

		Espadachin espadachin1 = new Espadachin(new Celda(4,4), jugador1);
		Espadachin espadachin2 = new Espadachin(new Celda(4,5), jugador1);

		jugador1.agregarPieza(espadachin1);
		jugador2.agregarPieza(espadachin2);

		try{
			espadachin1.atacar(espadachin2);
		}catch(NoEsPosibleAtacarPiezasPropias e){ }

		Arquero arquero = new Arquero(new Celda(4,3), jugador2);
		espadachin1.atacar(arquero);
		Assert.assertEquals(50,arquero.obtenerVida());
		
	}


	@Test
	public void test02LasPiezasSeEliminanAlNoTenerVida(){

		Juego juego = new Juego();
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();		

		Espadachin espadachin1 = new Espadachin(new Celda(4,4), jugador1);
		Espadachin espadachin2 = new Espadachin(new Celda(4,5), jugador2);

		jugador1.agregarPieza(espadachin1);
		jugador2.agregarPieza(espadachin2);

		Assert.assertEquals(jugador2.poblacion(),4);

		for(int i=0;i<4;i++){
			espadachin1.atacar(espadachin2); //75,50,25,0
		}

		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(new Celda(4,5)));
		Assert.assertEquals(jugador2.poblacion(),3);
		
	}




}