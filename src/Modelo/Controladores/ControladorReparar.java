package Controladores;

import Modelo.Edificio.Edificio;
import Modelo.Excepciones.*;
import Modelo.Unidad.Aldeano;
import Vista.Alerta;
import Vista.ContenedorPrincipal;
import Vista.EdificioActual;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorReparar implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;
	Aldeano aldeano;

	public ControladorReparar(ContenedorPrincipal contenedor, Aldeano aldeano){
		this.aldeano = aldeano;
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {

    	try{
    		Edificio edificioActual = EdificioActual.obtenerInstancia().edificio();
            if(edificioActual == null){
                throw new NoEsPosibleRepararException();
            }
            aldeano.repararEdificio(edificioActual);
            contenedor.actualizar();

        }catch(NoEsPosibleRepararException e){
            new Alerta().noEsPosibleReparar();

        }catch(AldeanoOcupado e){

            new Alerta().AldeanoOcupado();
        }
    }

}