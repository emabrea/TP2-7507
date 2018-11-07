public class Arquero implements Atacante{
    int vida = 75 ;
    int costo = 75 ;

    public void Atacar(Object objetivo) throws Exception{
        int[] distancia = posicion.DistanciaEntreUnidades(objetivo.ObtenerPosicion());
        if( distancia[0]> 3 || distancia[1] > 3 ){
            throw new Exception("El objetivo esta a distancia mayor a 3.");
        }
        if (objetivo instanceof Edificio) {
            daño=10;
        }
        else{
            daño=15;
        }
        objetivo.reducirVida(daño);
    }    

}
