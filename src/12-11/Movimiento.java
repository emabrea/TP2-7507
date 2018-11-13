public class Movimiento {	

	public boolean movimientoEsValido(Posicion posicionActual,Posicion posicionNueva){
		int[] distancia = posicionActual.distanciEntrePosiciones(posicionNueva);

		if( distancia[0] > 1 || distancia[1] > 1){
			return false;
		}
		return true;
	}

}