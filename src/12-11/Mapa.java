import java.util.Arrays;

public class Mapa {	

	Objetivo objetivo;
	int ancho;
	int alto;
	List<Objetivo> objetivos = new ArrayList<Objetivo>();	

	public Mapa(int largoIndicado, int altoIndicado){
		ancho = largoIndicado;
		alto = altoIndicado;		
	}


	public boolean casillaFueraDeRango(int x,int y) throws Exception{
		if(x > ancho || x < 1 || y > alto || y < 1){
			throw new Exception("Fuera de rango!");
		}
	}


	public boolean posicionOcupada(Posicion posicion){
		for(Objetivo objetivo : objetivos){
			if (objetivo.ocupa(posicion)) return true;
		}
		return false
	}

	public void ocuparPosicion(Posicion posicion, Objetivo objetivo) throws Exception{
		if(PosicionOcupada(posicion)){
			throw new Exception("Posición ocupada!");
		}
		objetivos.add(objetivo);
	}

	public void eliminarObjetivo(Objetivo objetivo){
		objetivos.remove(objetivo);		
	}

	public void zonaDisponible(Zona zona) throws Exception {
		for(Posicion posicion : zona.obtenePosiciones()){
			if(this.posicionOcupada(posicion)){
				throw new Exception("No se puede crear el edificio en esa posicion.");
			}

		}
	}



	

}