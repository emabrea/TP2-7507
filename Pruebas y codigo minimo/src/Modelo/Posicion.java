package Modelo;

public class Posicion {

	int x;
	int y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object unaCelda){
		Celda celda = (Celda) unaCelda;
		return (celda.equals(this));
	}
	
	public boolean igualA(Posicion unaPosicion) {
		return (unaPosicion.mismo(this.x, this.y));
	}

	private boolean mismo(int x, int y) {
		return (this.x == x && this.y == y);
	}

	public boolean enRango(int altura, int base) {
		return (this.x <= base && this.y <= altura);
	}

}
