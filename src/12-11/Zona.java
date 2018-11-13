import java.util.List;

public class Zona {

    private List<Posicion> posiciones;

    public Zona(List<Posicion> unaListaDePosiciones){
        posiciones = unaListaDePosiciones;
    }
    
    public List<Posicion> obtenerPosiciones(){
        return posiciones;
    }

	public boolean contiene(Posicion otraPosicion){

		for(Posicion posicion : posiciones){

			if(posicion.equals(otraPosicion)) return true;
		}

		return false;
	}   

}