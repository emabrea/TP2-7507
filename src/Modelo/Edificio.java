package Modelo;
import java.lang.Math;
import java.util.ArrayList;

public class Edificio extends Objetivo {
	
	private int velocidadDeReparacion;
	private int turnosEnConstruirse;	
	boolean siendoReparado = false;	
	
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

	public void recibirDanio(int danio){
		this.vida -= danio;
	}

	public int vidaActual(){
		return this.vida;
	}

	public void reparando(Boolean estado){
		if(this.siendoReparado == estado){
			throw new EdificioSiendoReparado();
		}
		this.siendoReparado = estado;
	}

	public void recibirDanio(Arquero arquero){
		this.reducirVidaEn(10);
	}
	public void recibirDanio(Espadachin espadachin){
		this.reducirVidaEn(15);
	}
	public void recibirDanio(ArmaDeAsedio armaDeAsedio){
		this.reducirVidaEn(75);
	}
	public void recibirDanio(Castillo castillo){
		this.reducirVidaEn(20);
	}
	public boolean estaEnPosicion(Zona zona){
		return this.posicion.igualA(zona);
	}

}
