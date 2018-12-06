package Controladores;

import Modelo.Edificio.Castillo;
import Vista.ContenedorPrincipal;
import Vista.PosicionActual;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BotonTableroCastilloEventHandler implements EventHandler<MouseEvent> {

	Castillo castillo;
	ContenedorPrincipal contenedorPrincipal;
	ImageView imagen;

	public BotonTableroCastilloEventHandler(Castillo castillo, ContenedorPrincipal contenedorPrincipal, ImageView imagen) {
		this.castillo = castillo;
		this.contenedorPrincipal = contenedorPrincipal;
		this.imagen = imagen;
	}

	@Override
	public void handle(MouseEvent event) {
		 if(event.isSecondaryButtonDown()){
			 MenuCastillo menuCastillo = new MenuCastillo(this.contenedorPrincipal, this.castillo);
			 menuCastillo.getContenedor().show(this.imagen, event.getSceneX(), event.getSceneY());
		 } else if(event.isPrimaryButtonDown()){
			 this.contenedorPrincipal.imprimirVida(this.castillo.obtenerVida());
			 PosicionActual posicion = PosicionActual.obtenerInstancia();
			 posicion.actualizar(this.castillo.obtenerPosicion());
		 }
	}

}
