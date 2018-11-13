package Modelo;

public class Edificio extends Objetivo{
	
	int vida;
	int costo;
	Zona zona;
	int velocidadDeReparacion;
	int turnosEnConstruirse;
	
	public Edificio(Zona zona, int vida, int costo, int velocidadDeReparacion, int turnosEnConstruirse){
		super(zona, vida, costo);
		this.velocidadDeReparacion = velocidadDeReparacion;
		this.turnosEnConstruirse = turnosEnConstruirse;
	}
}
