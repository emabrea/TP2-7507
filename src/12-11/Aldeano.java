public class Aldeano extends unidad{

    private EstadoAldeano estado;
    // patron state para estado del aldeano.

    public Aldeano(Posicion posicion){
        vida = 50;
        costo = 25;
        estado = new AldeanoLibre();
        this.posicion = posicion ;
    }

    public void recolectarOro(){
        estado.recolectarOro();
    }

    public void repararEdificio(Edificio edificio){
        estado.repararEdificio(Edificio edificio);
    }

    public void contruirCuartelEn(Zona zona){
        estado.contruirCuartelEn(Zona zona);
    }

    public void construirPlazaCentralEn(Zona zona){
        estado.construirPlazaCentralEn(Zona zona);
    }
}



