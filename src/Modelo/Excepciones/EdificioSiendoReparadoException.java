package Modelo.Excepciones;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EdificioSiendoReparadoException extends RuntimeException {

	public EdificioSiendoReparadoException(){
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Accion no valida");            
	    alert.setContentText("El edificio esta siendo reparado.");
	    alert.showAndWait();
	}
}
