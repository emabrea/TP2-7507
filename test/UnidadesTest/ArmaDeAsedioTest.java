package UnidadesTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import Modelo.ArmaDeAsedio;
import Modelo.Celda;
import Modelo.Mapa;
import Modelo.Castillo;
import Modelo.Jugador;
import Modelo.Unidad;
import Modelo.ArmaDeAsedioMontadaNoPuedeMoverse;

public class ArmaDeAsedioTest{
	@Before
	public void reset(){
		Mapa.reset();
	}

	@Test
	public void test01ArmaDeAsedioDesmontadaSePuedeMover(){

		Celda celda = new Celda(15, 15);
		Jugador jugador = new Jugador(100);
		Castillo castillo = new Castillo(celda, jugador);
		ArrayList<Celda> celdasPosibles = castillo.posiblesCeldasParaCrearArmaDeAsedio();
		Celda celdaACrear = celdasPosibles.get(0); //celda=(14,16)
		castillo.crearArmaDeAsedio(celdaACrear);
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(celdaACrear));
		ArmaDeAsedio arma = (ArmaDeAsedio)jugador.obtenerUnidad(celdaACrear);
		arma.moverArriba(Mapa.obtenerInstancia());
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(new Celda(14,16)));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(new Celda(14,17)));
		arma.moverAbajoDerecha(Mapa.obtenerInstancia());
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(new Celda(14,17)));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(new Celda(15,16)));
		arma.moverIzquierda(Mapa.obtenerInstancia());
		Assert.assertFalse(Mapa.obtenerInstancia().posicionOcupada(new Celda(15,16)));
		Assert.assertTrue(Mapa.obtenerInstancia().posicionOcupada(new Celda(14,16)));


	}

	@Test
	public void test02ArmaDeAsedioMontadaNoSePuedeMover(){

		Celda celda = new Celda(15, 15);
		Jugador jugador = new Jugador(100);
		Castillo castillo = new Castillo(celda, jugador);
		ArrayList<Celda> celdasPosibles = castillo.posiblesCeldasParaCrearArmaDeAsedio();
		Celda celdaACrear = celdasPosibles.get(0); //celda=(14,16)
		castillo.crearArmaDeAsedio(celdaACrear);
		ArmaDeAsedio arma = (ArmaDeAsedio)jugador.obtenerUnidad(celdaACrear);		
		try{
			arma.moverArriba(Mapa.obtenerInstancia());			
		} catch(ArmaDeAsedioMontadaNoPuedeMoverse e){ }


	}
}