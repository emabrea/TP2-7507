public class PlazaCentral implements Construible{
    int vida = 450 ;
    int costo = 100 ;
    int turnosEnConstruirse=3;  

    public PlazaCentral(Posicion posicion){     
        vida = 450 ;
        costo = 100 ;
        turnosEnConstruirse = 3;
        velocidadDeReparacion = 25;
        posicionOrigen = posicion;
        zona= this.construir(posicion,2);        

    }   

    public void CrearUnidad(Posicion posicion) throws Exception{
        Aledano aldeano = new Aldeano() ;
        if(this.esValidoCrear(zona,posicion)){
            mapa.ocuparPosicion(posicion,aldeano);
        }
        throw new Exception("Posicion no valida para crear unidad");                   
    }

    public void Reparar() throws Exception{
        if(siendoReparado){
            throw new Exception("El edificio ya esta siendo reparado");
        }
        if(vida >= 450 ){
            throw new Exception("Salud del edificio al máximo");
            siendoReparado = false;
        }
        siendoReparado = true;
        vida += 25;
    }
}
