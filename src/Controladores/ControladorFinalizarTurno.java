package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorFinalizarTurno implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorFinalizarTurno(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Finaliza su turno");
        ControladorDeTurno.getInstance().cambiarJugador();
        ControladorDeTurno.getInstance().jugador().realizarTareas();
        this.contenedor.actualizar();
    }
}