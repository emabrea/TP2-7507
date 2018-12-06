package Vista;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;
import Modelo.Unidad.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
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
        grid.setHgap(0.5);
        grid.setVgap(0.5);

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {

            	Button button = new Button();  
            	button.setMinHeight(40);
                button.setMinWidth(40);
                Celda celda = new Celda(col,Mapa.obtenerInstancia().getTamanioAltura()-fila-1);
            	Jugador jugador1 = juego.obtenerJugador1();
            	Jugador jugador2 = juego.obtenerJugador2();
            	Pieza pieza1 = jugador1.obtenerPieza(celda) ;
            	Pieza pieza2 = jugador2.obtenerPieza(celda) ;            	

            	if(pieza1 instanceof Aldeano  ){              	              	
                	button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/aldeano1.jpg');");	        	
            	}
            	else if(pieza2 instanceof Aldeano ){                	    	              	
                	button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/aldeano2.jpg');");	        	
            	}      	
            	else if(pieza1 instanceof Arquero ){                	         	                	
                	button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/arquero1.jpg');");	        	
            	}
            	else if(pieza2 instanceof Arquero ){               	     	                	
                	button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/arquero2.jpg');");	        	
            	}
            	else if(pieza1 instanceof Espadachin){                	               	
                	button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/espadachin1.jpg');");	        	
            	}
            	else if(pieza2 instanceof Espadachin){                	               	
                	button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/espadachin2.jpg');");	        	
            	}
            	else if(pieza1 instanceof PlazaCentral){ 
            		button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/cuartel1.jpg');");       		           		           	   		        	
            	} 
            	else if(pieza1 instanceof ArmaDeAsedio){ 
            		button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/armaAsedioDesmonatada1.jpg');");       		           		           	   		        	
            	}
            	else if(pieza2 instanceof ArmaDeAsedio){ 
            		button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/armaAsedioDesmonatada2.jpg');");       		           		           	   		        	
            	}
            	else{
            		button.setStyle("-fx-background-image: url('file:src/Vista/Recursos/grass.jpg');"); 
            	}                 
                                          
                this.colorearMapa(button,col,Mapa.obtenerInstancia().getTamanioAltura()-fila-1,juego);
                Menu menu = new Menu();
                ContextMenu contextMenu = menu.crearMenu(this); 

                button.setOnMousePressed(new EventHandler<MouseEvent>() {  	
	                @Override
	                public void handle(MouseEvent event) {
	                	int x = grid.getColumnIndex(button);
			    		int y = grid.getRowIndex(button);	                	   
	                    if(event.isSecondaryButtonDown()) {                   	
	                    	
			    			Pieza piezaActual = PiezaActual.obtenerInstancia().obtenerPieza();
	                    	PosicionActual posicion = PosicionActual.obtenerInstancia();
                    		posicion.actualizar(x,alturaMapa-y-1);
                    		if(piezaActual instanceof Aldeano){
                    			menu.crearMenuAldeano();
                    			contextMenu.show(button, event.getScreenX(), event.getScreenY());
                    		}
                    		if(piezaActual instanceof Arquero || piezaActual instanceof Espadachin){
                    			menu.crearMenuAtacante();
                    			contextMenu.show(button, event.getScreenX(), event.getScreenY());
                    		}
                    		if(piezaActual instanceof PlazaCentral){
                    			menu.crearMenuPlazaCentral();
                    			contextMenu.show(button, event.getScreenX(), event.getScreenY());
                    		}
                    		if(piezaActual instanceof Cuartel){
                    			menu.crearMenuCuartel();
                    			contextMenu.show(button, event.getScreenX(), event.getScreenY());
                    		}
                    		if(piezaActual instanceof Castillo){
                    			menu.crearMenuCastillo();
                    			contextMenu.show(button, event.getScreenX(), event.getScreenY());
                    		}
		      		 	}
		      		 	else{      		 		

		                    Jugador jugador = ControladorDeTurno.getInstance().jugadorEnTurno();
		                    PosicionActual posicion = PosicionActual.obtenerInstancia();
		                    posicion.actualizar(x,alturaMapa-y-1);

		                    PiezaActual piezaActual = PiezaActual.obtenerInstancia();
		                    piezaActual.actualizar(x,alturaMapa-y-1,juego);

		                    UnidadActual unidadActual = UnidadActual.obtenerInstancia();
		                    unidadActual.actualizar(x,alturaMapa-y-1);

		                    EdificioActual edificioActual = EdificioActual.obtenerInstancia();
		                    edificioActual.actualizar(x,alturaMapa-y-1);

		                    actualizar();
		      		 	}
	                }
                });                 

                grid.setRowIndex(button,fila);
                grid.setColumnIndex(button,col);               
                grid.getChildren().add(button);	 
                
            }
        }
        this.root.getChildren().add(grid) ;
        this.grid = grid;
	}

    public void agregarBotones(){
        VBox vbox = new VBox(4);        
        Boton boton1 = new Boton("Finalizar Turno", new ControladorFinalizarTurno(this));        
        vbox.getChildren().addAll(boton1) ;

        HBox hbox1 = new HBox(4);
        Image imagenArriba = new Image("file:src/Vista/Recursos/flechaArriba.png");
        Image imagenAbajo = new Image("file:src/Vista/Recursos/flechaAbajo.png");
        Image imagenIzq = new Image("file:src/Vista/Recursos/flechaIzq.png");
        Image imagenDer = new Image("file:src/Vista/Recursos/flechaDer.png");
        Image imagenArribaIzq = new Image("file:src/Vista/Recursos/flechaArribaIzq.png");
        Image imagenAbajoIzq = new Image("file:src/Vista/Recursos/flechaAbajoIzq.png");
        Image imagenArribaDer = new Image("file:src/Vista/Recursos/flechaArribaDer.png");
        Image imagenAbajoDer = new Image("file:src/Vista/Recursos/flechaAbajoDer.png");        

        ImageView imagenViewArriba = new ImageView(imagenArriba);   
        ImageView imagenViewAbajo = new ImageView(imagenAbajo);  
        ImageView imagenViewIzq = new ImageView(imagenIzq);  
        ImageView imagenViewDer = new ImageView(imagenDer); 
        ImageView imagenViewArribaIzq = new ImageView(imagenArribaIzq);   
        ImageView imagenViewAbajoIzq = new ImageView(imagenAbajoIzq);  
        ImageView imagenViewArribaDer = new ImageView(imagenArribaDer);  
        ImageView imagenViewAbajoDer = new ImageView(imagenAbajoDer);

        BotonImagen arribaIzquierda = new BotonImagen(imagenViewArribaIzq,new ControladorMoverArribaIzquierda(this));
        BotonImagen arriba = new BotonImagen(imagenViewArriba, new ControladorMoverArriba(this));
        BotonImagen arribaDerecha = new BotonImagen(imagenViewArribaDer, new ControladorMoverArribaDerecha(this));
        hbox1.getChildren().addAll(arribaIzquierda,arriba,arribaDerecha) ;

        HBox hbox2 = new HBox(65);
        BotonImagen izquierda = new BotonImagen(imagenViewIzq, new ControladorMoverIzquierda(this));        
        BotonImagen derecha = new BotonImagen(imagenViewDer, new ControladorMoverDerecha(this));
        hbox2.getChildren().addAll(izquierda,derecha) ;

        HBox hbox3 = new HBox(4);
        BotonImagen abajoIzquierda = new BotonImagen(imagenViewAbajoIzq, new ControladorMoverAbajoIzquierda(this));        
        BotonImagen abajo = new BotonImagen(imagenViewAbajo, new ControladorMoverAbajo(this));
        BotonImagen abajoDerecha = new BotonImagen(imagenViewAbajoDer, new ControladorMoverAbajoDerecha(this));
        hbox3.getChildren().addAll(abajoIzquierda,abajo,abajoDerecha) ;

        VBox vbox4 = new VBox(15);        
        Label labelVida = new Label("Vida: "+PiezaActual.obtenerInstancia().obtenerVida());
        labelVida.setFont(Font.font("Castellar", 24));    

        Label labelOro1 = new Label("Oro jugador 1: "+ juego.obtenerJugador1().cantidadDeOro());
        labelOro1.setFont(Font.font("Castellar", 24));
        Label labelOro2 = new Label("Oro jugador 2: "+ juego.obtenerJugador2().cantidadDeOro());
        labelOro2.setFont(Font.font("Castellar", 24));

        Label labelPob1 = new Label("Poblacion jugador 1: "+ juego.obtenerJugador1().poblacion());
        Label labelPob2 = new Label("Poblacion jugador 2: "+ juego.obtenerJugador2().poblacion());
        labelPob1.setFont(Font.font("Castellar", 24));
        labelPob2.setFont(Font.font("Castellar", 24));
        Label labelturno = new Label("Es el turno de " + ControladorDeTurno.getInstance().jugadorEnTurno().getNombre());
        labelturno.setFont(Font.font("Castellar", 24));
        vbox4.getChildren().addAll(labelVida,labelOro1,labelOro2,labelPob1,labelPob2,labelturno) ;        

        vbox.getChildren().addAll(hbox1,hbox2,hbox3,vbox4) ;
        this.root.getChildren().addAll(vbox) ;

    }    


    public void colorearMapa(Button button,int x,int y,Juego juego){
        for(Jugador jugador : juego.obtenerJugadores()){
            Pieza pieza = jugador.obtenerPieza(new Celda(x,y)) ;
           
            if(pieza instanceof Castillo){
                 button.setStyle("-fx-background-color: #FF0000; ");
            }
            else if(pieza instanceof PlazaCentral){
                button.setStyle("-fx-background-color: #8A4B08; ");
            }
            else if(pieza instanceof Cuartel){
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