package Modelo;

public class PosicionUnidad implements Posicion{
	
	int x;
	int y;
	
	public PosicionUnidad(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object unaCelda){
		Celda celda = (Celda) unaCelda;
		return (celda.equals(this));
	}
	
	public boolean igualA(PosicionUnidad unaPosicion) {
		return (unaPosicion.mismo(this.x, this.y));
	}

	private boolean mismo(int x, int y) {
		return (this.x == x && this.y == y);
	}

	public boolean enRango(int altura, int base) {
		return (this.x <= base && this.y <= altura);
	}
	public void desplazarHorizontalmente(int desplazamiento){
		
		this.x = this.x + desplazamiento;
	}
	public void desplazarVerticalmente(int desplazamiento){
		
		this.y = this.y + desplazamiento;
	}

}
