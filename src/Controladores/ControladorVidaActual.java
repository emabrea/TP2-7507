package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Juego.*;
import Vista.*;

public class ControladorVidaActual implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
    	Celda celdaActual = PosicionActual.obtenerInstancia().celda();
    	Jugador jugadorActual = ControladorDeTurno.getInstance().jugador();           
    	Pieza pieza = jugadorActual.obtenerPieza(celdaActual);
    	if(pieza != null){
            System.out.println("Vida: "+pieza.obtenerVida()); 
        }      
       
	}
}