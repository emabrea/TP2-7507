package Modelo;
import java.util.ArrayList;


public class Aldeano extends Unidad{
	
	EstadoAldeano estado;
	
	public Aldeano(Celda celda, Jugador jugador){
		super(celda, 50, 25, jugador);
		this.estado = new AldeanoRecolectandoOro();
	}
	
	public void actualizarEstado(EstadoAldeano estadoNuevo) {
		this.estado = estadoNuevo;
	}

	public ArrayList<Zona> posiblesZonasAConstruirCuartel() {
		Mapa mapa = Mapa.obtenerInstancia();
		int base = Cuartel.getTamanioBase();
		int altura = Cuartel.getTamanioAltura();
		
		Celda celdaDeBusqueda = ((Celda)this.posicion).crearCeldaIgual();
		celdaDeBusqueda.desplazarVerticalmente(altura);
		celdaDeBusqueda.desplazarHorizontalmente(-base);
		
		Zona zonaDeBusqueda = new Zona(celdaDeBusqueda, 2 * base + 1, 2* altura + 1);
		
		ArrayList<Zona> zonasPosibles = mapa.buscarZonasPosibles(celdaDeBusqueda, zonaDeBusqueda, base, altura);
		
		if(zonasPosibles.isEmpty()){
			throw new NoEsPosibleConstruirException();
		}
		return zonasPosibles;
	}

	public ArrayList<Zona> posiblesZonasAConstruirPlazaCentral() {
		Mapa mapa = Mapa.obtenerInstancia();
		int base = PlazaCentral.getTamanioBase();
		int altura = PlazaCentral.getTamanioAltura();
		
		Celda celdaDeBusqueda = ((Celda)this.posicion).crearCeldaIgual();
		celdaDeBusqueda.desplazarVerticalmente(altura);
		celdaDeBusqueda.desplazarHorizontalmente(-base);
		
		Zona zonaDeBusqueda = new Zona(celdaDeBusqueda, 2 * base + 1, 2* altura + 1);
		
		ArrayList<Zona> zonasPosibles = mapa.buscarZonasPosibles(celdaDeBusqueda, zonaDeBusqueda, base, altura);
		
		if(zonasPosibles.isEmpty()){
			throw new NoEsPosibleConstruirException();
		}
		return zonasPosibles;
	}
	
	public void repararEdificio(Edificio edificio){
		edificio.reparando(true);
		this.estado.repararEdificio(edificio,this);		
	}	
	
	public void construirCuartelEnZona(Zona zona){
		boolean esPosibleConstruir = false; 
		for(Zona zonaValida : this.posiblesZonasAConstruirCuartel()){
			if(zonaValida.igualA(zona)){
				esPosibleConstruir = true;				
			}
		}
		if(!esPosibleConstruir){
			throw new NoEsPosibleConstruirException();
		}	
		this.estado.construirCuartel(zona, this);		
	}
	
	public void construirPlazaCentralEnZona(Zona zona){	
		boolean esPosibleConstruir = false; 
		for(Zona zonaValida : this.posiblesZonasAConstruirCuartel()){
			if(zonaValida.igualA(zona)){
				esPosibleConstruir = true;				
			}
		}
		if(!esPosibleConstruir){
			throw new NoEsPosibleConstruirException();
		}				
		this.estado.construirPlazaCentral(zona, this);
	}

	public void desocuparse(){
		this.actualizarEstado(new AldeanoRecolectandoOro());
	}

	public void comienzaAReparar(Edificio edificio){
		this.actualizarEstado(new AldeanoReparando(edificio));
	}

	public void comienzaAConstruirUnCuartelEnZona(Zona zona){
		this.actualizarEstado(new AldeanoConstruyendoCuartel(zona));
	}

	public void comienzaAConstruirUnaPlazaCentralEnZona(Zona zona){
		this.actualizarEstado(new AldeanoConstruyendoPlazaCentral(zona));
	}

	public boolean posicionValidaParaRepararEdificio(Edificio edificio){
		return edificio.estaAlLadoDe((Celda)this.posicion);
	}

	public boolean posicionValidaParaConstruirEdificio(Zona zona){
		return zona.estaAlLadoDe((Celda)this.posicion);
	}	

	public void realizarTareas(){
		this.estado.realizarTareas(this,this.jugador);
	}

	public boolean Libre(){
		return this.estado.aldeanoLibre();
	}
	
}
