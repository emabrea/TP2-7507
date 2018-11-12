public class Objetivo {

	private int vida;
	private int costo;
	private int velocidadDeReparacion;

	public void reducirVida(int danio){
        vida -= danio;

        // Ver esto.
        if(vida <1){
            this.DestruirObjeto(this);
        }
    }

    // Ver.
    public void DestruirObjeto(Objetivo objetivo){
    	if(objetivo instanceof Edificio){
    		System.out.println("Felicidades! Ha ganado")
    	}
   		mapa.EliminarObjeto(Posicion posicion);
   		posicion = null;
        objetivo = null;
    }


}