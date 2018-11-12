import java.util.Arrays;

public class Mapa {	

	Objetivo objetivo;
	int largo;
	int alto;
	int[][] matrix ;

	Mapa(int largoIndicado, int altoIndicado){
		largo = largoIndicado;
		alto = altoIndicado;
		matrix = new int[largo][alto];
		for (int[] row : matrix) {
    		Arrays.fill(row, 0);
		}
	}

	public boolean PosicionOcupada(Posicion posicion){
		return (matrix[posicion.coordenadaX()][posicion.coordenadaY()] !=0) ;
	}

	public void OcuparPosicion(Posicion posicion, Objetivo objetivo) throws Exception{
		if(PosicionOcupada(posicion)){
			throw new Exception("Posición ocupada!");
		}
		matrix[posicion.coordenadaX()][posicion.coordenadaY()] = objetivo;
	}

	public void EliminarObjetivo(Posicion posicion){
		matrix[posicion.coordenadaX()][posicion.coordenadaY()] = 0;
	}



	

}