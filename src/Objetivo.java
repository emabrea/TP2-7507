public class Objetivo {
	int vida ;	
	int costo ;
    Posicion Posicion ;

	public void reducirVida(int danio){
        vida -= danio;
        if(vida <1){
            this.DestruirObjeto(this);
        }
    }

    public void DestruirObjeto(Objetivo objetivo){
    	if(objetivo instanceof Edificio){
    		System.out.println("Felicidades! Ha ganado")
    	}
   		mapa.EliminarObjeto(Posicion posicion);
   		posicion = null;
        objetivo = null;
    }


}