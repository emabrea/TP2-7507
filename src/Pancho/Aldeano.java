package Modelo;

public class Aldeano implements Unidad{
	
	Edificio ocupadoCon;
	
	public Aldeano(){
		
		ocupadoCon = null;
	}

	public boolean estaOcupado() {
		return (ocupadoCon != null);
	}
	
	public void construirPlazaCentral() {
		
		if(this.estaOcupado()){
			throw new AldeanoEstaOcupadoException();
		}
		ocupadoCon = new PlazaCentral();
	}

	public void construirCuartel() {
		if(this.estaOcupado()){
			throw new AldeanoEstaOcupadoException();
		}
		ocupadoCon = new Cuartel();
		
	}

}
