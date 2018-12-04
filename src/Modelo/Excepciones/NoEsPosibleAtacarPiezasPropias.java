package Modelo.Excepciones;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NoEsPosibleAtacarPiezasPropias extends RuntimeException {

	public NoEsPosibleAtacarPiezasPropias(){
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Accion no valida");            
	    alert.setContentText("El objetivo es una pieza propia.");
	    alert.showAndWait();

	}

}