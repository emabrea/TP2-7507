package Controladores;

import Modelo.Unidad.Aldeano;
import Vista.ContenedorPrincipal;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class MenuAldeano {

		ContenedorPrincipal contenedorPrincipal;
		Aldeano aldeano;
		MenuItem itemConstruirCuartel;
		MenuItem itemConstruirPlazaCentral;
		MenuItem itemReparar;
		ContextMenu contenedor;

		public MenuAldeano(ContenedorPrincipal contenedorPrincipal, Aldeano aldeano){
			this.contenedorPrincipal = contenedorPrincipal;
			this.aldeano = aldeano;
			this.inicializarItems();
			this.contenedor = new ContextMenu();
			this.contenedor.getItems().addAll(this.itemConstruirCuartel, this.itemConstruirPlazaCentral, this.itemReparar);
		}

		private void inicializarItems() {
			this.itemConstruirCuartel = new MenuItem("Contruir cuartel (50 oro)");
			this.itemConstruirPlazaCentral = new MenuItem("Contruir plaza central (100 oro)");
			this.itemReparar = new MenuItem("Reparar Edificio");

			this.itemConstruirCuartel.setOnAction(new ControladorConstruirCuartel(this.contenedorPrincipal, this.aldeano));
			this.itemConstruirPlazaCentral.setOnAction(new ControladorConstruirPlazaCentral(this.contenedorPrincipal, this.aldeano));
			this.itemReparar.setOnAction(new ControladorReparar(this.contenedorPrincipal, this.aldeano));
		}

		public ContextMenu getContenedor(){
			return this.contenedor;
		}
}
