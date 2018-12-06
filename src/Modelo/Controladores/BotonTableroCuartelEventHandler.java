package Controladores;

import Modelo.Edificio.Cuartel;
import Vista.ContenedorPrincipal;
import Vista.EdificioActual;
import Vista.PosicionActual;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BotonTableroCuartelEventHandler implements EventHandler<MouseEvent>{

	Cuartel cuartel;
	ContenedorPrincipal contenedorPrincipal;
	ImageView imagen;

	public BotonTableroCuartelEventHandler(Cuartel cuartel, ContenedorPrincipal contenedorPrincipal, ImageView imagen) {
		this.cuartel = cuartel;
		this.contenedorPrincipal = contenedorPrincipal;
		this.imagen = imagen;
	}

	@Override
	public void handle(MouseEvent event) {
		 if(event.isSecondaryButtonDown()){
			 MenuCuartel menuCuartel= new MenuCuartel(this.contenedorPrincipal, this.cuartel);
			 menuCuartel.getContenedor().show(this.imagen, event.getSceneX(), event.getSceneY());
		 } else if(event.isPrimaryButtonDown()){
			 this.contenedorPrincipal.imprimirVida(this.cuartel.obtenerVida());
			 EdificioActual edificio = EdificioActual.obtenerInstancia();
			 edificio.actualizar(this.cuartel);
			 PosicionActual posicion = PosicionActual.obtenerInstancia();
			 posicion.actualizar(this.cuartel.obtenerPosicion());
		 }
	}

}
