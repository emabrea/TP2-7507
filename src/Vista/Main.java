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
import Controladores.*;


public class Main extends Application  {

    
    @Override
    public void start(Stage stage) {
        
        Juego juego = new Juego();  
        HBox root = new HBox(5);     
        ControladorDeTurno.getInstance().asignarJugadores(juego.obtenerJugadores());
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(juego,root);     
           
    
        Scene scene = new Scene(root, 500, 500); 
        stage.setScene(scene);         
        stage.setTitle("Age of Empires II");
        stage.setHeight(700);
        stage.setWidth(1300);
        stage.show();       

    }
   


    public static void main(String[] args) {
        Application.launch(args);
    }
}