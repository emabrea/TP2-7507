public class PlazaCentral implements Construible{

    private int turnos;

    public PlazaCentral(){
        vida = 450;
        costo = 100;
        turnos = 3;
    }

    // Creo que en realidad no deberia devolver nada esto.
    // Seria mas bien crear un aldeano y ponerlo en el mapa.

    public Aldeano CrearAldeano(){
        Aldeano aldeano = new Aldeano();
        return aldeano ;
    }    

    // Quizas conviene usar patron state para que quede mas lindo.

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
