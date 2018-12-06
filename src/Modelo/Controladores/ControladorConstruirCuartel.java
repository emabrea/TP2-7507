package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

import Modelo.Excepciones.*;
import Modelo.Juego.*;
import Modelo.Unidad.Aldeano;
import Vista.*;


public class ControladorConstruirCuartel implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;
	Aldeano aldeano;

	public ControladorConstruirCuartel(ContenedorPrincipal contenedor, Aldeano aldeano){
		this.contenedor = contenedor;
		this.aldeano = aldeano;
	}

	@Override
	public void handle(ActionEvent event) {
		//Celda celda = (Celda) PosicionActual.obtenerInstancia().posicion();
    	try{
    		ArrayList<Zona> zonasPosibles = this.aldeano.posiblesZonasAConstruirCuartel();
        	this.aldeano.construirCuartelEnZona(zonasPosibles.get(0));
    		//aldeano.construirCuartelEnZona(new Zona(celda,2,2));
    	}
    	catch(AldeanoOcupado e){
    		new Alerta().AldeanoOcupado();
    	}
    	catch(NoEsPosibleConstruirException e){
    		new Alerta().noSePuedeConstruirAhi();
    	}
    	catch(OroInsuficienteException e){
    		new Alerta().oroInsuficiente();
    	}
    	contenedor.actualizar();
	}

}