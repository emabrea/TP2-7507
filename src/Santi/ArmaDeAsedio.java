public class ArmaDeAsedio extends UnidadAtacante{

    private EstadoArmaDeAsedio estado;

    public ArmaDeAsedio() {
        vida = 150;
        costo = 200;
        estado = new ArmaDeAsedioDesmontada();
    }
    @Override
    public void atacar(Atacable atacable) {
        estado.atacar(Atacable atacable);
    }
    @Override
    public void mover(Posicion posicion){
        estado.mover(Posicion posicion);
    }
    public void Montar() {
        estado = new ArmaDeAsedioMontada();
    }
    public void Desmontar(){
        estado = new ArmaDeAsedioDesmontada();
    }
}


