package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Modelo.Juego.*;

public class Main extends Application  {


    @Override
    public void start(Stage stage) {
           
        Juego juego = new Juego();       
        ControladorDeTurno.getInstance().asignarJugadores(juego.obtenerJugadores());
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(juego);
        
        stage.setScene(new Scene(contenedorPrincipal.iniciarGrilla()));
        stage.setHeight(800);
        stage.setWidth(1000);
        stage.show();       

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}