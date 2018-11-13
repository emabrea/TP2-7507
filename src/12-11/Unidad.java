public interface Unidad implements Objetivo{

	Movimiento movimiento;

    public void Mover(Posicion posicionNueva) throws Exception{

        if(mapa.posicionOcupada(posicionNueva) || !movimiento.movimientoEsValido(posicion,posicionNueva)  ){
            throw new Exception("Movimiento invalido");
        }
        this.posicion = posicionNueva;      
    }
    
    public boolean ocupa(Posicion otraPosicion){

    	return posicion.equals(otraPosicion);
    }


}