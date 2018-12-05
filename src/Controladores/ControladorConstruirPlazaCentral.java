package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorConstruirPlazaCentral implements EventHandler<ActionEvent>{	

    ContenedorPrincipal contenedor;

	public ControladorConstruirPlazaCentral(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
    	System.out.println("Contruye plaza central");   
    	Celda celda = PosicionActual.obtenerInstancia().celda();  
    	Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
        try{
            if(unidadActual instanceof Aldeano){
                Aldeano aldeano = (Aldeano)UnidadActual.obtenerInstancia().unidad();
                aldeano.construirPlazaCentralEnZona(new Zona(celda,2,2));           
            }
            else{
                throw new NoEsPosibleConstruirException();
            }
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