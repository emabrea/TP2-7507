package Modelo;

public class AldeanoReparando implements EstadoAldeano{

	private Edificio edificio;

	public AldeanoReparando(Edificio unEdificio) {
		this.edificio = unEdificio;
	}

	@Override
	public void repararEdificio(Aldeano aldeano, Edificio edificio) {

		if(edificio != this.edificio){
			throw new AldeanoEstaReparandoOtroEdificioException();
		}

		if(!edificio.esPosibleAumentarVida()){
			aldeano.desocuparse();
		}else{
			edificio.aumentarVida();
		}
	}
	
	@Override
	public int recolectarOro() {
		throw new AldeanoReparandoException();		
	}

	@Override
	public void construirCuartel(Zona zona, Aldeano aldeano, Jugador jugador) {
		throw new AldeanoReparandoException();	
	}

	@Override
	public void construirPlazaCentral(Zona zona, Aldeano aldeano, Jugador jugador) {
		throw new AldeanoReparandoException();	
	}

	@Override
	public boolean aldeanoLibre(){
		return false;
	}

	@Override
	public void realizarTareas(Aldeano aldeano,Jugador jugador){
		this.repararEdificio(aldeano,this.edificio);
	}

}
