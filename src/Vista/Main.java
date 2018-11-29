package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Modelo.Juego.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.text.*;



public class Main extends Application  {

    
    @Override
    public void start(Stage stage) {
        
        Juego juego = new Juego();       
        ControladorDeTurno.getInstance().asignarJugadores(juego.obtenerJugadores());
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(juego);
        int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
        int baseMapa = Mapa.obtenerInstancia().getTamanioAltura();
        ContextMenu contextMenu = new Menu().crearMenu();     
        GridPane root = contenedorPrincipal.crearGrilla(baseMapa,alturaMapa,contextMenu,juego);  

        Boton botonConstruirCuartel = new Boton("Construir Cuartel", new ControladorConstruirCuartel());   
        VBox contenedorVertical = new VBox(botonConstruirCuartel);           
        

        Scene scene = new Scene(root, 500, 500); 
        stage.setScene(scene);         
        stage.setTitle("Age of Empires II");
        stage.setHeight(800);
        stage.setWidth(1000);
        stage.show();       

    }
   


    public static void main(String[] args) {
        Application.launch(args);
    }
}