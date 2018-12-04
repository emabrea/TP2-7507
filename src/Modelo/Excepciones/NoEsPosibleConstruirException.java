package Modelo.Excepciones;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NoEsPosibleConstruirException extends RuntimeException {

	public NoEsPosibleConstruirException(){
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Accion no valida");            
	    alert.setContentText("No es posible contruir en esa zona");
	    alert.showAndWait();
	}

}
