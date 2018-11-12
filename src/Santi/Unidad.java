public class Unidad extends Objetivo{

    private Posicion posicion;
	private Movimiento movimiento;

	public void moverA(Posicion posicion);

/* ver que es esto.
    public void Mover(Posicion posicionNueva) throws Exception{

        if(mapa.PosicionOcupada(posicionNueva)|| !movimiento.MovimientoEsValido(posicion,posicionNueva)  ){
            throw new Exception("Movimiento invalido");
        }
        posicion = posicionNueva;      
    }
*/
}


