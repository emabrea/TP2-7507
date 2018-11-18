package Modelo;


import java.util.ArrayList;

public class AldeanoReparando implements EstadoAldeano{

	private Edificio edificio ;

	public AldeanoReparando(Edificio unEdificio){
		this.edificio = unEdificio;
	}

	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano) {
		//repararlo
	}	
	
	@Override
	public int recolectarOro() {
		//recolectar
		return 0;	
	}

	@Override
	public void construirCuartel(Zona zona, Aldeano aldeano, Jugador jugador) {
		//construir
	}

	@Override
	public void construirPlazaCentral(Zona zona, Aldeano aldeano, Jugador jugador) {
		//construir
	}

	public boolean aldeanoLibre(){
		return false;
	}

	public void realizarTareas(Aldeano aldeano,Jugador jugador){//implementar
		if(!this.edificio.esPosibleAumentarVida()){
			aldeano.desocuparse();
		}
		else{
			this.edificio.aumentarVida();
		}
	}

}
