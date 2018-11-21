package Modelo;

public interface EdificioAtacable {
    void recibirDanio(Arquero arquero);
    void recibirDanio(Espadachin espadachin);
    void recibirDanio(ArmaDeAsedio armaDeAsedio);
    void recibirDanio(Castillo castillo);
}
