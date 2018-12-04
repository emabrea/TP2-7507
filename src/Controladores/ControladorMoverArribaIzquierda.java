package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorMoverArribaIzquierda implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorMoverArribaIzquierda(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
       System.out.println("Mueve arriba izquierda");
       UnidadActual.obtenerInstancia().unidad().moverArribaIzquierda();
       this.contenedor.actualizar();

	}
}