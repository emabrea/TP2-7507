package Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Vista.*;


public class ControladorConstruirCuartel implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;

	public ControladorConstruirCuartel(ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

    @Override
    public void handle(ActionEvent event) {
    	System.out.println("Contruye cuartel");   
    	Celda celda = PosicionActual.obtenerInstancia().celda();  
    	Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
        try{
            if(unidadActual instanceof Aldeano){
                Aldeano aldeano = (Aldeano)UnidadActual.obtenerInstancia().unidad();
                aldeano.construirCuartelEnZona(new Zona(celda,2,2));            
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