package EdificiosTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Celda;
import Modelo.Cuartel;
import Modelo.Mapa;
import Modelo.NoSePuedeCrearElArqueroCeldasPerifericasOcupadasException;
import Modelo.NoSePuedeCrearElEspadachinCeldasPerifericasOcupadasException;
import Modelo.Zona;

public class CuartelCreaArquerosYEspadachinesTest {
	
	@Test
	public void test01CuartelCreaArqueroAlLadoSuyoSiEstanVaciasLasCeldas(){
		
		Mapa mapa = new Mapa();
		
		Celda celda = new Celda(17, 8);
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celda, base, altura);
		
		Cuartel cuartel = new Cuartel(zona);
		
		mapa.insertar(zona);
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		// Busca las celdas posibles donde puede respawnear el Arquero
		ArrayList<Celda> posiblesCeldas = cuartel.posiblesCeldasParaCrearArquero(mapa);
		
		celda.desplazarArribaIzquierda();
		Assert.assertFalse(mapa.posicionOcupada(celda));
		
		// Elijo una (la primera que encontro)
		Celda posibleCelda = posiblesCeldas.get(0);
		
		cuartel.crearArquero(mapa, posibleCelda);
		
		// Es justo la celda donde se verifico que antes de crear el Arquero, la misma estaba libre
		Assert.assertTrue(celda.igualA(posibleCelda));
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		Assert.assertTrue(mapa.posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test02CuartelCreaArqueroEnLaUnicaCeldaQueNoEstaOcupadaDeLasPerifericas(){
		
		Mapa mapa = new Mapa();
		
		Celda celdaInicial = new Celda(0, 1);
		Celda celdaDondeIriaElArquero = new Celda(2, 1);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		
		for(int i = 0 ; i < 3 ; i++){
			celdasPeriferia.add(new Celda(i, 2));
		}
		celdasPeriferia.add(new Celda(2, 0));
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Cuartel cuartel = new Cuartel(zona);
		
		mapa.insertar(zona);
		// Ocupada la zona del cuartel una vez insertada
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			mapa.insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		
		// Desocupada la celda donde tendria que ir
		Assert.assertFalse(mapa.posicionOcupada(celdaDondeIriaElArquero));
		
		// Busca las celdas posibles donde puede respawnear el Arquero
		ArrayList<Celda> posiblesCeldas = cuartel.posiblesCeldasParaCrearArquero(mapa);
		
		// Elijo una (es la unica)
		Assert.assertTrue(posiblesCeldas.size() == 1);
		Celda posibleCelda = posiblesCeldas.get(0);
		
		cuartel.crearArquero(mapa, posibleCelda);
		
		// Siguen ocupadas la zona del cuartel y las celdas de la periferia
		Assert.assertTrue(mapa.posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		// Ahora queda ocupada la celda donde tendria que ir el Arquero y Es la misma que se obtuvo
		Assert.assertTrue(celdaDondeIriaElArquero.igualA(posibleCelda));
		Assert.assertTrue(mapa.posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test03CuartelNoCreaArqueroYaQueSusCeldasPerifericasEstanOcupadas(){
		
		Mapa mapa = new Mapa();
		
		Celda celdaInicial = new Celda(8, 5);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		for(int i = 0 ; i < 3 ; i++){
			celdasPeriferia.add(new Celda(i, 2));
		}
		celdasPeriferia.add(new Celda(2, 0));
		celdasPeriferia.add(new Celda(2, 1));
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Cuartel cuartel = new Cuartel(zona);
		
		mapa.insertar(zona);
		// Ocupada la zona del cuartel una vez insertada
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			mapa.insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		
		try{
			// Busca las celdas posibles donde puede respawnear el Arquero
			cuartel.posiblesCeldasParaCrearArquero(mapa);
		} catch(NoSePuedeCrearElArqueroCeldasPerifericasOcupadasException e){ }
		
		// Siguen ocupadas la zona del cuartel y las celdas de la periferia
		Assert.assertTrue(mapa.posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
	}
	
	@Test
	public void test04CuartelCreaEspadachinAlLadoSuyoSiEstanVaciasLasCeldas(){
		
		Mapa mapa = new Mapa();
		
		Celda celda = new Celda(17, 8);
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celda, base, altura);
		
		Cuartel cuartel = new Cuartel(zona);
		
		mapa.insertar(zona);
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		// Busca las celdas posibles donde puede respawnear el Espadachin
		ArrayList<Celda> posiblesCeldas = cuartel.posiblesCeldasParaCrearEspadachin(mapa);
		
		celda.desplazarArribaIzquierda();
		Assert.assertFalse(mapa.posicionOcupada(celda));
		
		// Elijo una (la primera que encontro)
		Celda posibleCelda = posiblesCeldas.get(0);
		
		cuartel.crearEspadachin(mapa, posibleCelda);
		
		// Es justo la celda donde se verifico que antes de crear el Espadachin, la misma estaba libre
		Assert.assertTrue(celda.igualA(posibleCelda));
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		Assert.assertTrue(mapa.posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test05CuartelCreaEspadachinEnLaUnicaCeldaQueNoEstaOcupadaDeLasPerifericas(){
		
		Mapa mapa = new Mapa();
		
		Celda celdaInicial = new Celda(17, 8);
		Celda celdaDondeIriaElEspadachin = new Celda(16, 6);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		
		for(int j = 6 ; j < 10 ; j += 3){
			for(int i = 16 ; i < 20 ; i++){
				if(i != 16 || j != 6){
					celdasPeriferia.add(new Celda(i, j));
				}
			}	
		}
		
		for(int j = 7 ; j < 9 ; j++){
			for(int i = 16 ; i < 20 ; i += 3){
				celdasPeriferia.add(new Celda(i, j));
			}
		}
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Cuartel cuartel = new Cuartel(zona);
		
		mapa.insertar(zona);
		// Ocupada la zona del cuartel una vez insertada
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			mapa.insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		
		// Desocupada la celda donde tendria que ir
		Assert.assertFalse(mapa.posicionOcupada(celdaDondeIriaElEspadachin));
		
		// Busca las celdas posibles donde puede respawnear el Espadachin
		ArrayList<Celda> posiblesCeldas = cuartel.posiblesCeldasParaCrearEspadachin(mapa);
		
		// Elijo una (es la unica)
		Assert.assertTrue(posiblesCeldas.size() == 1);
		Celda posibleCelda = posiblesCeldas.get(0);
		
		cuartel.crearEspadachin(mapa, posibleCelda);
		
		// Siguen ocupadas la zona del cuartel y las celdas de la periferia
		Assert.assertTrue(mapa.posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		// Ahora queda ocupada la celda donde tendria que ir el Espadachin y Es la misma que se obtuvo
		Assert.assertTrue(celdaDondeIriaElEspadachin.igualA(posibleCelda));
		Assert.assertTrue(mapa.posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test06CuartelNoCreaEspadachinYaQueSusCeldasPerifericasEstanOcupadas(){
		
		Mapa mapa = new Mapa();
		
		Celda celdaInicial = new Celda(8, 5);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		for(int j = 6 ; j < 10 ; j += 3){
			for(int i = 16 ; i < 20 ; i++){
				celdasPeriferia.add(new Celda(i, j));
			}	
		}
		
		for(int j = 7 ; j < 9 ; j++){
			for(int i = 16 ; i < 20 ; i += 3){
				celdasPeriferia.add(new Celda(i, j));
			}
		}
		
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Cuartel castillo = new Cuartel(zona);
		
		mapa.insertar(zona);
		// Ocupada la zona del cuartel una vez insertada
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			mapa.insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		
		
		try{
			// Busca las celdas posibles donde puede respawnear el Espadachin
			castillo.posiblesCeldasParaCrearEspadachin(mapa);
		} catch(NoSePuedeCrearElEspadachinCeldasPerifericasOcupadasException e){ }
		
		// Siguen ocupadas la zona del cuartel y las celdas de la periferia
		Assert.assertTrue(mapa.posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
	}
}
