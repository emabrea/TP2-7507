public class Posicion {

	private int x;
	private int y;

	private int coordenadaX(){
		return x;
	}
	private int coordenadaY(){
		return y;
	}

	// VER!
	public int[] DistanciaEntrePosiciones(Posicion posicionNueva){
		int x2 = posicionNueva.coordenadaX();
		int y2 = posicionNueva.coordenadaY();

		int[] distancia = new int[2];
		distancia[0] = x-x2;
		distancia[1] = y-y2;

		return distancia;
	}
}