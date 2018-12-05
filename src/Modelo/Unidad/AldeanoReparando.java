package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import java.util.ArrayList;

public class AldeanoReparando implements EstadoAldeano{

	private Edificio edificio ;

	public AldeanoReparando(Edificio unEdificio){
		this.edificio = unEdificio;
	}

	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano) {
		if(!aldeano.posicionValidaParaRepararEdificio(edificio)){
			throw new NoEsPosibleRepararException();
		}
		aldeano.comienzaAReparar(edificio);	
	}	
	
	@Override
	public void desocuparse(Aldeano aldeano) {		
		aldeano.desocuparse();	
	}

	@Override
	public void construirCuartel(Zona zona, Aldeano aldeano) {
		if(!aldeano.posicionValidaParaConstruirEdificio(zona)){
			throw new NoEsPosibleConstruirException();
		}
		aldeano.comienzaAConstruirUnCuartelEnZona(zona);
	}

	@Override
	public void construirPlazaCentral(Zona zona, Aldeano aldeano) {
		if(!aldeano.posicionValidaParaConstruirEdificio(zona)){
			throw new NoEsPosibleConstruirException();
		}
		aldeano.comienzaAConstruirUnaPlazaCentralEnZona(zona);
	}

	public boolean aldeanoLibre(){
		return false;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		this.edificio.aumentarVida();
		if(!this.edificio.esPosibleAumentarVida()){
			aldeano.desocuparse();
			this.edificio.reparando(false);
		}		
	}

}
