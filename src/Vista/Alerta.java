package Vista;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;


public class Alerta{

	Alert alerta;

	public Alerta(){
		alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText(null);		
	}

	public void unidadOcupada(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("El aldeano esta ocupado.");
	    this.alerta.showAndWait(); 
	}

	public void unidadYaMovida(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("Esta unidad ya se movio");
	    this.alerta.showAndWait(); 
	}

	public void fueraDeRango(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("Posicion fuera de rango");
	    this.alerta.showAndWait(); 
	}

	public void celdaOcupada(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("Posicion ocupada");
	    this.alerta.showAndWait(); 
	}

	public void noSePuedeCrearAhi(){
		this.alerta.setTitle("Accion no valida"); 
		this.alerta.setContentText("No es posible crear en esa posicion");
	    this.alerta.showAndWait(); 
	}

}