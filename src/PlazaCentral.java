public class PlazaCentral implements Construible{
    int vida = 450 ;
    int costo = 100 ;
    int turnosEnConstruirse=3;    

    public Unidad CrearUnidad(){
        Unidad aldeano = new Aldeano ;
        return aldeano ;
    }    

    public void Reparar() throws Exception{
        if(siendoReparado){
            throw new Exception("El edificio ya esta siendo reparado");
        }
        if(vida == 450 ){
            throw new Exception("Salud del edificio al máximo");
            siendoReparado = false;
        }
        siendoReparado = true;
        vida += 25;
    }
}
