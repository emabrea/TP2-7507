package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorMoverAbajo implements EventHandler<ActionEvent>{

    ContenedorPrincipal contenedor;

    public ControladorMoverAbajo(ContenedorPrincipal contenedor){
      this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent event) {
       System.out.println("Mueve abajo");       
       UnidadActual.obtenerInstancia().unidad().moverAbajo();
       this.contenedor.actualizar();

  }
}