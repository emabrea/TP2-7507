package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorCrearEspadachin implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorCrearEspadachin(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
    	System.out.println("Crea espadachin");   
    	Celda celda = PosicionActual.obtenerInstancia().celda();  
    	Edificio edificioActual = EdificioActual.obtenerInstancia().edificio();
        try{
            if(edificioActual instanceof Cuartel){
                Cuartel cuartel = (Cuartel)EdificioActual.obtenerInstancia().edificio();
                cuartel.crearEspadachin(celda);         
            }
            throw new NoEsPosibleCrearException();
        } 	        
        catch(NoEsPosibleCrearException e){
            new Alerta().noSePuedeCrearAhi();
        } 
    	this.contenedor.actualizar();
	}
}