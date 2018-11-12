public class Aldeano implements NoAtacante{
    int vida = 50;
    int costo= 25;
    boolean estaOcupado = false; 

    Aldeano(Posicion posicionIndicada){
        mapa.OcuparPosicion(posicionIndicada , this);
        posicion = posicionIndicada;        
    }

    public void RecolectarOro(){
        Jugador.incrementarOro(20);
    }

    public void RepararEdificios(Edificio edificio){              
        edificio.Reparar();
        estaOcupado = true; 
    }

    public Edificio ConstruirEdificio(Edificio tipoEdificio){
            estaOcupado = true; 
            Edificio edificio= new tipoEdificio;
            return edificio;
    }

    public boolean AldeanoOcupado(){
        return estaOcupado;
    }
    
}



