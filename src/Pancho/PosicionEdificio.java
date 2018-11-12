package Modelo;

public class PosicionEdificio implements Posicion{
	
	PosicionUnidad[][] posiciones;
	int tamanio;

	public PosicionEdificio(int x, int y, int unTamanio) {
		this.tamanio = unTamanio / 2;
		this.posiciones = new PosicionUnidad[this.tamanio][this.tamanio];
		this.inicializarPosiciones(x, y);
	}
	
	private void inicializarPosiciones(int x, int y) {
		for(int i = 0 ; i < this.tamanio ; i++){
			for(int j = 0 ; j < this.tamanio ; j++){
				posiciones[i][j] = new PosicionUnidad(x, y);
				posiciones[i][j].desplazarHorizontalmente(j);
				posiciones[i][j].desplazarVerticalmente(i);
			}
		}
		
	}

	@Override
	public boolean igualA(PosicionUnidad unaPosicion) {
		for(int i = 0 ; i < this.tamanio ; i++){
			for(int j = 0 ; j < this.tamanio ; j++){
				if(unaPosicion.igualA(this.posiciones[i][j])){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean enRango(int altura, int base) {
		for(int i = 0 ; i < this.tamanio ; i++){
			for(int j = 0 ; j < this.tamanio ; j++){
				if(! this.posiciones[i][j].enRango(altura, base)) return false;	
			}
		}
		return true;
	}
	
	@Override
	public boolean equals(Object unaCelda){
		Celda celda = (Celda) unaCelda;
		for(int i = 0 ; i < this.tamanio ; i++){
			for(int j = 0 ; j < this.tamanio ; j++){
				if(celda.equals(this.posiciones[i][j])) return true;
			}
		}
		return false;
	}

}
