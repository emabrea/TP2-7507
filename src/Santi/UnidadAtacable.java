public interface UnidadAtacable extends Atacable {

    void recibirDanio(Arquero arquero);
    void recibirDanio(Espadachin espadachin);
    void recibirDanio(Castillo castillo);
}
