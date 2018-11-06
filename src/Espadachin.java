public class Espadachin implements Atacante{
    int vida = 50 ;
    int costo = 50 ;


    public static void Atacar(objetivo) throws Exception{
        if(DistanciaEntreUnidades(this,objetivo) > 1 ){
            throw new Exception("El objetivo esta a distancia mayor a 1.") ;
        }
        if (objetivo instanceof Estructura) {
            daño = 15 ;
        }
        else{
            daño = 25 ;
        }
        objetivo.reducirVida(daño) ;
    }

    public void Mover(Posicion posicionNueva) throws Exception{

        if(posicionNuevaEsValida(posicion,posicionNueva) ){
            posicion = posicionNueva ;
        }
        else{
            throw new Exception("Movimiento invalido");
        }
    }

}


