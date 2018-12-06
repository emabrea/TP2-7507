package Controladores;

import Modelo.Edificio.PlazaCentral;
import Vista.ContenedorPrincipal;
import Vista.EdificioActual;
import Vista.PosicionActual;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BotonTableroPlazaCentralEventHandler implements EventHandler<MouseEvent> {

	PlazaCentral plazaCentral;
	ContenedorPrincipal contenedorPrincipal;
	ImageView imagen;

	public BotonTableroPlazaCentralEventHandler(PlazaCentral plazaCentral, ContenedorPrincipal contenedorPrincipal, ImageView imagen) {
		this.plazaCentral = plazaCentral;
		this.contenedorPrincipal = contenedorPrincipal;
		this.imagen = imagen;
	}

	@Override
	public void handle(MouseEvent event) {
		 if(event.isSecondaryButtonDown()){
			 MenuPlazaCentral menuPlazaCentral= new MenuPlazaCentral(this.contenedorPrincipal, this.plazaCentral);
			 menuPlazaCentral.getContenedor().show(this.imagen, event.getSceneX(), event.getSceneY());
		 } else if(event.isPrimaryButtonDown()){
			 this.contenedorPrincipal.imprimirVida(plazaCentral.obtenerVida());
			 EdificioActual edificio = EdificioActual.obtenerInstancia();
			 edificio.actualizar(this.plazaCentral);
			 PosicionActual posicion = PosicionActual.obtenerInstancia();
			 posicion.actualizar(this.plazaCentral.obtenerPosicion());
		 }
	}

}
