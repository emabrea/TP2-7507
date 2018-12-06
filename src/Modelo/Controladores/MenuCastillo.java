package Controladores;

import Modelo.Edificio.Castillo;
import Vista.ContenedorPrincipal;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class MenuCastillo {
	ContenedorPrincipal contenedorPrincipal;
	MenuItem itemCrearArmaDeAsedio;
	Castillo castillo;
	ContextMenu contenedor;

	public MenuCastillo(ContenedorPrincipal contenedorPrincipal, Castillo castillo){
		this.contenedorPrincipal = contenedorPrincipal;
		this.castillo = castillo;
		this.inicializarItems();
		this.contenedor = new ContextMenu();
		this.contenedor.getItems().add(this.itemCrearArmaDeAsedio);
	}

	private void inicializarItems() {
		this.itemCrearArmaDeAsedio = new MenuItem("Crear arma de asedio (200 oro)");
		this.itemCrearArmaDeAsedio.setOnAction(new ControladorCrearArmaDeAsedio(this.contenedorPrincipal, this.castillo));
	}

	public ContextMenu getContenedor(){
		return this.contenedor;
	}

}
