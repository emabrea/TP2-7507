package Vista;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import Modelo.Juego.*;
import Modelo.Edificio.*;
import Modelo.Unidad.*;
import javafx.scene.image.*;
import javafx.scene.text.*;

import java.util.ArrayList;

import Controladores.*;


public class ContenedorPrincipal{
    HBox root;
    Pane contenedorPrincipal;
    Juego juego;
    int alturaMapa = Mapa.obtenerInstancia().getTamanioAltura();
    int baseMapa = Mapa.obtenerInstancia().getTamanioBase();

	public ContenedorPrincipal(Juego juego,HBox root){
        this.root = root;
        this.juego = juego;
        this.crearGrilla(baseMapa,alturaMapa,juego);
        this.agregarBotones();
	}

	public void crearGrilla(int columnas, int filas, Juego juego){
		Pane contenedorPrincipal  = new Pane();

        ArrayList<Jugador> jugadores = this.juego.obtenerJugadores();
        ArrayList<Posicion> posicionesOcupadas = new ArrayList<Posicion>();
        int jugadorNum = 0;
        for(Jugador jugador: jugadores){
        	for (int r = 0; r < filas; r++) {
        		for (int c = 0; c < columnas; c++) {
        			Celda celda = new Celda(c, this.alturaMapa - r - 1);
        			Pieza piezaActual = jugador.obtenerPieza(celda);
        			BotonTablero botonActual;
        			Posicion posicionActual = celda;
        			if(piezaActual instanceof Aldeano){
        				botonActual = BotonTablero.crearBotonTableroAldeano(jugadorNum, (Aldeano)piezaActual, this);
        			} else if(piezaActual instanceof Castillo){
        				botonActual = BotonTablero.crearBotonTableroCastillo(jugadorNum, (Castillo)piezaActual, this);
        				posicionActual = piezaActual.obtenerPosicion();
        			}else if(piezaActual instanceof PlazaCentral){
        				botonActual = BotonTablero.crearBotonTableroPlazaCentral(jugadorNum, (PlazaCentral)piezaActual, this);
        				posicionActual = piezaActual.obtenerPosicion();
        			} else if(piezaActual instanceof Cuartel){
        				botonActual = BotonTablero.crearBotonTableroCuartel(jugadorNum, (Cuartel)piezaActual, this);
        				posicionActual = piezaActual.obtenerPosicion();
        			} else if(piezaActual instanceof Espadachin){
        				botonActual = BotonTablero.crearBotonTableroEspadachin(jugadorNum, (Espadachin)piezaActual, this);
        			} else if(piezaActual instanceof ArmaDeAsedio){
        				botonActual = BotonTablero.crearBotonTableroArmaDeAsedio(jugadorNum, (ArmaDeAsedio)piezaActual, this);
        			} else{
        				botonActual = BotonTablero.crearBotonTableroVacio(celda);
        			}
        			boolean insertable = true;
        			for(Posicion posicion: posicionesOcupadas){
        				if(posicion.igualA(posicionActual)){
        					if(piezaActual != null && ! piezaActual.esPiezaPropia(jugador)){
        						insertable = true;
        					}
        					else{
        						insertable = false;
        					}
        				}
        			}
        			if(insertable){
        				ImageView contenedorBotonActual = botonActual.getContenedor();
        				contenedorBotonActual.setY(r * 40);
        				contenedorBotonActual.setX(c * 40);
        				contenedorPrincipal.getChildren().add(contenedorBotonActual);
        				posicionesOcupadas.add(posicionActual);
        			}
        		}
        	}
        	jugadorNum += 1;
        }
        this.root.getChildren().add(contenedorPrincipal);
        this.contenedorPrincipal = contenedorPrincipal;
	}

    public void agregarBotones(){

    	VBox vbox = new VBox(4);
    	Boton boton1 = new Boton("Finalizar Turno", new ControladorFinalizarTurno(this));

        HBox hbox1 = new HBox(4);
        Image imagenArriba = new Image("file:src/Recursos/flechaArriba.png");
        Image imagenAbajo = new Image("file:src/Recursos/flechaAbajo.png");
        Image imagenIzq = new Image("file:src/Recursos/flechaIzq.png");
        Image imagenDer = new Image("file:src/Recursos/flechaDer.png");
        Image imagenArribaIzq = new Image("file:src/Recursos/flechaArribaIzq.png");
        Image imagenAbajoIzq = new Image("file:src/Recursos/flechaAbajoIzq.png");
        Image imagenArribaDer = new Image("file:src/Recursos/flechaArribaDer.png");
        Image imagenAbajoDer = new Image("file:src/Recursos/flechaAbajoDer.png");

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

        VBox vbox4 = new VBox();
        this.labelVida = new Label();
        labelVida.setFont(Font.font("Castellar", 24));

        Jugador jugador1 = juego.obtenerJugador1();
        Jugador jugador2 = juego.obtenerJugador2();

        Label labelOro1 = new Label("Oro de "+ jugador1.getNombre() +": "+ jugador1.cantidadDeOro());
        labelOro1.setFont(Font.font("Castellar", 24));
        Label labelOro2 = new Label("Oro de "+ jugador2.getNombre() +": "+ jugador2.cantidadDeOro());
        labelOro2.setFont(Font.font("Castellar", 24));

        Label labelPob1 = new Label("Poblacion de "+ jugador1.getNombre() +": "+ jugador1.poblacion());
        Label labelPob2 = new Label("Poblacion de "+ jugador2.getNombre() +": "+ jugador2.poblacion());
        labelPob1.setFont(Font.font("Castellar", 24));
        labelPob2.setFont(Font.font("Castellar", 24));
        Label labelturno = new Label("Es el turno de: " + ControladorDeTurno.getInstance().jugadorEnTurno().getNombre());
        labelturno.setFont(Font.font("Castellar", 24));
        vbox4.getChildren().addAll(this.labelVida,labelOro1,labelOro2,labelPob1,labelPob2,labelturno) ;
        vbox4.setMinWidth(600);
        labelturno.setMinWidth(600);
        labelPob1.setMinWidth(600);
        labelPob2.setMinWidth(600);
        labelOro1.setMinWidth(600);
        labelOro2.setMinWidth(600);
        this.labelVida.setMinWidth(600);

        hbox1.setTranslateX(40);
        hbox2.setTranslateX(40);
        hbox3.setTranslateX(40);
        vbox4.setTranslateX(40);
        boton1.setTranslateX(40);

        hbox1.setTranslateY(40);
        hbox2.setTranslateY(40);
        hbox3.setTranslateY(40);
        vbox4.setTranslateY(40);
        boton1.setTranslateY(40);

        vbox.getChildren().addAll(hbox1,hbox2,hbox3,vbox4, boton1) ;
        this.root.getChildren().addAll(vbox) ;
    }

    public void actualizar(){
    	this.root.getChildren().clear();
    	this.crearGrilla(baseMapa,alturaMapa,this.juego);
        this.agregarBotones();
    }

    Label labelVida = new Label();
	public void imprimirVida(int vida) {
		labelVida.setText("Vida: "+ vida);
	}
}