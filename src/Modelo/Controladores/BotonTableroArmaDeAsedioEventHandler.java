package Controladores;

import Modelo.Unidad.ArmaDeAsedio;
import Vista.ContenedorPrincipal;
import Vista.PosicionActual;
import Vista.UnidadActual;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonTableroArmaDeAsedioEventHandler implements EventHandler<MouseEvent> {

	ArmaDeAsedio armaDeAsedio;
	ContenedorPrincipal contenedorPrincipal;

	public BotonTableroArmaDeAsedioEventHandler(ArmaDeAsedio armaDeAsedio, ContenedorPrincipal contenedorPrincipal) {
		this.armaDeAsedio = armaDeAsedio;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(MouseEvent event) {
		 if(event.isSecondaryButtonDown()){

		 } else if(event.isPrimaryButtonDown()){
			 this.contenedorPrincipal.imprimirVida(this.armaDeAsedio.obtenerVida());
			 PosicionActual posicion = PosicionActual.obtenerInstancia();
			 posicion.actualizar(this.armaDeAsedio.obtenerPosicion());
			 UnidadActual unidad = UnidadActual.obtenerInstancia();
			 unidad.actualizar(this.armaDeAsedio);
		 }
	}

}
