package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;

import java.util.ArrayList;

import Modelo.Excepciones.*;
import Vista.*;


public class ControladorConstruirPlazaCentral implements EventHandler<ActionEvent>{

    ContenedorPrincipal contenedor;
    Aldeano aldeano;

	public ControladorConstruirPlazaCentral(ContenedorPrincipal contenedor, Aldeano aldeano){
		this.contenedor = contenedor;
		this.aldeano = aldeano;
	}

    @Override
    public void handle(ActionEvent event) {
    	//Celda celda = (Celda) PosicionActual.obtenerInstancia().posicion();
        try{
        	ArrayList<Zona> zonasPosibles = this.aldeano.posiblesZonasAConstruirPlazaCentral();
        	this.aldeano.construirPlazaCentralEnZona(zonasPosibles.get(0));
        	//aldeano.construirPlazaCentralEnZona(new Zona(celda,2,2));
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
        this.contenedor.actualizar();

        }
}