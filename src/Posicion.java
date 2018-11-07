public class Posicion {

	int x;
	int y;

	private int coordenadaX(){
		return x;
	}

	private int coordenadaY(){
		return y;
	}

	public int[] DistanciEntrePosiciones(Posicion posicionNueva){
		int x2= posicionNueva.coordenadaX();
		int y2= posicionNueva.coordenadaY();

		int[] distancia = new int[2];
		distancia[0] = x-x2;
		distancia[1] = y-y2;

		return distancia;
	}
}