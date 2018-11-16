package Modelo;

public class AldeanoReparando implements EstadoAldeano{

	private Edificio edificio;

	public AldeanoReparando(Edificio unEdificio) {
		this.edificio = unEdificio;
	}

	@Override
	public void repararEdificio(Edificio edificio, Aldeano aldeano) {

		if(edificio != this.edificio){
			throw new AldeanoEstaReparandoOtroEdificioException();
		}else{
			throw new AldeanoYaEstaReparandoEseEdificioException();
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
		if(!this.edificio.esPosibleAumentarVida()){
			aldeano.desocuparse();
		}else{
			this.edificio.aumentarVida();
		}
	}

}
