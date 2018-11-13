public class Posicion {

	int x;
	int y;

	public Posicion(int x, int y){
		this.x = x;
		this.y = y;

	}

	public int coordenadaX(){
		return x ;
	}

	public int coordenadaY(){
		return y ;
	}

	public int[] distanciEntrePosiciones(Posicion posicionNueva){
		int x2 = posicionNueva.coordenadaX();
		int y2 = posicionNueva.coordenadaY();

		int[] distancia = new int[2];
		distancia[0] = Math.abs(x-x2);
		distancia[1] = Math.abs(y-y2);

		return distancia;
	}

	public Posicion trasladar(int desfasajeX,int desfasajeY){
		Posicion posicionNueva= new Posicion(x+desfasajeX,y+desfasajeY);
		return posicionNueva;		
	}

	public Posicion equals(Posicion otraPosicion){

		return (x == otraPosicion.coordenadaX() && y == otraPosicion.coordenadaY())

	}
}