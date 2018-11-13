package Modelo;

public interface Posicion {
	
	public boolean enRango(int altura, int base);
	public boolean igualA(Posicion unaPosicion);
	public boolean igualA(Celda unaCelda);
	public boolean igualA(Zona unaZona);
}
