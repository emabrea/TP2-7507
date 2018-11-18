package Modelo;


import java.util.ArrayList;

public class PlazaCentral extends Edificio {

	public PlazaCentral(Celda celdaInicial, Jugador jugador) {
		super(new Zona(celdaInicial, base, altura), 450, 100,jugador, 25, 3);
	}

	static int base = 2;
	static int altura = 2;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}

	public ArrayList<Celda> posiblesCeldasParaCrearAldeano() {
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2);
		
		if(celdasPosibles.isEmpty()){
			throw new NoSePuedeCrearElAldeanoCeldasPerifericasOcupadasException();
		}
		
		return celdasPosibles;
	}

	public void crearAldeano(Celda celda) {
		Aldeano aldeano = new Aldeano(celda,this.jugador);
		this.jugador.agregarObjetivo(aldeano);
		Mapa.obtenerInstancia().insertar(celda);
	}

}
