package Modelo;
import java.lang.Math;
import java.util.ArrayList;

public class Edificio extends Objetivo{
	
	private int velocidadDeReparacion;
	private int turnosEnConstruirse;	
	
	public Edificio(Zona zona, int vida, int costo,Jugador jugador,int velocidadDeReparacion, int turnosEnConstruirse){
		super(zona, vida, costo,jugador);
		this.velocidadDeReparacion = velocidadDeReparacion;
		this.turnosEnConstruirse = turnosEnConstruirse;
	}
	
	public ArrayList<Celda> posiblesCeldasParaCrearUnidad(Zona zona, int base, int altura){
		
		Celda celdaArribaIzquierda = zona.getCeldaArribaIzquierda();
		Celda celdaInicialDeBusqueda = celdaArribaIzquierda.crearCeldaIgual();
		celdaInicialDeBusqueda.desplazarArribaIzquierda();
		
		Zona zonaDeBusqueda = new Zona(celdaInicialDeBusqueda, base ,  altura);
		
		return Mapa.obtenerInstancia().buscarPosiblesCeldas(celdaInicialDeBusqueda, zonaDeBusqueda, base, altura);
	}

	public boolean estaAlLadoDe(Celda celda){
		Zona zonaDelEdificio = (Zona)this.posicion;
		return zonaDelEdificio.estaAlLadoDe(celda);
	}

	public boolean esPosibleAumentarVida(){
		return this.vida < this.vidaMaxima;
	}

	public void aumentarVida(){
		this.vida = Math.min(this.vida + this.velocidadDeReparacion, this.vidaMaxima);
	}



}
