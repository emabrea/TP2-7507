package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.*;

public class BotonImagen extends Button {

	ImageView imagen;

    public BotonImagen (ImageView imagen, EventHandler<ActionEvent> controlador){
        setImagen(imagen);
        setControlador(controlador);
    }

    public void setImagen(ImageView imagen){
        imagen.setFitHeight(40);
        imagen.setFitWidth(40);
        setGraphic(imagen);
        this.imagen = imagen;
    }

    public void setControlador(EventHandler<ActionEvent> controlador) {
    	setOnAction(controlador);
    }
}
