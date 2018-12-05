package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Vista.*;


public class ControladorMoverAbajo implements EventHandler<ActionEvent>{

    ContenedorPrincipal contenedor;

    public ControladorMoverAbajo(ContenedorPrincipal contenedor){
      this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent event) {
       System.out.println("Mueve abajo");
        Jugador jugadorActual = ControladorDeTurno.getInstance().jugadorEnTurno();
        Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
        if(unidadActual.esPiezaPropia(jugadorActual)) unidadActual.moverAbajo();
       this.contenedor.actualizar();

  }
}