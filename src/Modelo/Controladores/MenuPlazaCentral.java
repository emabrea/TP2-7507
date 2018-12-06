package Controladores;

import Modelo.Edificio.PlazaCentral;
import Vista.ContenedorPrincipal;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class MenuPlazaCentral {

	ContenedorPrincipal contenedorPrincipal;
	MenuItem itemCrearAldeano;
	PlazaCentral plazaCentral;
	ContextMenu contenedor;

	public MenuPlazaCentral(ContenedorPrincipal contenedorPrincipal, PlazaCentral plazaCentral){
		this.contenedorPrincipal = contenedorPrincipal;
		this.plazaCentral = plazaCentral;
		this.inicializarItems();
		this.contenedor = new ContextMenu();
		this.contenedor.getItems().add(this.itemCrearAldeano);
	}

	private void inicializarItems() {
		this.itemCrearAldeano = new MenuItem("Crear aldeano (25 oro)");
		this.itemCrearAldeano.setOnAction(new ControladorCrearAldeano(this.contenedorPrincipal, this.plazaCentral));
	}

	public ContextMenu getContenedor(){
		return this.contenedor;
	}

}
