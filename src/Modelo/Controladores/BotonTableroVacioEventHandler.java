package Controladores;

import Modelo.Juego.Celda;
import Vista.PosicionActual;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonTableroVacioEventHandler implements EventHandler<MouseEvent>{

	Celda celda;

	public BotonTableroVacioEventHandler(Celda celda){
		this.celda = celda;
	}

	@Override
	public void handle(MouseEvent event) {
		if(event.isPrimaryButtonDown()){
			PosicionActual posicion = PosicionActual.obtenerInstancia();
			posicion.actualizar(celda);
		}

	}

}
