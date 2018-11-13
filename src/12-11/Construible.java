import java.util.ArrayList;

public interface Construible implements Edificio {   

    int turnosEnConstruirse;  
    
    public Zona construir(Posicion posicionOrigen,int tamanio) {
    	List<Posicion> posiciones = new ArrayList<Posicion>();    	
    	for(int i=0 ; i < tamanio ;i++ ){
    		for(int j=0 ; j < tamanio ; j++){
    			posiciones.add(posicionOrigen.trasladar(i,j))
    		}
    	}
    	Zona zona = new Zona(posiciones);
    	mapa.zonaDisponible(Zona zona);
    	for(Posicion posicion : posiciones){
    		mapa.ocuparPosicion(posicion);
    	}
    	return zona;

    }


}
