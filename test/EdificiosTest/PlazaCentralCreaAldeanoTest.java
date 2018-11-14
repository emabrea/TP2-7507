package EdificiosTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Celda;
import Modelo.Mapa;
import Modelo.NoSePuedeCrearElAldeanoCeldasPerifericasOcupadasException;
import Modelo.PlazaCentral;
import Modelo.Zona;

public class PlazaCentralCreaAldeanoTest {

	@Test
	public void test01PlazaCentralCreaAldeanoAlLadoSuyoSiEstanVaciasLasCeldas(){
		
		Mapa mapa = new Mapa();
		int baseMapa = mapa.getTamanioBase();
		int alturaMapa = mapa.getTamanioAltura();
		
		Celda celda = new Celda(baseMapa - 1, alturaMapa);
		
		int base = PlazaCentral.getTamanioBase();
		int altura = PlazaCentral.getTamanioAltura();
		Zona zona = new Zona(celda, base, altura);
		
		PlazaCentral plazaCentral = new PlazaCentral(zona);
		
		mapa.insertar(zona);
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		// Busca las celdas posibles donde puede respawnear el Aldeano
		ArrayList<Celda> posiblesCeldas = plazaCentral.posiblesCeldasParaCrearAldeano(mapa);
		
		celda.desplazarIzquierda();
		Assert.assertFalse(mapa.posicionOcupada(celda));
		
		// Elijo una (la primera que encontro)
		Celda posibleCelda = posiblesCeldas.get(0);
		
		plazaCentral.crearAldeano(mapa, posibleCelda);
		
		// Es justo la celda donde se verifico que antes de crear el Aldeano, la misma estaba libre
		Assert.assertTrue(celda.igualA(posibleCelda));
		
		Assert.assertTrue(mapa.posicionOcupada(zona));
		Assert.assertTrue(mapa.posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test02PlazaCentralCreaAldeanoEnLaUnicaCeldaQueNoEstaOcupadaDeLasPerifericas(){
		
		Mapa mapa = new Mapa();
		int baseMapa = mapa.getTamanioBase();
		int alturaMapa = mapa.getTamanioAltura();
		
		Celda celdaInicial = new Celda(baseMapa - 1, alturaMapa);
		Celda celdaDondeIriaElAldeano = new Celda(baseMapa - 2, alturaMapa - 2);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa));
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa -1));
		celdasPeriferia.add(new Celda(baseMapa - 1, alturaMapa - 2));
		celdasPeriferia.add(new Celda(baseMapa, alturaMapa -2));
		
		int base = PlazaCentral.getTamanioBase();
		int altura = PlazaCentral.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		PlazaCentral plazaCentral = new PlazaCentral(zona);
		
		mapa.insertar(zona);
		// Ocupada la zona de la plaza central una vez insertada
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			mapa.insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		
		// Desocupada la celda donde tendria que ir
		Assert.assertFalse(mapa.posicionOcupada(celdaDondeIriaElAldeano));
		
		// Busca las celdas posibles donde puede respawnear el Aldeano
		ArrayList<Celda> posiblesCeldas = plazaCentral.posiblesCeldasParaCrearAldeano(mapa);
		
		// Elijo una (es la unica)
		Assert.assertTrue(posiblesCeldas.size() == 1);
		Celda posibleCelda = posiblesCeldas.get(0);
		
		plazaCentral.crearAldeano(mapa, posibleCelda);
		
		// Siguen ocupadas la zona de la plaza central y las celdas de la periferia
		Assert.assertTrue(mapa.posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		// Ahora queda ocupada la celda donde tendria que ir el Aldeano y Es la misma que se obtuvo
		Assert.assertTrue(celdaDondeIriaElAldeano.igualA(posibleCelda));
		Assert.assertTrue(mapa.posicionOcupada(posibleCelda));
	}
	
	@Test
	public void test03PlazaCentralNoCreaAldeanoYaQueSusCeldasPerifericasEstanOcupadas(){
		
		Mapa mapa = new Mapa();
		int baseMapa = mapa.getTamanioBase();
		int alturaMapa = mapa.getTamanioAltura();
		
		Celda celdaInicial = new Celda(baseMapa - 1, alturaMapa);
		
		// Celdas de la periferia
		ArrayList<Celda> celdasPeriferia = new ArrayList<Celda>();
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa));
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa -1));
		celdasPeriferia.add(new Celda(baseMapa - 1, alturaMapa - 2));
		celdasPeriferia.add(new Celda(baseMapa, alturaMapa -2));
		celdasPeriferia.add(new Celda(baseMapa - 2, alturaMapa - 2));
		
		int base = PlazaCentral.getTamanioBase();
		int altura = PlazaCentral.getTamanioAltura();
		Zona zona = new Zona(celdaInicial, base, altura);
		
		PlazaCentral plazaCentral = new PlazaCentral(zona);
		
		mapa.insertar(zona);
		// Ocupada la zona de la plaza central una vez insertada
		Assert.assertTrue(mapa.posicionOcupada(zona));
		
		for(Celda celda: celdasPeriferia){
			mapa.insertar(celda);
			// Celdas de la periferia de la zona ocupadas luego de insertarlas
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
		
		try{
			// Busca las celdas posibles donde puede respawnear el Aldeano
			plazaCentral.posiblesCeldasParaCrearAldeano(mapa);
		} catch(NoSePuedeCrearElAldeanoCeldasPerifericasOcupadasException e){ }
		
		// Siguen ocupadas la zona de la Plaza Central y las celdas de la periferia
		Assert.assertTrue(mapa.posicionOcupada(zona));
		for(Celda celda: celdasPeriferia){
			Assert.assertTrue(mapa.posicionOcupada(celda));
		}
	}
}
