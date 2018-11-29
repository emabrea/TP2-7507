package Vista;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;
import Modelo.Juego.*;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;




public class ContenedorPrincipal{	
	ContextMenu contextMenu;	

	public ContenedorPrincipal(Juego juego){		

		int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
        int baseMapa = Mapa.obtenerInstancia().getTamanioAltura();
        this.contextMenu = new Menu().crearMenu();		        	     	
	}

	public GridPane crearGrilla(int columnas,int filas,ContextMenu contextMenu,Juego juego){
		GridPane grid  = new GridPane();
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
                grid.setRowIndex(button,r);
                grid.setColumnIndex(button,c);    
                grid.getChildren().add(button);                                            
            }
        } 
        return grid;  
	}


	


}