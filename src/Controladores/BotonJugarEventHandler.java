package Controladores;

import Modelo.Juego.Juego;
import Vista.ContenedorPrincipal;
import Vista.ContenedorEntrada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

	TextField nombreJugador1;
	TextField nombreJugador2;
	Stage stage;
	MediaPlayer mediaPlayer;

	public BotonJugarEventHandler(Stage stage, TextField nombreJugador1, TextField nombreJugador2 , MediaPlayer mediaPlayer){
		this.stage = stage;
		this.nombreJugador1 = nombreJugador1;
		this.nombreJugador2 = nombreJugador2;
		this.mediaPlayer = mediaPlayer;

	}

	@Override
	public void handle(ActionEvent event) {

		Juego juego = new Juego(nombreJugador1.getText(), nombreJugador2.getText());
        HBox root = new HBox(5);
        ControladorDeTurno.getInstance().asignarJugadores(juego.obtenerJugadores());
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(juego, root);
        ControladorDeTurno.getInstance().setearContenedor(contenedorPrincipal);
   		this.mediaPlayer.stop();

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Algo of Empires");
        stage.setMinHeight(800);
        stage.setMinWidth(1500);
        stage.setScene(scene);
	}


}
