package Vista;

import Controladores.*;
import Modelo.Edificio.*;
import Modelo.Juego.Celda;
import Modelo.Unidad.*;
import javafx.event.EventHandler;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;

public class BotonTablero{

	ImageView contenedor;

	public BotonTablero(String url, int jugadorNum){
		String colorJugador = this.sacarColorJugador(jugadorNum);
		this.contenedor = this.crearImagen(url + colorJugador);
	}

	public void setHandler(EventHandler<? super MouseEvent> evento){
		this.contenedor.setOnMousePressed(evento);
	}

	private String sacarColorJugador(int num) {
		if(num == 0) return "Azul.jpg";
		if(num == 1) return "Rojo.jpg";
		else return ".jpg";
	}

	public static BotonTablero crearBotonTableroCuartel(int jugadorNum, Cuartel pieza, ContenedorPrincipal contenedorPrincipal){
		String url = "file:src/Recursos/cuartel";
		BotonTablero botonNuevo = new BotonTablero(url, jugadorNum);
		botonNuevo.setHandler(new BotonTableroCuartelEventHandler(pieza, contenedorPrincipal, botonNuevo.getContenedor()));
		return botonNuevo;
	}
	public static BotonTablero crearBotonTableroCastillo(int jugadorNum, Castillo pieza, ContenedorPrincipal contenedorPrincipal){
		String url = "file:src/Recursos/castillo";
		BotonTablero botonNuevo = new BotonTablero(url, jugadorNum);
		botonNuevo.setHandler(new BotonTableroCastilloEventHandler(pieza, contenedorPrincipal, botonNuevo.getContenedor()));
		return botonNuevo;
	}
	public static BotonTablero crearBotonTableroPlazaCentral(int jugadorNum, PlazaCentral pieza, ContenedorPrincipal contenedorPrincipal){
		String url = "file:src/Recursos/plazaCentral";
		BotonTablero botonNuevo = new BotonTablero(url, jugadorNum);
		botonNuevo.setHandler(new BotonTableroPlazaCentralEventHandler(pieza, contenedorPrincipal, botonNuevo.getContenedor()));
		return botonNuevo;
	}
	public static BotonTablero crearBotonTableroAldeano(int jugadorNum, Aldeano pieza, ContenedorPrincipal contenedorPrincipal){
		String url = "file:src/Recursos/aldeano";
		BotonTablero botonNuevo = new BotonTablero(url, jugadorNum);
		botonNuevo.setHandler(new BotonTableroAldeanoEventHandler(pieza, contenedorPrincipal, botonNuevo.getContenedor()));
		return botonNuevo;
	}
	public static BotonTablero crearBotonTableroArquero(int jugadorNum, Arquero pieza, ContenedorPrincipal contenedorPrincipal){
		String url = "file:src/Recursos/arquero";
		BotonTablero botonNuevo = new BotonTablero(url, jugadorNum);
		botonNuevo.setHandler(new BotonTableroArqueroEventHandler(pieza, contenedorPrincipal));
		return botonNuevo;
	}
	public static BotonTablero crearBotonTableroArmaDeAsedio(int jugadorNum, ArmaDeAsedio pieza, ContenedorPrincipal contenedorPrincipal){
		String url = "file:src/Recursos/armaDeAsedio";
		BotonTablero botonNuevo = new BotonTablero(url, jugadorNum);
		botonNuevo.setHandler(new BotonTableroArmaDeAsedioEventHandler(pieza, contenedorPrincipal));
		return botonNuevo;
	}
	public static BotonTablero crearBotonTableroEspadachin(int jugadorNum, Espadachin pieza, ContenedorPrincipal contenedorPrincipal){
		String url = "file:src/Recursos/espadachin";
		BotonTablero botonNuevo = new BotonTablero(url, jugadorNum);
		botonNuevo.setHandler(new BotonTableroEspadachinEventHandler(pieza, contenedorPrincipal));
		return botonNuevo;
	}
	public static BotonTablero crearBotonTableroVacio(Celda celda){
		String url = "file:src/Recursos/grass";
		BotonTablero botonNuevo = new BotonTablero(url, 3);
		botonNuevo.setHandler(new BotonTableroVacioEventHandler(celda));
		return botonNuevo;
	}
	private ImageView crearImagen(String url){
		ImageView contenedorAux = new ImageView(new Image(url));
		return contenedorAux;
	}
	public ImageView getContenedor(){
		return this.contenedor;
	}
}
