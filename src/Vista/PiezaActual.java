package Vista;

import Modelo.Juego.*;
import Controladores.*;

public class PiezaActual{
	Pieza pieza;	

	private static PiezaActual instancia = new PiezaActual();
	
	public void actualizar(int x,int y){
		Jugador jugador = ControladorDeTurno.getInstance().jugador();		
		Pieza pieza = jugador.obtenerPieza(new Celda(x,y));
		if( pieza == null || !pieza.esPiezaPropia(jugador)){
			return;
		}
		this.pieza = pieza;		
	}	

	public static PiezaActual obtenerInstancia(){		
		return instancia;
	}

	public Pieza obtenerPieza(){
		return this.pieza;
	}

}