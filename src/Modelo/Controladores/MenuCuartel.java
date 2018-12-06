package Controladores;

import Modelo.Edificio.Cuartel;
import Vista.ContenedorPrincipal;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class MenuCuartel {
	ContenedorPrincipal contenedorPrincipal;
	MenuItem itemCrearArquero;
	MenuItem itemCrearEspadachin;
	Cuartel cuartel;
	ContextMenu contenedor;

	public MenuCuartel(ContenedorPrincipal contenedorPrincipal, Cuartel cuartel){
		this.contenedorPrincipal = contenedorPrincipal;
		this.cuartel = cuartel;
		this.inicializarItems();
		this.contenedor = new ContextMenu();
		this.contenedor.getItems().addAll(this.itemCrearArquero, this.itemCrearEspadachin);
	}

	private void inicializarItems() {
		this.itemCrearEspadachin = new MenuItem("Crear espadachin (50 oro)");
		this.itemCrearArquero = new MenuItem("Crea arquero (75 oro)");

		this.itemCrearEspadachin.setOnAction(new ControladorCrearEspadachin(this.contenedorPrincipal, this.cuartel));
		this.itemCrearArquero.setOnAction(new ControladorCrearArquero(this.contenedorPrincipal, this.cuartel));
	}

	public ContextMenu getContenedor(){
		return this.contenedor;
	}
}
