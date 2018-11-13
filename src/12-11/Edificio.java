public class Edificio extends Objetivo{      
    boolean siendoReparado = false ;   
    Zona zona; 
    Posicion posicionOrigen;    
    int velocidadDeReparacion;


    public boolean ocupa(Posicion posicion){
 	
    	zona.contiene( posicion );

    }

    public void crearUnidad(Posicion posicionInicial) throws Exception ;

    public boolean esValidoCrear(Zona zona, Posicion posicion){
    	for(Posicion posicion : zona.obtenerPosiciones()){
    		int[] distancia = posicion.distanciEntrePosiciones( posicionInicial);
    		if(distancia[0]<=1 && distancia[1]<=1)  return true;
    	}
    	return false;
    }
}
