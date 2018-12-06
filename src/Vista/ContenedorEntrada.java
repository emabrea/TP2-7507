package Vista;

import Controladores.BotonJugarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;	

public class ContenedorEntrada {

	VBox contenedorPrincipal;

	public ContenedorEntrada(Stage stage){


		// Para poner el nombre del jugador1 y jugador2
		TextField nombreJugador1 = new TextField();
		TextField nombreJugador2 = new TextField();
		nombreJugador1.setPromptText("Ingrese el nombre del jugador");
		nombreJugador2.setPromptText("Ingrese el nombre del jugador");		
		nombreJugador1.setMinWidth(250);
		nombreJugador2.setMinWidth(250);
		nombreJugador1.setPadding(new Insets(10));
		nombreJugador2.setPadding(new Insets(10));

		// Boton jugar
		Button botonJugar = new Button();
		botonJugar.setText("Jugar");		
		botonJugar.setPadding(new Insets(20));

		// Contenedor nombres
		HBox contenedorNombres = new HBox(nombreJugador1, nombreJugador2);
		contenedorNombres.setSpacing(960);
		contenedorNombres.setPadding(new Insets(50));

		// Contenedor Labels
		Label label1 = new Label("Nombre Jugador 1");
		Label label2 = new Label("Nombre Jugador 2");
		label1.setTextFill(Color.BLUE);
		label2.setTextFill(Color.BLUE);
		label1.setFont(Font.font("Castellar", 24));
		label2.setFont(Font.font("Castellar", 24));		
		label1.setTranslateY(50);
		label2.setTranslateX(-30);	
		label2.setTranslateY(50);	


		//Reproductor
		String path = "src/Vista/Recursos/intro.wav";
		Media media = new Media(new File(path).toURI().toString());
		MediaPlayer reproductor = new MediaPlayer(media);

		//ContenedorLabels
		HBox contenedorLabels = new HBox(label1, label2);
		contenedorLabels.setSpacing(950);
		contenedorLabels.setPadding(new Insets(0, 0, 0, 55));

		//	Contenedor Boton
		VBox contenedorBoton = new VBox(botonJugar);
		contenedorBoton.setPadding(new Insets(30, 0, 0 , 800));		
		botonJugar.setTranslateX(600);
		botonJugar.setTranslateY(-200);	

		// Contenedor principal
		this.contenedorPrincipal = new VBox(contenedorBoton, contenedorLabels);	
		this.contenedorPrincipal.getChildren().add(contenedorNombres);	
		this.contenedorPrincipal.setAlignment(Pos.CENTER);		
		this.contenedorPrincipal.setStyle("-fx-background-image: url('file:src/imagenEntrada.jpg');");

		BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, nombreJugador1, nombreJugador2 , reproductor);
		
		reproductor.play();

		botonJugar.setOnAction(botonJugarEventHandler);
		

		//nombreJugador1.setOnKeyPressed(new TextoEventHandler(botonJugar));
		//nombreJugador2.setOnKeyPressed(new TextoEventHandler(botonJugar));

		

	}

	public VBox getContenedor() {
		return this.contenedorPrincipal;
	}
}
