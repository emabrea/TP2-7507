package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application  {


    @Override
    public void start(Stage stage) {

        /*Juego juego = new Juego();
        HBox root = new HBox(5);
        ControladorDeTurno.getInstance().asignarJugadores(juego.obtenerJugadores());
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(juego,root);
        ControladorDeTurno.getInstance().setearContenedor(contenedorPrincipal);*/

    	ContenedorEntrada contenedorEntrada = new ContenedorEntrada(stage);

        Scene scene = new Scene(contenedorEntrada.getContenedor(), 1600, 800);
        stage.setTitle("Algo of Empires");
        stage.setMinHeight(800);
        stage.setMinWidth(1600);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}