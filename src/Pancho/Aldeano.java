package Modelo;

public class Aldeano extends Unidad{
	
	EstadoAldeano estado;
	
	public Aldeano(Celda celda){
		super(celda, 50, 25);
		estado = new AldeanoLibre();
	}
	
	public void repararEdificio(Mapa mapa, Edificio edificio){
		this.estado.repararEdificio(mapa, (Celda)this.posicion, edificio, this.estado);
	}
	
	public void construirCuartel(Mapa mapa){
		this.estado.construirCuartel(mapa, (Celda)this.posicion, this.estado);
	}
	
	public void construirPlazaCentral(Mapa mapa){
		this.estado.construirPlazaCentral(mapa, (Celda)this.posicion, this.estado);
	}
	
	public int recolectarOro(){
		int cantidadRecolectada = this.estado.recolectarOro(this.estado);
		return cantidadRecolectada;
	}
	
}
