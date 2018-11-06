public class Unidad extends Objetivo{
   
    public void Mover(Posicion posicionNueva) throws Exception{

        if(movimiento.MovimientoEsValido(posicion,posicionNueva) ){
            posicion = posicionNueva ;
        }
        else{
            throw new Exception("Movimiento invalido");
        }
    }
    



}


