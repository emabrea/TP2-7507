package Vista;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Controladores.*;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class Menu{

    MenuItem item1;
    MenuItem item2;
    MenuItem item3;
    MenuItem item4;
    MenuItem item5;
    MenuItem item6;
    MenuItem item7;
    MenuItem item8;
    ContextMenu contextMenu;

    public ContextMenu crearMenu(ContenedorPrincipal contenedor){

        ContextMenu contextMenu = new ContextMenu();

        MenuItem item4 = new MenuItem("Atacar");

        item4.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Ataca");

            ControladorDeTurno controladorDeTurno = ControladorDeTurno.getInstance();

            Jugador jugador = controladorDeTurno.jugadorEnTurno();

            Celda posicionActual = PosicionActual.obtenerInstancia().celda();
            Unidad unidadAtacante = UnidadActual.obtenerInstancia().unidad();
            Pieza piezaAAtacar = controladorDeTurno.jugadorFueraDeTurno().obtenerPieza(posicionActual);

            try{
                if(piezaAAtacar instanceof UnidadAtacable){

                    UnidadAtacable unidadAAtacar = (UnidadAtacable)piezaAAtacar;
                    if(unidadAtacante instanceof AtacanteDeUnidades){
                        ((AtacanteDeUnidades)unidadAtacante).atacar(unidadAAtacar);
                    }

                }else if(piezaAAtacar instanceof EdificioAtacable){
                    EdificioAtacable edificioAAtacar = (EdificioAtacable)piezaAAtacar;
                    if(unidadAtacante instanceof AtacanteDeEdificios){
                        ((AtacanteDeEdificios)unidadAtacante).atacar(edificioAAtacar);
                    }
                }
            }
            catch(JuegoTerminado e){
                new Alerta().juegoTerminado();
            }
            contenedor.actualizar();
        }
        });

        });





}
