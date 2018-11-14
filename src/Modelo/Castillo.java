package Modelo;

import java.util.ArrayList;

public class Castillo extends Edificio{
	
	public Castillo(Zona zona) {
		super(zona, 1000, 0, 15, 0);
	}

	static int base = 4;
	static int altura = 4;

	public static int getTamanioBase() {
		return base;
	}
	
	public static int getTamanioAltura() {
		return altura;
	}
	
	public ArrayList<Celda> posiblesCeldasParaCrearArmaDeAsedio(Mapa mapa){
		
		ArrayList<Celda> celdasPosibles = super.posiblesCeldasParaCrearUnidad((Zona)this.posicion, base + 2, altura + 2, mapa);
		 
		if(celdasPosibles.isEmpty()){
			throw new NoSePuedeCrearElArmaDeAsedioCeldasPerifericasOcupadasException();
		}
		
		return celdasPosibles;
	}

	public void crearArmaDeAsedio(Mapa mapa, Celda celda) {
		mapa.insertar(celda);
	}

}
