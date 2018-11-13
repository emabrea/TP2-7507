public class Objetivo {

	private int vida;
	private int costo;	

	public void reducirVida(int danio){
        vida -= danio;

        // Ver esto.
        if(vida <1){
            this.destruirObjeto(this);
        }
    }

    // Ver.
    public void destruirObjeto(){
    	if(objetivo instanceof Edificio){
    		System.out.println("Felicidades! Ha ganado")
    	}
   		mapa.EliminarObjeto(this);
   		posicion = null;
        objetivo = null;    
    }

    public boolean ocupa(Posicion posicion);

}