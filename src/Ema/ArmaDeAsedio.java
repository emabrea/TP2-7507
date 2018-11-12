public class ArmaDeAsedio implements Atacante{
    int vida = 150 ;
    int costo = 200 ;
    boolean montado = false;   


    public void Atacar(Object objetivo) throws Exception{
        if(DistanciaEntreUnidades(this,objetivo) > 5 ){
            throw new Exception("El objetivo esta a distancia mayor a 5.");
        }
        if(!montado){
            throw new Exception("Esta unidad tiene que estar montada para atacar.");
        }

        if (objetivo instanceof Unidad) {
            throw new Exception("Esta unidad solo ataca edificios.");
        }
        daño=75;
        objetivo.reducirVida(daño);
    }

    public void Montar() throws Exception{
        if(montado){
            throw new Exception("El arma de asedio ya esta montada.");
        }
        montado = true;
    }

    public void Mover(Posicion posicionNueva) throws Exception{
        if(montado){
            throw new Exception("El arma de asedio no se puede mover pues esta montada.");
        }

        if(movimiento.MovimientoEsValido(posicion,posicionNueva) ){
            posicion = posicionNueva ;
        }
        else{
            throw new Exception("Movimiento invalido");
        }
    }


}


