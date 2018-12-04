package Modelo.Excepciones;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AldeanoEstaConstruyendoUnCuartelEnOtraZonaException extends RuntimeException {

	public AldeanoEstaConstruyendoUnCuartelEnOtraZonaException(){
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Accion no valida");            
	    alert.setContentText("El aldeano ya esta contruyendo un cuartel en otra zona");
	    alert.showAndWait();
	}
	
}
