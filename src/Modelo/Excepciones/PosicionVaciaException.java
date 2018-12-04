package Modelo.Excepciones;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PosicionVaciaException extends RuntimeException {

	public PosicionVaciaException(){
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Accion no valida");            
	    alert.setContentText("La posición esta vacia.");
	    alert.showAndWait();
	}

}