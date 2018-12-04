package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorConstruirCuartel implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorConstruirCuartel(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
    	System.out.println("Contruye cuartel");   
    	Celda celda = PosicionActual.obtenerInstancia().celda();  
    	Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
    	if(unidadActual instanceof Aldeano){
    		Aldeano aldeano = (Aldeano)UnidadActual.obtenerInstancia().unidad();
    		aldeano.construirCuartelEnZona(new Zona(celda,2,2));    		
    	}       
        else{
            throw new NoEsPosibleConstruirException();
        }
    	this.contenedor.actualizar();

	}
}