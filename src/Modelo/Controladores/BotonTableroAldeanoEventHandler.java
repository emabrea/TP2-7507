package Controladores;

import Modelo.Unidad.Aldeano;
import Vista.ContenedorPrincipal;
import Vista.PosicionActual;
import Vista.UnidadActual;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BotonTableroAldeanoEventHandler implements EventHandler<MouseEvent>{

	Aldeano aldeano;
	ContenedorPrincipal contenedorPrincipal;
	ImageView imagen;

	public BotonTableroAldeanoEventHandler(Aldeano aldeano, ContenedorPrincipal contenedorPrincipal, ImageView imagen) {
		this.aldeano = aldeano;
		this.contenedorPrincipal = contenedorPrincipal;
		this.imagen = imagen;
	}

	@Override
	public void handle(MouseEvent event) {
		 if(event.isSecondaryButtonDown()){
			 MenuAldeano menuAldeano = new MenuAldeano(this.contenedorPrincipal, this.aldeano);
			 menuAldeano.getContenedor().show(this.imagen, event.getSceneX(), event.getSceneY());
		 } else if(event.isPrimaryButtonDown()){
			 this.contenedorPrincipal.imprimirVida(aldeano.obtenerVida());
			 PosicionActual posicion = PosicionActual.obtenerInstancia();
			 posicion.actualizar(this.aldeano.obtenerPosicion());
			 UnidadActual unidad = UnidadActual.obtenerInstancia();
			 unidad.actualizar(this.aldeano);
		 }
	}


}
