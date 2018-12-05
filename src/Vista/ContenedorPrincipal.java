package Vista;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import Modelo.Juego.*;
import Modelo.Edificio.*;
import Modelo.Unidad.*;
import javafx.geometry.*;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import Controladores.*;


public class ContenedorPrincipal{		
    HBox root;
    GridPane grid;
    Juego juego;
    int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
    int baseMapa = Mapa.obtenerInstancia().getTamanioBase();   


	public ContenedorPrincipal(Juego juego,HBox root){
        this.root = root;	
        this.juego = juego;        
        this.crearGrilla(baseMapa,alturaMapa,juego);
        this.agregarBotones();        	        	     	
	}

	public void crearGrilla(int columnas,int filas,Juego juego){
		GridPane grid  = new GridPane();
        grid.setPadding(new Insets(2));
        grid.setHgap(1);
        grid.setVgap(1);        

        for (int r = 0; r < filas; r++) {
            for (int c = 0; c < columnas; c++) {       
                
                Button button = new Button();
                this.colorearMapa(button,c,Mapa.obtenerInstancia().getTamanioAltura()-r-1,juego);                   

                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
			    public void handle(MouseEvent event) {                    
			    	int x = grid.getColumnIndex(button);
			    	int y = grid.getRowIndex(button);			         

                    Jugador jugador = ControladorDeTurno.getInstance().jugadorEnTurno();
                    PosicionActual posicion = PosicionActual.obtenerInstancia();
                    posicion.actualizar(x,alturaMapa-y-1); 

                    PiezaActual piezaActual = PiezaActual.obtenerInstancia();
                    piezaActual.actualizar(x,alturaMapa-y-1); 
                    UnidadActual unidadActual = UnidadActual.obtenerInstancia();
                    unidadActual.actualizar(x,alturaMapa-y-1);
                    actualizar();
			    }
				}); 

                grid.setRowIndex(button,r);
                grid.setColumnIndex(button,c);    
                grid.getChildren().add(button);                                            
            }
        } 
        this.root.getChildren().add(grid) ;
        this.grid = grid;
	}

    public void agregarBotones(){
        VBox vbox = new VBox(4);        
        Boton boton1 = new Boton("Finalizar Turno", new ControladorFinalizarTurno(this));
        Boton boton2 = new Boton("Atacar", new ControladorAtacar(this));
        Boton boton3 = new Boton("Construir Cuartel", new ControladorConstruirCuartel(this));
        Boton boton4 = new Boton("Construir Plaza Central", new ControladorConstruirPlazaCentral(this));       
        Boton boton5 = new Boton("Reparar", new ControladorReparar());
        vbox.getChildren().addAll(boton1,boton2,boton3,boton4,boton5) ; 

        HBox hbox1 = new HBox(4);
        Boton boton6 = new Boton("Mover arriba izquieda", new ControladorMoverArribaIzquierda(this));
        Boton boton7 = new Boton("Mover arriba", new ControladorMoverArriba(this));
        Boton boton8 = new Boton("Mover arriba derecha", new ControladorMoverArribaDerecha(this));   
        hbox1.getChildren().addAll(boton6,boton7,boton8) ;        

        HBox hbox2 = new HBox(4);
        Boton boton9 = new Boton("Mover izquieda", new ControladorMoverIzquierda(this));
        Boton boton10 = new Boton("Mover derecha", new ControladorMoverDerecha(this));
        hbox2.getChildren().addAll(boton9,boton10) ;     

        HBox hbox3 = new HBox(4);
        Boton boton11 = new Boton("Mover abajo izquieda", new ControladorMoverAbajoIzquierda(this));
        Boton boton12 = new Boton("Mover abajo", new ControladorMoverAbajo(this));
        Boton boton13 = new Boton("Mover abajo derecha", new ControladorMoverAbajoDerecha(this));
        hbox3.getChildren().addAll(boton11,boton12,boton13) ; 

        VBox vbox4 = new VBox(4); 
        Boton boton14 = new Boton("Posicion actual", new ControladorPosicionActual());

        Label labelOro = new Label("Oro: "+ControladorDeTurno.getInstance().jugadorEnTurno().cantidadDeOro());
        Label labelVida = new Label("Vida: "+PiezaActual.obtenerInstancia().obtenerVida());

        vbox4.getChildren().addAll(boton14,labelOro,labelVida) ;

        vbox.getChildren().addAll(hbox1,hbox2,hbox3,vbox4) ;
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
            if(pieza instanceof Cuartel){
                button.setStyle("-fx-background-color: #2EFEF7; ");
            }
        }            
    }    

    public void actualizar(){
    	this.root.getChildren().clear();
    	this.crearGrilla(baseMapa,alturaMapa,this.juego);
        this.agregarBotones();  
    }
}