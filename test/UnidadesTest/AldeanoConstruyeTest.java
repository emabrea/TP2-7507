package UnidadesTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.Celda;
import Modelo.Mapa;
import Modelo.Zona;
import Modelo.Jugador;

public class AldeanoConstruyeTest {
	
	@Test
	public void test01AldeanoConstruyeCuartelLoConstruyeEnZonaASuLado(){
		
		Mapa mapa = new Mapa();
		Celda celda = new Celda(0, 0);
		Jugador jugador1 = new Jugador(100);

		Aldeano aldeano = new Aldeano(celda);
		Assert.assertTrue(aldeano.Libre());
		
		mapa.insertar(celda);	
		Assert.assertTrue(mapa.posicionOcupada(celda));
		
		// Retorna una zona de posibles posiciones para construir
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirCuartel(mapa);
		Assert.assertFalse(aldeano.Libre());
		
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirCuartelEnZona(zonaAConstruir, mapa);
		Assert.assertFalse(aldeano.Libre());

		//turno 1
		aldeano.realizarTareas(jugador1);
		Assert.assertFalse(aldeano.Libre());

		//turno 2
		aldeano.realizarTareas(jugador1);
		Assert.assertFalse(aldeano.Libre());

		//turno 3
		aldeano.realizarTareas(jugador1);
		Assert.assertTrue(aldeano.Libre());
		
		Assert.assertTrue(mapa.posicionOcupada(celda));
		Assert.assertTrue(mapa.posicionOcupada(zonaAConstruir));
	}
	
	@Test
	public void test02AldeanoConstruyePlazaCentralLoConstruyeEnZonaASuLado(){
		
		Mapa mapa = new Mapa();
		Celda celda = new Celda(0, 0);
		Jugador jugador1 = new Jugador(100);


		Aldeano aldeano = new Aldeano(celda);
		Assert.assertTrue(aldeano.Libre());
		
		mapa.insertar(celda);	
		Assert.assertTrue(mapa.posicionOcupada(celda));	
		
		
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirPlazaCentral(mapa);		
		Zona zonaAConstruir = zonasPosibles.get(0);

		aldeano.construirPlazaCentralEnZona(zonaAConstruir, mapa);
		Assert.assertFalse(aldeano.Libre());

		//turno 1
		aldeano.realizarTareas(jugador1);
		Assert.assertFalse(aldeano.Libre());

		//turno 2
		aldeano.realizarTareas(jugador1);
		Assert.assertFalse(aldeano.Libre());

		//turno 3
		aldeano.realizarTareas(jugador1);
		Assert.assertTrue(aldeano.Libre());
		
		Assert.assertTrue(mapa.posicionOcupada(celda));
		Assert.assertTrue(mapa.posicionOcupada(zonaAConstruir));
	}

	@Test
	public void test03AldeanoConstruyeEnTurnoCorrecto(){
		
		Mapa mapa = new Mapa();
		Celda celda1 = new Celda(0, 0);
		Celda celda2 = new Celda(10, 10);

		Jugador jugador1 = new Jugador(100);
		Jugador jugador2 = new Jugador(100);

		Aldeano aldeano1 = new Aldeano(celda1);
		Aldeano aldeano2 = new Aldeano(celda2);	
		mapa.insertar(celda1);	
		mapa.insertar(celda2);	
		
		
		ArrayList<Zona> zonasPosibles = aldeano1.posiblesZonasAConstruirPlazaCentral(mapa);		
		Zona zonaAConstruir = zonasPosibles.get(0);

		aldeano1.construirPlazaCentralEnZona(zonaAConstruir, mapa);

		Assert.assertFalse(aldeano1.Libre());
		Assert.assertTrue(aldeano2.Libre());

		//turno 1 jugador 1
		aldeano1.realizarTareas(jugador1);
		Assert.assertFalse(aldeano1.Libre());
		Assert.assertTrue(aldeano2.Libre());

		//turno 2 jugador 1
		aldeano1.realizarTareas(jugador1);
		Assert.assertFalse(aldeano1.Libre());
		Assert.assertTrue(aldeano2.Libre());

		//turno 3 jugador 1
		aldeano1.realizarTareas(jugador1);
		Assert.assertTrue(aldeano1.Libre());
		Assert.assertTrue(aldeano2.Libre());


		ArrayList<Zona> zonasPosibles2 = aldeano2.posiblesZonasAConstruirPlazaCentral(mapa);		
		Zona zonaAConstruir2 = zonasPosibles2.get(0);

		aldeano2.construirPlazaCentralEnZona(zonaAConstruir2, mapa);

		//turno 1 jugador 2
		aldeano2.realizarTareas(jugador2);
		Assert.assertTrue(aldeano1.Libre());
		Assert.assertFalse(aldeano2.Libre());
		
		Assert.assertTrue(mapa.posicionOcupada(celda1));
		Assert.assertTrue(mapa.posicionOcupada(celda2));
		Assert.assertTrue(mapa.posicionOcupada(zonaAConstruir));
	}


	@Test
	public void test04AldeanoConstruyeYElOroNoAumenta(){
		
		Mapa mapa = new Mapa();
		Celda celda = new Celda(0, 0);
		Jugador jugador = new Jugador(100);

		Aldeano aldeano = new Aldeano(celda);
		Assert.assertTrue(aldeano.Libre());

		mapa.insertar(celda);		
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirPlazaCentral(mapa);		
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirPlazaCentralEnZona(zonaAConstruir, mapa);
		
		Assert.assertTrue(jugador.cantidadDeOro()==100);

		//turno 1
		aldeano.realizarTareas(jugador);
		Assert.assertFalse(aldeano.Libre());

		Assert.assertTrue(jugador.cantidadDeOro()==100);
		
	}

	@Test
	public void test05AldeanoNoConstruyeYElOroAumenta(){
		
		Mapa mapa = new Mapa();
		Celda celda = new Celda(0, 0);
		Jugador jugador = new Jugador(100);
		mapa.insertar(celda);

		Aldeano aldeano = new Aldeano(celda);
		Assert.assertTrue(aldeano.Libre());		
		
		Assert.assertTrue(jugador.cantidadDeOro()==100);

		//turno 1
		aldeano.realizarTareas(jugador);
		Assert.assertFalse(aldeano.Libre());//esta recolectando oro

		Assert.assertFalse(jugador.cantidadDeOro()==100);
		Assert.assertTrue(jugador.cantidadDeOro()==120);

		//turno 2
		aldeano.realizarTareas(jugador);
		Assert.assertTrue(jugador.cantidadDeOro()==140);


		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirPlazaCentral(mapa);		
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirPlazaCentralEnZona(zonaAConstruir, mapa);

		//turno 3
		aldeano.realizarTareas(jugador);
		Assert.assertTrue(jugador.cantidadDeOro()==140);
		
	}

	@Test
	public void test06AumentaElOroLuegoDeConstruir(){
		
		Mapa mapa = new Mapa();
		Celda celda = new Celda(0, 0);
		Jugador jugador = new Jugador(100);
		mapa.insertar(celda);

		Aldeano aldeano = new Aldeano(celda);	

		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirPlazaCentral(mapa);		
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirPlazaCentralEnZona(zonaAConstruir, mapa);			

		//turno 1
		aldeano.realizarTareas(jugador);
		Assert.assertFalse(aldeano.Libre());
		Assert.assertTrue(jugador.cantidadDeOro()==100);

		//turno 2
		aldeano.realizarTareas(jugador);
		Assert.assertFalse(aldeano.Libre());
		Assert.assertTrue(jugador.cantidadDeOro()==100);

		//turno 3
		aldeano.realizarTareas(jugador);
		Assert.assertTrue(aldeano.Libre());
		Assert.assertTrue(jugador.cantidadDeOro()==100);

		//turno 4
		aldeano.realizarTareas(jugador);		
		Assert.assertTrue(jugador.cantidadDeOro()==120);
		
		
		
	}
	






	
		
}
