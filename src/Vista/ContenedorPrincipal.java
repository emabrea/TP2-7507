package Vista;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;
import Modelo.Unidad.*;
import javafx.geometry.*;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.image.*;
import Controladores.*;




public class ContenedorPrincipal{	
	ContextMenu contextMenu;	
    HBox root;

	public ContenedorPrincipal(Juego juego,HBox root){		

		int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
        int baseMapa = Mapa.obtenerInstancia().getTamanioBase();
        this.contextMenu = new Menu().crearMenu();
        this.root = root;	        
        this.crearGrilla(baseMapa,alturaMapa,this.contextMenu,juego);
        this.agregarBotones();
        	        	     	
	}

	public void crearGrilla(int columnas,int filas,ContextMenu contextMenu,Juego juego){
		GridPane grid  = new GridPane();
        grid.setPadding(new Insets(2));
        grid.setHgap(1);
        grid.setVgap(1);        

        for (int r = 0; r < filas; r++) {
            for (int c = 0; c < columnas; c++) {                
                Button button = new Button();
                this.colorearMapa(button,c,Mapa.obtenerInstancia().getTamanioAltura()-r-1,juego);

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

                    Jugador jugador = ControladorDeTurno.getInstance().jugador();
                    PosicionActual posicion =PosicionActual.obtenerInstancia();
                    posicion.actualizar(x,Mapa.obtenerInstancia().getTamanioAltura()-y-1); 

                    PiezaActual piezaActual = PiezaActual.obtenerInstancia();
                    piezaActual.actualizar(x,Mapa.obtenerInstancia().getTamanioAltura()-y-1);  

                    
                    Pieza pieza = jugador.obtenerPieza(new Celda(posicion.getX(),posicion.getY()));
                    if(pieza != null){
                        System.out.println("Vida: "+pieza.obtenerVida()); 
                    }                           
                                        
                                      	    			    	
			    }
				});        
                grid.setRowIndex(button,r);
                grid.setColumnIndex(button,c);    
                grid.getChildren().add(button);                                            
            }
        } 
        this.root.getChildren().add(grid) ;
	}

    public void agregarBotones(){
        VBox vbox = new VBox(4);        
        Boton boton1 = new Boton("Finalizar Turno", new ControladorFinalizarTurno());
        Boton boton2 = new Boton("Atacar", new ControladorAtacar());
        Boton boton3 = new Boton("Construir Cuartel", new ControladorConstruirCuartel());
        Boton boton4 = new Boton("Construir Plaza Central", new ControladorConstruirPlazaCentral());       
        Boton boton5 = new Boton("Reparar", new ControladorReparar());
        vbox.getChildren().addAll(boton1,boton2,boton3,boton4,boton5) ; 

        HBox hbox1 = new HBox(4);
        Boton boton6 = new Boton("Mover arriba izquieda", new ControladorMoverArribaIzquierda());
        Boton boton7 = new Boton("Mover arriba", new ControladorMoverArriba());
        Boton boton8 = new Boton("Mover arriba derecha", new ControladorMoverArribaDerecha());   
        hbox1.getChildren().addAll(boton6,boton7,boton8) ;        

        HBox hbox2 = new HBox(4);
        Boton boton9 = new Boton("Mover izquieda", new ControladorMoverIzquierda());
        Boton boton10 = new Boton("Mover derecha", new ControladorMoverDerecha());
        hbox2.getChildren().addAll(boton9,boton10) ;     

        HBox hbox3 = new HBox(4);
        Boton boton11 = new Boton("Mover abajo izquieda", new ControladorMoverAbajoIzquierda());
        Boton boton12 = new Boton("Mover abajo", new ControladorMoverAbajo());
        Boton boton13 = new Boton("Mover abajo derecha", new ControladorMoverAbajoDerecha());
        hbox3.getChildren().addAll(boton11,boton12,boton13) ;       

        vbox.getChildren().addAll(hbox1,hbox2,hbox3) ; 
        this.root.getChildren().add(vbox) ;
        
        
    }	

    public void colorearMapa(Button button,int x,int y,Juego juego){
        for(Jugador jugador : juego.obtenerJugadores()){
            Pieza pieza = jugador.obtenerPieza(new Celda(x,y)) ;      
        
            if(pieza instanceof Aldeano){
                button.setStyle("-fx-background-color: #FE9A2E; ");
            }
            if(pieza instanceof Castillo){
                 button.setStyle("-fx-background-color: #FF0000; ");
            }
            if(pieza instanceof PlazaCentral){
                button.setStyle("-fx-background-color: #8A4B08; ");
            }
        }            
    }
}