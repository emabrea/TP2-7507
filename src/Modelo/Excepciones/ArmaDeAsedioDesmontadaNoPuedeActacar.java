package Modelo.Excepciones;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ArmaDeAsedioDesmontadaNoPuedeActacar extends RuntimeException {

	public ArmaDeAsedioDesmontadaNoPuedeActacar(){
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Accion no valida");            
	    alert.setContentText("El arma de asedio debe estar montada para atacar");
	    alert.showAndWait();
	}
}