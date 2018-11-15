package EdificiosTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Castillo;
import Modelo.Celda;
import Modelo.Mapa;
import Modelo.NoSePuedeCrearElArmaDeAsedioCeldasPerifericasOcupadasException;
import Modelo.Zona;

public class CastilloCreaArmaDeAsedioTest {
	
	@Test
	public void test01CastilloCreaArmaDeAsedioAlLadoSuyoSiEstanVaciasLasCeldas(){
		
		Mapa mapa = new Mapa();
		
		Celda celda = new Celda(8, 5);
		
		int base = Castillo.getTamanioBase();
		int altura = Castillo.getTamanioAltura();
		Zona zona = new Zona(celda, base, altura);
		
		Castillo castillo = new Castillo(celda);
		
		mapa.insertar(zona);
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		// Busca las celdas posibles donde puede respawnear el Arma de Asedio
		ArrayList<Celda> posiblesCeldas = castillo.posiblesCeldasParaCrearArmaDeAsedio(mapa);
		
		celda.desplazarArribaIzquierda();
		Assert.assertFalse(mapa.posicionOcupada(celda));
		
		// Elijo una (la primera que encontro)
		Celda posibleCelda = posiblesCeldas.get(0);
		
		castillo.crearArmaDeAsedio(mapa, posibleCelda);
		
		// Es justo la celda donde se verifico que antes de crear el Arma de Asedio, la misma estaba libre
		Assert.assertTrue(celda.igualA(posibleCelda));
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		Assert.assertTrue(mapa.posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test02CastilloCreaArmaDeAsedioEnLaUnicaCeldaQueNoEstaOcupadaDeLasPerifericas(){
		
		Mapa mapa = new Mapa();
		
		Celda celdaInicial = new Celda(8, 5);
		Celda celdaDondeIriaElArmaDeAsedio = new Celda(10, 1);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		for(int j = 1 ; j < 7 ; j += 5){
			for(int i = 7 ; i < 13 ; i++){
				if(i != 10 || j != 1){
					celdasPeriferia.add(new Celda(i, j));
				}
			}	
		}
		
		for(int j = 2 ; j < 6 ; j++){
			for(int i = 7 ; i < 13 ; i += 5){
				celdasPeriferia.add(new Celda(i, j));
			}
		}
		
		int base = Castillo.getTamanioBase();
		int altura = Castillo.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Castillo castillo = new Castillo(celdaInicial);
		
		mapa.insertaorgr(zona);
		// Ocupada la zona del castillo una vez insertada
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			mapa.insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		
		// Desocupada la celda donde tendria que ir
		Assert.assertFalse(mapa.posicionOcupada(celdaDondeIriaElArmaDeAsedio));
		
		// Busca las celdas posibles donde puede respawnear el Arma de Asedio
		ArrayList<Celda> posiblesCeldas = castillo.posiblesCeldasParaCrearArmaDeAsedio(mapa);
		
		// Elijo una (es la unica)
		Assert.assertTrue(posiblesCeldas.size() == 1);
		Celda posibleCelda = posiblesCeldas.get(0);
		
		castillo.crearArmaDeAsedio(mapa, posibleCelda);
		
		// Siguen ocupadas la zona del castillo y las celdas de la periferia
		Assert.assertTrue(mapa.posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		// Ahora queda ocupada la celda donde tendria que ir el ArmaDeAsedio y Es la misma que se obtuvo
		Assert.assertTrue(celdaDondeIriaElArmaDeAsedio.igualA(posibleCelda));
		Assert.assertTrue(mapa.posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test03CastilloNoCreaArmaDeAsedioYaQueSusCeldasPerifericasEstanOcupadas(){
		
		Mapa mapa = new Mapa();
		
		Celda celdaInicial = new Celda(8, 5);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		for(int j = 1 ; j < 7 ; j += 5){
			for(int i = 7 ; i < 13 ; i++){
				celdasPeriferia.add(new Celda(i, j));
			}	
		}
		
		for(int j = 2 ; j < 6 ; j++){
			for(int i = 7 ; i < 13 ; i += 5){
				celdasPeriferia.add(new Celda(i, j));
			}
		}
		
		int base = Castillo.getTamanioBase();
		int altura = Castillo.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		Castillo castillo = new Castillo(celdaInicial);
		
		mapa.insertar(zona);
		// Ocupada la zona del castillo una vez insertada
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			mapa.insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		
		// Busca las celdas posibles donde puede respawnear el Arma de Asedio
		try{
			castillo.posiblesCeldasParaCrearArmaDeAsedio(mapa);
		} catch(NoSePuedeCrearElArmaDeAsedioCeldasPerifericasOcupadasException e){ }
		
		// Siguen ocupadas la zona del castillo y las celdas de la periferia
		Assert.assertTrue(mapa.posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
	}
}
