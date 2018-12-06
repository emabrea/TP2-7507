package Controladores;

import Modelo.Unidad.Espadachin;
import Vista.ContenedorPrincipal;
import Vista.PosicionActual;
import Vista.UnidadActual;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonTableroEspadachinEventHandler implements EventHandler<MouseEvent> {

	Espadachin espadachin;
	ContenedorPrincipal contenedorPrincipal;

	public BotonTableroEspadachinEventHandler(Espadachin espadachin, ContenedorPrincipal contenedorPrincipal) {
		this.espadachin = espadachin;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(MouseEvent event) {
		 if(event.isSecondaryButtonDown()){

		 } else if(event.isPrimaryButtonDown()){
			 this.contenedorPrincipal.imprimirVida(this.espadachin.obtenerVida());
			 PosicionActual posicion = PosicionActual.obtenerInstancia();
			 posicion.actualizar(this.espadachin.obtenerPosicion());
			 UnidadActual unidad = UnidadActual.obtenerInstancia();
			 unidad.actualizar(this.espadachin);
		 }
	}

}
