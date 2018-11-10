package Modelo;

public interface Posicion {
	
	public boolean equals(Object unaCelda);
	public boolean igualA(PosicionUnidad unaPosicion);
	public boolean enRango(int altura, int base);

}
