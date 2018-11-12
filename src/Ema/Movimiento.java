public class Movimiento {	

	public boolean MovimientoEsValido(Posicion posicionActual,Posicion posicionNueva){
		int[] distancia = posicionActual.DistanciEntrePosiciones(posicionNueva);

		if( distancia[0] > 1 || distancia[1] > 1){
			return false;
		}
		return true;
	}

}