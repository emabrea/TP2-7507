package Modelo;

import java.util.ArrayList;

public class Castillo extends Edificio{
	
	public Castillo(Celda celdaInicial, Jugador jugador) {
		super(new Zona(celdaInicial, base, altura), 1000, 0, jugador,15, 0);
	}

	static int base = 4;
	static int altura = 4;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}
	
	public ArrayList<Celda> posiblesCeldasParaCrearArmaDeAsedio(){
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2);
		 
		if(celdasPosibles.isEmpty()){
			throw new NoSePuedeCrearElArmaDeAsedioCeldasPerifericasOcupadasException();
		}
		
		return celdasPosibles;
	}

	public void crearArmaDeAsedio(Celda celda) {
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celda,this.jugador);
		this.jugador.agregarObjetivo(armaDeAsedio);
		Mapa.obtenerInstancia().insertar(celda);
	}

	public boolean derrumbado() {
		return (this.vida == 0);
	}

}
