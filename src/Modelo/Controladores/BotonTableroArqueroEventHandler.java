package Controladores;

import Modelo.Unidad.Arquero;
import Vista.ContenedorPrincipal;
import Vista.PosicionActual;
import Vista.UnidadActual;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonTableroArqueroEventHandler implements EventHandler<MouseEvent>{

	Arquero arquero;
	ContenedorPrincipal contenedorPrincipal;

	public BotonTableroArqueroEventHandler(Arquero arquero, ContenedorPrincipal contenedorPrincipal) {
		this.arquero = arquero;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(MouseEvent event) {
		 if(event.isSecondaryButtonDown()){

		 } else if(event.isPrimaryButtonDown()){
			 this.contenedorPrincipal.imprimirVida(this.arquero.obtenerVida());
			 PosicionActual posicion = PosicionActual.obtenerInstancia();
			 posicion.actualizar(this.arquero.obtenerPosicion());
			 UnidadActual unidad = UnidadActual.obtenerInstancia();
			 unidad.actualizar(this.arquero);
		 }
	}

}
