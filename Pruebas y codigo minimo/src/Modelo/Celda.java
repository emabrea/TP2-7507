package Modelo;

public class Celda{

	Insertable objeto;
	Posicion posicion;
	
	public Celda(Insertable objeto, Posicion posicion) {
		this.objeto = objeto;
		this.posicion = posicion;
	}

	public boolean equals(Posicion unaPosicion) {
		return (this.posicion.igualA(unaPosicion));
	}

}
