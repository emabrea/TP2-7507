public class Cuartel implements Construible{
    
    public Cuartel(Posicion posicion){
        vida = 250 ;
        costo = 50 ;
        turnosEnConstruirse = 3;
        velocidadDeReparacion = 50;
        posicionOrigen = posicion;
        zona= this.construir(posicion,2);
    }     

    
    public void Reparar() throws Exception{
        if(siendoReparado){
            throw new Exception("El edificio ya esta siendo reparado");
        }
        if(vida >= 250 ){
            throw new Exception("Salud del edificio al máximo");
            siendoReparado = false;
        }
        siendoReparado = true;
        vida += 50;
    }


}
