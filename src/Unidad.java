public class Unidad extends Objetivo{

	Movimiento movimiento;
   
    public void Mover(Posicion posicionNueva) throws Exception{

        if(mapa.PosicionOcupada(posicionNueva)|| !movimiento.MovimientoEsValido(posicion,posicionNueva)  ){
            throw new Exception("Movimiento invalido");
        }
        posicion = posicionNueva;      
    }
    



}


