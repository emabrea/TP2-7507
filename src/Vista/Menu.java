package Vista;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Controladores.*;

public class Menu{

	public ContextMenu crearMenu(){
		Label label = new Label();
        ContextMenu contextMenu = new ContextMenu(); 
        
        MenuItem item1 = new MenuItem("Atacar");
        item1.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
            label.setText("Select Menu Item 1");
        }
        });

        MenuItem item2 = new MenuItem("Mover");
        item2.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
            label.setText("Select Menu Item 2");
        }
        });

        MenuItem item3 = new MenuItem("Construir cuartel");
        item3.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
            //label.setText("Select Menu Item 2");
        }
        });

        MenuItem item4 = new MenuItem("Construir plaza central");
        item4.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
            label.setText("Select Menu Item 2");
        }
        });

        MenuItem item5 = new MenuItem("Reparar");
        item5.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
            label.setText("Select Menu Item 2");
        }
        });

        MenuItem item6 = new MenuItem("Crear aldeano");
        item6.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
            label.setText("Select Menu Item 2");
        }
        });

        MenuItem item7 = new MenuItem("Crear arquero");
        item7.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
            label.setText("Select Menu Item 2");
        }
        });
       
        MenuItem item8 = new MenuItem("Crear espadachin");
        item8.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
            label.setText("Select Menu Item 2");
        }
        });    

        MenuItem item9 = new MenuItem("Crear arma de asedio");
        item9.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
            label.setText("Select Menu Item 2");
        }
        });

        // Add MenuItem to ContextMenu
        contextMenu.getItems().addAll(item1, item2,item3,item4,item5,item6,item7,item8,item9);
        return contextMenu;
	}

}
