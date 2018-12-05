package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorMoverAbajoIzquierda implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorMoverAbajoIzquierda(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
       System.out.println("Mueve abajo izquierda");
        Jugador jugadorActual = ControladorDeTurno.getInstance().jugador();
        Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
        if(unidadActual.esPiezaPropia(jugadorActual)) unidadActual.moverAbajoIzquierda();
       this.contenedor.actualizar();

	}
}