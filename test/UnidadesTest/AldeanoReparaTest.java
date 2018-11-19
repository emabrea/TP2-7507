package UnidadesTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.Aldeano;
import Modelo.Celda;
import Modelo.Mapa;
import Modelo.Zona;
import Modelo.Jugador;
import Modelo.Edificio;
import Modelo.EdificioSiendoReparado;

public class AldeanoReparaTest {

	@Before
	public void reset(){
		Mapa.reset();
	}

	@Test
	public void test01AldeanoReparaCuartel(){		
		
		Celda celda = new Celda(15, 15);
		Jugador jugador1 = new Jugador(100);

		Aldeano aldeano = new Aldeano(celda,jugador1);
		Mapa.obtenerInstancia().insertar(celda);
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirCuartel();
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirCuartelEnZona(zonaAConstruir);

		aldeano.realizarTareas();
		aldeano.realizarTareas();
		aldeano.realizarTareas();

		Assert.assertTrue(aldeano.Libre());

		Edificio cuartel = jugador1.obtenerEdificio();

		Assert.assertTrue(cuartel.vidaActual()==250);
		cuartel.recibirDanio(100);
		Assert.assertTrue(cuartel.vidaActual()==150);
		aldeano.repararEdificio(cuartel);
		aldeano.realizarTareas();
		Assert.assertTrue(cuartel.vidaActual()==200);
		aldeano.realizarTareas();
		Assert.assertTrue(cuartel.vidaActual()==250);		
		Assert.assertTrue(aldeano.Libre());		
	}


	@Test
	public void test02AldeanoReparaPlazaCentral(){		
		
		Celda celda = new Celda(15, 15);
		Jugador jugador1 = new Jugador(100);

		Aldeano aldeano = new Aldeano(celda,jugador1);
		Mapa.obtenerInstancia().insertar(celda);
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirCuartel();
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirPlazaCentralEnZona(zonaAConstruir);

		aldeano.realizarTareas();
		aldeano.realizarTareas();
		aldeano.realizarTareas();

		Assert.assertTrue(aldeano.Libre());

		Edificio plaza = jugador1.obtenerEdificio();

		Assert.assertTrue(plaza.vidaActual()==450);
		plaza.recibirDanio(70);
		Assert.assertTrue(plaza.vidaActual()==380);
		aldeano.repararEdificio(plaza);
		aldeano.realizarTareas();
		Assert.assertTrue(plaza.vidaActual()==405);
		aldeano.realizarTareas();
		Assert.assertTrue(plaza.vidaActual()==430);		
		aldeano.realizarTareas();
		Assert.assertTrue(plaza.vidaActual()==450);		
		Assert.assertTrue(aldeano.Libre());		
	}

	@Test
	public void test03CuartelNoPuedeSerReparadoPorDosAldenos(){		
		
		Celda celda = new Celda(15, 15);
		Jugador jugador1 = new Jugador(100);

		Aldeano aldeano = new Aldeano(celda,jugador1);
		Mapa.obtenerInstancia().insertar(celda);
		ArrayList<Zona> zonasPosibles = aldeano.posiblesZonasAConstruirCuartel();
		Zona zonaAConstruir = zonasPosibles.get(0);
		aldeano.construirCuartelEnZona(zonaAConstruir);

		aldeano.realizarTareas();
		aldeano.realizarTareas();
		aldeano.realizarTareas();

		Assert.assertTrue(aldeano.Libre());

		Edificio cuartel = jugador1.obtenerEdificio();

		Assert.assertTrue(cuartel.vidaActual()==250);
		cuartel.recibirDanio(70);
		
		aldeano.repararEdificio(cuartel);
		aldeano.realizarTareas();
		
		Aldeano aldeano2= new Aldeano(new Celda(14, 15),jugador1);

		try{
			aldeano.repararEdificio(cuartel);			//ya lo esta reparando  
		} catch(EdificioSiendoReparado e){ }
		
		try{
			aldeano2.repararEdificio(cuartel);			//ya lo esta reparando otro
		} catch(EdificioSiendoReparado e){ }

		Assert.assertTrue(cuartel.vidaActual()==230);
		aldeano.realizarTareas();

		Assert.assertTrue(cuartel.vidaActual()==250);
		Assert.assertTrue(aldeano.Libre());
		

		aldeano2.repararEdificio(cuartel);				//ya no lo esta reparando otro
		aldeano2.realizarTareas();						//se libera al no tener nada que reparar
		cuartel.recibirDanio(170);
		Assert.assertTrue(aldeano2.Libre());
		
				
			
	}
}
