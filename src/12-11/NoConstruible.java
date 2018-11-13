import java.util.ArrayList;

public interface NoConstruible implements Edificio {   

    public void Atacar();  

    public Zona iniciarCastillo(Posicion posicionOrigen){    	
    	List<Posicion> posiciones = new ArrayList<Posicion>();    	
    	for(int i=0 ; i < 4 ;i++ ){
    		for(int j=0 ; j < 4 ; j++){
    			posiciones.add(posicionOrigen.trasladar(i,j))
    		}
    	}
    	Zona zona = new Zona(posiciones);
    	for(Posicion posicion : posiciones){
    		mapa.ocuparPosicion(posicion);
    	}
    	return zona;
    } 


}