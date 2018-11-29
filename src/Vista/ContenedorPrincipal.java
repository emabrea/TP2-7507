package Vista;

import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ContextMenu;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;
import Modelo.Juego.*;

public class ContenedorPrincipal{
	Grilla grilla;	
	ContextMenu contextMenu;	

	public ContenedorPrincipal(Juego juego){		

		int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
        int baseMapa = Mapa.obtenerInstancia().getTamanioAltura();
        this.contextMenu = new Menu().crearMenu();
		this.grilla = new Grilla(baseMapa,alturaMapa,contextMenu,juego);				
	}

	public ScrollPane iniciarGrilla(){
		return new ScrollPane(this.grilla.grilla());
	}


}