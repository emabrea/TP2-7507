public class Espadachin implements Atacante{
    int vida = 50 ;
    int costo = 50 ;


    public static void Atacar(objetivo) throws Exception{        
        int[] distancia = posicion.DistanciaEntreUnidades(objetivo.ObtenerPosicion());
        if( distancia[0]> 1 || distancia[1] > 1 ){
            throw new Exception("El objetivo esta a distancia mayor a 1.");
        }
        if (objetivo instanceof Edificio) {
            daño = 15 ;
        }
        else{
            daño = 25 ;
        }
        objetivo.reducirVida(daño) ;
    }
    

}


