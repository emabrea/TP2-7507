import java.util.ArrayList;

public class Castillo implements NoConstruible{
    int vida = 1000 ;    
    

    public Unidad CrearUnidad(Unidad unidad){
        Unidad armaDeAsedio = new ArmaDeAsedio() ;
        return armaDeAsedio ;
    }

    public void Reparar() throws Exception{        
        if(siendoReparado){
            throw new Exception("El edificio ya esta siendo reparado por otro aldeano .");
        }
        if(vida == 1000 ){
            throw new Exception("Salud del edificio al máximo");
            siendoReparado = false;
        }
        siendoReparado = true;
        vida += 15;
    }

    public void Atacar() {
        Object[] unidadesEnAlcance = mapa.obtenerUnidadesADistancia(posicion, 3);
        for( int i = 0; i < unidadesEnAlcance.length ; i++ ){
            unidadesEnAlcance[i].reducirVida(20);
        }

    }





}


