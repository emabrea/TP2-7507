package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import Modelo.Edificio.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorCrearArmaDeAsedio implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;
	Castillo castillo;

	public ControladorCrearArmaDeAsedio(ContenedorPrincipal contenedor, Castillo castillo){
		this.castillo = castillo;
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
        try{
        	//Reproductor
            String path = "src/Vista/Recursos/sounds/creacion_unidad.wav";
            Media media = new Media(new File(path).toURI().toString());
            MediaPlayer reproductorCrear = new MediaPlayer(media);

            castillo.crearArmaDeAsedio(castillo.posiblesCeldasParaCrearArmaDeAsedio().get(0));
            reproductorCrear.play();
        }
        catch(NoEsPosibleCrearException e){
            new Alerta().noSePuedeCrearAhi();
        }
        catch(OroInsuficienteException e){
            new Alerta().oroInsuficiente();
        }
        catch(PoblacionExcedidaException e){
            new Alerta().poblacionExcedida();
        }
        contenedor.actualizar();
	}
}