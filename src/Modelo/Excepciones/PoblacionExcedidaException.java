package Modelo.Excepciones;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PoblacionExcedidaException extends RuntimeException {

	public PoblacionExcedidaException(){
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Limite de poblacion excedido");            
	    alert.setContentText("El maximo de poblacion permitido es 50.");
	    alert.showAndWait();

	}

	

}