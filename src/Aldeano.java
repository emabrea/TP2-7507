public class Aldeano implements NoAtacante{
    int vida = 50;
    int costo= 25;
    boolean estaOcupado = false; 

    public void RecolectarOro(){
        Jugador.incrementarOro(20);
    }

    public void RepararEdificios(Edificio edificio) throws Exception{              
        edificio.Reparar();
        estaOcupado = true; 
    }

    public Estructura ConstruirEdificio(String tipoEdificio){
            estaOcupado = true; 
            Estructura edificio= new tipoEdificio;
            return edificio;
    }

    
}



