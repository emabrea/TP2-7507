public class ArmaDeAsedio extends UnidadAtacante{

    private EstadoArmaDeAsedio estado;

    public ArmaDeAsedio(Posicion posicion) {
        vida = 150;
        costo = 200;
        estado = new ArmaDeAsedioDesmontada();
        this.posicion = posicion;
    }
    @Override
    public void atacar(Atacable atacable) {
        estado.atacar(Atacable atacable);
    }
    @Override
    public void mover(Posicion posicion){
        estado.mover(Posicion posicion);
    }
    public void montar() {
        estado = new ArmaDeAsedioMontada();
    }
    public void desmontar(){
        estado = new ArmaDeAsedioDesmontada();
    }
}


