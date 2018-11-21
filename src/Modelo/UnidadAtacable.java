package Modelo;

public interface UnidadAtacable {
    void recibirDanio(Arquero arquero);
    void recibirDanio(Espadachin espadachin);
    void recibirDanio(Castillo castillo);
}
