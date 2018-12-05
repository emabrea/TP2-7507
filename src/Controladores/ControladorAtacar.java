package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;
import Vista.*;


public class ControladorAtacar implements EventHandler<ActionEvent>{

    ContenedorPrincipal contenedor;

    public ControladorAtacar(ContenedorPrincipal contenedor){
        this.contenedor = contenedor;
    }

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
}