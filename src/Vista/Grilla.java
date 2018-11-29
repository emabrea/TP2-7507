package Vista;

import javafx.scene.layout.GridPane;
import javafx.scene.control.ContextMenu;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class Grilla{

    PosicionActual posicion; 
    GridPane grid ;
    
	public Grilla(int columnas,int filas,ContextMenu contextMenu,Juego juego){
		this.grid  = new GridPane();
        grid.setPadding(new Insets(2));
        grid.setHgap(1);
        grid.setVgap(1);        
        

        for (int r = 0; r < filas; r++) {
            for (int c = 0; c < columnas; c++) {                
                Button button = new Button();                                            

                button.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {  	
                @Override
                public void handle(ContextMenuEvent event) {     
                    contextMenu.show(button, event.getScreenX(), event.getScreenY());
                }
                });      

                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			    @Override
			    public void handle(MouseEvent event) {                    
			    	int x = grid.getColumnIndex(button);
			    	int y = grid.getRowIndex(button);

			        System.out.println("Row: "+ y);
					System.out.println("Column: "+ x);  

                    Jugador jugador = ControladorDeTurno.getInstance().jugador();
                    PosicionActual posicion =PosicionActual.obtenerInstancia();
                    posicion.actualizar(x,Mapa.obtenerInstancia().getTamanioAltura()-y-1); 

                    PiezaActual piezaActual = PiezaActual.obtenerInstancia();
                    piezaActual.actualizar(x,Mapa.obtenerInstancia().getTamanioAltura()-y-1);  

                    
                    Pieza pieza = jugador.obtenerPieza(new Celda(posicion.getX(),posicion.getY()));
                    if(pieza != null){
                        System.out.println("Vida: "+pieza.obtenerVida()); 
                    }                                      
                                        
                    System.out.println("Vida 2: "+piezaActual.obtenerPieza().obtenerVida());   
                    System.out.println(PosicionActual.obtenerInstancia().getY());                  	    			    	
			    }
				});        

                grid.add(button, c, r);                             
            }
        }   

        

	}   

    public GridPane grilla(){
        return this.grid;
    }
    
    
}