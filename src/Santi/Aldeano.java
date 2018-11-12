public class Aldeano extends unidad{

    private EstadoAldeano estado;
    // patron state para estado del aldeano.

    public Aldeano(){
        vida = 50;
        costo = 25;
        estado = new AldeanoLibre();
    }

    public void recolectarOro(){
        estado.recolectarOro();
    }

    public void RepararEdificio(Edificio edificio){
        estado.RepararEdificio(Edificio edificio);
    }

    public void contruirCuartelEn(Zona zona){
        estado.contruirCuartelEn(Zona zona);
    }

    public void construirPlazaCentralEn(Zona zona){
        estado.construirPlazaCentralEn(Zona zona);
    }
}



