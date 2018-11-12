public abstract class UnidadAtacante extends Unidad implements UnidadAtacable{

    private int alcance;

    public void atacar(Atacable atacable){
        atacable.recibirDanio(this);
    }

    public void recibirDanio(Arquero arquero){
        vida -= 15;
    }
    public void recibirDanio(Espadachin espadachin){
        vida -= 25;
    }

    public void recibirDanio(Castillo castillo){
        vida -= 20;
    }

}