public class Arquero implements Atacante{
    int vida = 75 ;
    int costo = 75 ;

    public void Atacar(Object objetivo) throws Exception{
        if(DistanciaEntreUnidades(this,objetivo) > 3 ){
            throw new Exception("El objetivo esta a distancia mayor a 3.");
        }
        if (objetivo instanceof Estructura) {
            daño=10;
        }
        else{
            daño=15;
        }
        objetivo.reducirVida(daño);
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
