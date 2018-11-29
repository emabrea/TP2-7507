package Vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;


public class ControladorConstruirCuartel implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        ControladorDeTurno controlador = ControladorDeTurno.getInstance();        
        Jugador jugador = controlador.jugador();
        PosicionActual posicion = PosicionActual.obtenerInstancia();
        Pieza piezaActual = PiezaActual.obtenerInstancia().obtenerPieza();
        Pieza objetivo = jugador.obtenerPieza(new Celda(posicion.getX(),posicion.getY()));

        if(objetivo==null || objetivo.esPiezaPropia(jugador)){
            System.out.println("No es un objetivo para atacar");
            return;
        }
        //piezaActual.atacar(objetivo);        
        //ContenedorPrincipal.actualizar();
    }

}