import java.util.ArrayList;

public class Castillo implements NoConstruible{
    
    
    public Castillo(Posicion posicionOrigen){
        vida = 1000;
        velocidadDeReparacion = 15;
        this.posicionOrigen = posicionOrigen;
        zona = this.iniciarCastillo(posicionOrigen);
    }  
    

    public void CrearUnidad(Posicion posicion) throws Exception{
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio() ;
        if(this.esValidoCrear(zona,posicion)){
            mapa.ocuparPosicion(posicion,armaDeAsedio);
        }
        throw new Exception("Posicion no valida para crear unidad");                   
    }

    public void Reparar() throws Exception{        
        if(siendoReparado){
            throw new Exception("El edificio ya esta siendo reparado por otro aldeano .");
        }
        if(vida >= 1000 ){
            throw new Exception("Salud del edificio al máximo");
            siendoReparado = false;
        }
        siendoReparado = true;
        vida += 15;
    }

    public void Atacar() {        
        List<Objetivos> unidadesEnAlcance = mapa.obtenerUnidadesADistancia(posicionOrigen, 3);
        for(Objetivos objetivos : unidadesEnAlcance){
            objetivos.reducirVida(20);
        }

    }





}


