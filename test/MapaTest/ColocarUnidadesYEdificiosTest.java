package MapaTest;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Posicion;
import Modelo.Mapa;
import Modelo.Cuartel;
import Modelo.PlazaCentral;
import Modelo.Castillo;

public class ColocarUnidadesYEdificiosTest {

	@Test
	public void test01ColocarUnidadEnMapaVacioEnPosicionValida(){
		Mapa mapa = new Mapa(100,100);
		
		Posicion posicion = new Posicion(5, 6);

		Aldeano aldeano = new Aldeano(posicion);		
		
		Assert.assertTrue(mapa.posicionOcupada(posicion));
		
	}
	
	@Test
	public void test02ColocarCuartelEnPosicionValida(){
		Mapa mapa = new Mapa(75,75);

		Posicion posicion1 = new Posicion(10, 10);

		Cuartel cuartel = new Cuartel(posicion1);	
		

		Posicion posicion2 = new Posicion(11, 10);
		Posicion posicion3 = new Posicion(10, 11);
		Posicion posicion4 = new Posicion(11, 11);	
		
		
		Assert.assertTrue(mapa.posicionOcupada(posicion1));
		Assert.assertTrue(mapa.posicionOcupada(posicion2));
		Assert.assertTrue(mapa.posicionOcupada(posicion3));
		Assert.assertTrue(mapa.posicionOcupada(posicion4));			
	}

	
	@Test
	public void test03ColocarPlazaCentralEnMapaVacioEnPosicionValida(){
		Mapa mapa = new Mapa(50,50);

		Posicion posicion1 = new Posicion(20, 20);

		PlazaCentral plaza = new PlazaCentral(posicion1);			
		

		Posicion posicion2 = new Posicion(21, 20);
		Posicion posicion3 = new Posicion(20, 21);
		Posicion posicion4 = new Posicion(21, 21);	
		
		
		Assert.assertTrue(mapa.posicionOcupada(posicion1));
		Assert.assertTrue(mapa.posicionOcupada(posicion2));
		Assert.assertTrue(mapa.posicionOcupada(posicion3));
		Assert.assertTrue(mapa.posicionOcupada(posicion4));				
	}

	
	@Test
	public void test04ColocarCastilloEnMapaAnchoYVacioEnPosicionValida(){
		Mapa mapa = Mapa.crearMapaAncho(40,40);

		Posicion posicionInicial = new Posicion(5, 5);
		Castillo castillo = new Castillo(posicionInicial);
		

		for(int i=5; i<5+4; i++){
			for(int j=5; j<5+4 ; j++){
				Posicion posicion = new Posicion(i, j);
				Assert.assertTrue(mapa.posicionOcupada(posicion));
			}
		}	
		
	}

}
