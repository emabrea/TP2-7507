package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorCrearArmaAsedio implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorCrearArmaAsedio(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
    	System.out.println("Crea arma de asedio");   
    	Celda celda = PosicionActual.obtenerInstancia().celda();  
    	Jugador jugador = ControladorDeTurno.getInstance().jugador();
        Castillo castillo = jugador.obtenerCastillo();
    	castillo.crearArmaDeAsedio(celda);      
    	this.contenedor.actualizar();
	}
}