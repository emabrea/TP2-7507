package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorAtacar implements EventHandler<ActionEvent>{

    ContenedorPrincipal contenedor;

    public ControladorAtacar(ContenedorPrincipal contenedor){
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Ataca");
        /*
        ControladorDeTurno controlador = ControladorDeTurno.getInstance();        
        Jugador jugador = controlador.jugador();
        PosicionActual posicion = PosicionActual.obtenerInstancia();
        Pieza piezaActual = PiezaActual.obtenerInstancia().obtenerPieza();
        Pieza objetivo = jugador.obtenerPieza(new Celda(posicion.getX(),posicion.getY()));

        if(objetivo==null || objetivo.esPiezaPropia(jugador)){
            System.out.println("No es un objetivo para atacar");
            return;
        }
        piezaActual.atacar(objetivo);        
        ContenedorPrincipal.actualizar();
        */
    
    }

}