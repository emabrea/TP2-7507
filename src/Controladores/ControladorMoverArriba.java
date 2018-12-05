package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorMoverArriba implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorMoverArriba(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
       System.out.println("Mueve arriba");
       Jugador jugadorActual = ControladorDeTurno.getInstance().jugador();
       Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
       if(unidadActual.esPiezaPropia(jugadorActual)) unidadActual.moverArriba();
       this.contenedor.actualizar();
	}
}