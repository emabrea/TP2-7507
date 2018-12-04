package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorOro implements EventHandler<ActionEvent>{
    

    @Override
    public void handle(ActionEvent event) {
    	System.out.println("ORO: "+ControladorDeTurno.getInstance().jugador().cantidadDeOro());               
  }
}