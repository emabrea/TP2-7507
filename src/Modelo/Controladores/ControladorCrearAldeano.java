package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import Modelo.Edificio.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorCrearAldeano implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;
	PlazaCentral plazaCentral;

	public ControladorCrearAldeano(ContenedorPrincipal contenedor, PlazaCentral plazaCentral){
		this.contenedor = contenedor;
		this.plazaCentral = plazaCentral;
	}

    @Override
    public void handle(ActionEvent event) {

         try{
              //Reproductor
              String path = "src/Vista/Recursos/sounds/creacion_unidad.wav";
              Media media = new Media(new File(path).toURI().toString());
              MediaPlayer reproductorCrear = new MediaPlayer(media);

              this.plazaCentral.crearAldeano(this.plazaCentral.posiblesCeldasParaCrearAldeano().get(0));
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