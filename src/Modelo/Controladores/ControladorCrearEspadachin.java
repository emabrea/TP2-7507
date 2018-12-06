package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import Modelo.Edificio.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorCrearEspadachin implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;
	Cuartel cuartel;

	public ControladorCrearEspadachin(ContenedorPrincipal contenedor, Cuartel cuartel){
		this.contenedor = contenedor;
		this.cuartel = cuartel;
	}

    @Override
    public void handle(ActionEvent event) {
    	try{
        	//Reproductor
            String path = "src/Vista/Recursos/sounds/creacion_unidad.wav";
            Media media = new Media(new File(path).toURI().toString());
            MediaPlayer reproductorCrear = new MediaPlayer(media);

            this.cuartel.crearArquero(this.cuartel.posiblesCeldasParaCrearEspadachin().get(0));
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