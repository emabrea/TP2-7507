package MapaTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Aldeano;
import Modelo.Castillo;
import Modelo.Cuartel;
import Modelo.Mapa;
import Modelo.PlazaCentral;
import Modelo.PosicionEdificio;
import Modelo.PosicionUnidad;

public class ColocarUnidadesYEdificiosTest {

	@Test
	public void test01ColocarUnidadEnMapaVacioEnPosicionValida(){
		Mapa mapa = new Mapa();
		
		PosicionUnidad posicion = new PosicionUnidad(5, 6);
		
		mapa.insertar(new Aldeano(), posicion);
		
		Assert.assertTrue(mapa.posicionOcupada(posicion));
		
	}
	
	@Test
	public void test03ColocarCuartelEnPosicionValida(){
		Mapa mapa = new Mapa();
		
		Cuartel cuartel = new Cuartel();
		PosicionEdificio posicion = new PosicionEdificio(5, 6, cuartel.getTamanio());
		
		PosicionUnidad posicion1= new PosicionUnidad(5, 6);
		PosicionUnidad posicion2= new PosicionUnidad(5, 7);
		PosicionUnidad posicion3= new PosicionUnidad(6, 6);
		PosicionUnidad posicion4= new PosicionUnidad(6, 7);
		
		mapa.insertar(cuartel, posicion);
		
		Assert.assertTrue(mapa.posicionOcupada(posicion));
		
		Assert.assertTrue(mapa.posicionOcupada(posicion1));
		Assert.assertTrue(mapa.posicionOcupada(posicion2));
		Assert.assertTrue(mapa.posicionOcupada(posicion3));
		Assert.assertTrue(mapa.posicionOcupada(posicion4));			
	}

	
	@Test
	public void test05ColocarPlazaCentralEnMapaVacioEnPosicionValida(){
		Mapa mapa = new Mapa();
		
		PlazaCentral plazaCentral = new PlazaCentral();
		PosicionEdificio posicion = new PosicionEdificio(5, 6, plazaCentral.getTamanio());
		
		PosicionUnidad posicion1= new PosicionUnidad(5, 6);
		PosicionUnidad posicion2= new PosicionUnidad(5, 7);
		PosicionUnidad posicion3= new PosicionUnidad(6, 6);
		PosicionUnidad posicion4= new PosicionUnidad(6, 7);
		
		mapa.insertar(plazaCentral, posicion);
		
		Assert.assertTrue(mapa.posicionOcupada(posicion));
		
		Assert.assertTrue(mapa.posicionOcupada(posicion1));
		Assert.assertTrue(mapa.posicionOcupada(posicion2));
		Assert.assertTrue(mapa.posicionOcupada(posicion3));
		Assert.assertTrue(mapa.posicionOcupada(posicion4));			
	}

	
	@Test
	public void test07ColocarCastilloEnMapaAnchoYVacioEnPosicionValida(){
		Mapa mapa = Mapa.crearMapaAncho();
		
		Castillo castillo = new Castillo();
		PosicionEdificio posicion = new PosicionEdificio(0, 1, castillo.getTamanio());
		
		PosicionUnidad posicion1= new PosicionUnidad(0, 1);
		PosicionUnidad posicion2= new PosicionUnidad(0, 2);
		PosicionUnidad posicion3= new PosicionUnidad(0, 3);
		PosicionUnidad posicion4= new PosicionUnidad(0, 4);
		PosicionUnidad posicion5= new PosicionUnidad(1, 1);
		PosicionUnidad posicion6= new PosicionUnidad(1, 2);
		PosicionUnidad posicion7= new PosicionUnidad(1, 3);
		PosicionUnidad posicion8= new PosicionUnidad(1, 4);
		PosicionUnidad posicion9= new PosicionUnidad(2, 1);
		PosicionUnidad posicion10= new PosicionUnidad(2, 2);
		PosicionUnidad posicion11= new PosicionUnidad(2, 3);
		PosicionUnidad posicion12= new PosicionUnidad(2, 4);
		PosicionUnidad posicion13= new PosicionUnidad(3, 1);
		PosicionUnidad posicion14= new PosicionUnidad(3, 2);
		PosicionUnidad posicion15= new PosicionUnidad(3, 3);
		PosicionUnidad posicion16= new PosicionUnidad(3, 4);
		
		mapa.insertar(castillo, posicion);
		
		Assert.assertTrue(mapa.posicionOcupada(posicion));
		
		Assert.assertTrue(mapa.posicionOcupada(posicion1));
		Assert.assertTrue(mapa.posicionOcupada(posicion2));
		Assert.assertTrue(mapa.posicionOcupada(posicion3));
		Assert.assertTrue(mapa.posicionOcupada(posicion4));
		Assert.assertTrue(mapa.posicionOcupada(posicion5));
		Assert.assertTrue(mapa.posicionOcupada(posicion6));
		Assert.assertTrue(mapa.posicionOcupada(posicion7));
		Assert.assertTrue(mapa.posicionOcupada(posicion8));
		Assert.assertTrue(mapa.posicionOcupada(posicion9));
		Assert.assertTrue(mapa.posicionOcupada(posicion10));
		Assert.assertTrue(mapa.posicionOcupada(posicion11));
		Assert.assertTrue(mapa.posicionOcupada(posicion12));
		Assert.assertTrue(mapa.posicionOcupada(posicion13));
		Assert.assertTrue(mapa.posicionOcupada(posicion14));
		Assert.assertTrue(mapa.posicionOcupada(posicion15));
		Assert.assertTrue(mapa.posicionOcupada(posicion16));
	}

}
