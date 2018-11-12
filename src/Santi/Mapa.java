public abstract class Mapa {

    private static Celda[][] mapa;

    public static void inicializacionMapa(){

        int alto = 25;
        int ancho = 20;

        // ver si va new.
        mapa = Celda[ancho][alto];
        for(int i = 0; i<ancho; i++){
            for(int j =0; j < alto; j++){
                mapa[i][j] = new Celda();
            }
        }
    }


}