package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorReparar implements EventHandler<ActionEvent>{

    ContenedorPrincipal contenedor;

    public ControladorReparar(ContenedorPrincipal contenedor){
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent event) {

        System.out.println("Repara");

        try{
            Edificio edificioActual = EdificioActual.obtenerInstancia().edificio();
            Unidad unidadQueRepara = UnidadActual.obtenerInstancia().unidad();

            if(unidadQueRepara instanceof Aldeano){
                Aldeano aldeano = (Aldeano)unidadQueRepara;
                aldeano.repararEdificio(edificioActual);
                this.contenedor.actualizar();
            }
        }catch(NoEsPosibleRepararException e){
            new Alerta().AldeanoDebeEstarAlLadoDelEdificioAReparar();
        }catch(AldeanoOcupado e){
            new Alerta().AldeanoOcupado();
        }
    }
}