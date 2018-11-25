package EdificiosTest;

import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;
import Modelo.Juego.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CastilloAtacaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void reset(){
        Mapa.reset();
    }

    @Test
    public void test01CastilloPuedeAtacarEspadachinSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(9,4);
        Celda celdaEspadachin = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaEspadachin);

        int vidaInicial = espadachin.obtenerVida();

        castillo.atacar(espadachin); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,espadachin.obtenerVida());
    }

    @Test
    public void test02CastilloNoPuedeAtacarEspadachinSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(10,4);
        Celda celdaEspadachin = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        Espadachin espadachin = new Espadachin(celdaEspadachin, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaEspadachin);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        castillo.atacar(espadachin);
    }

    @Test
    public void test03CastilloPuedeAtacarArmaDeAsedioSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(9,4);
        Celda celdaArmaDeAsedio = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);

        int vidaInicial = armaDeAsedio.obtenerVida();

        castillo.atacar(armaDeAsedio); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,armaDeAsedio.obtenerVida());
    }

    @Test
    public void test04CastilloNoPuedeAtacarArmaDeAsedioSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(10,4);
        Celda celdaArmaDeAsedio = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(celdaArmaDeAsedio, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaArmaDeAsedio);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        castillo.atacar(armaDeAsedio);
    }

    @Test
    public void test05CastilloPuedeAtacarAldeanoSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(9,4);
        Celda celdaAldeano = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        Aldeano aldeano = new Aldeano(celdaAldeano, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaAldeano);

        int vidaInicial = aldeano.obtenerVida();

        castillo.atacar(aldeano); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,aldeano.obtenerVida());
    }

    @Test
    public void test06CastilloNoPuedeAtacarAldeanoSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(10,4);
        Celda celdaAldeano = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();
        Zona zonaCastillo = new Zona(celdaCastillo, base, altura);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        Aldeano aldeano = new Aldeano(celdaAldeano, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(celdaAldeano);

        thrown.expect(NoEsPosibleAtacarUnidadFueraDelAlcanceException.class);
        castillo.atacar(aldeano);
    }

    @Test
    public void test07CastilloPuedeAtacarCastilloSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo1 = new Celda(12,4);
        Celda celdaCastillo2 = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();

        Zona zonaCastillo1 = new Zona(celdaCastillo1, base, altura);
        Zona zonaCastillo2 = new Zona(celdaCastillo2, base, altura);

        Castillo castillo1 = new Castillo(celdaCastillo1, jugador1);
        Castillo castillo2 = new Castillo(celdaCastillo2, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo1);
        Mapa.obtenerInstancia().insertar(zonaCastillo2);

        int vidaInicial = castillo2.obtenerVida();

        castillo1.atacar(castillo2); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,castillo2.obtenerVida());
    }

    @Test
    public void test08CastilloNoPuedeAtacarCastilloSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo1 = new Celda(13,4);
        Celda celdaCastillo2 = new Celda(4,4);

        int base = Castillo.getTamanioBase();
        int altura = Castillo.getTamanioAltura();

        Zona zonaCastillo1 = new Zona(celdaCastillo1, base, altura);
        Zona zonaCastillo2 = new Zona(celdaCastillo2, base, altura);

        Castillo castillo1 = new Castillo(celdaCastillo1, jugador1);
        Castillo castillo2 = new Castillo(celdaCastillo2, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo1);
        Mapa.obtenerInstancia().insertar(zonaCastillo2);
        
        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        castillo1.atacar(castillo2);
    }

    @Test
    public void test09CastilloPuedeAtacarPlazaCentralSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(10,4);
        Celda celdaPlazaCentral = new Celda(4,4);

        int baseCastillo = Castillo.getTamanioBase();
        int alturaCastillo = Castillo.getTamanioAltura();

        int basePlazaCentral = PlazaCentral.getTamanioBase();
        int alturaPlazaCentral = PlazaCentral.getTamanioAltura();


        Zona zonaCastillo = new Zona(celdaCastillo, baseCastillo, alturaCastillo);
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, basePlazaCentral, alturaPlazaCentral);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        int vidaInicial = plazaCentral.obtenerVida();

        castillo.atacar(plazaCentral); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,plazaCentral.obtenerVida());
    }

    @Test
    public void test10CastilloNoPuedeAtacarPlazaCentralSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(11,4);
        Celda celdaPlazaCentral = new Celda(4,4);

        int baseCastillo = Castillo.getTamanioBase();
        int alturaCastillo = Castillo.getTamanioAltura();

        int basePlazaCentral = PlazaCentral.getTamanioBase();
        int alturaPlazaCentral = PlazaCentral.getTamanioAltura();


        Zona zonaCastillo = new Zona(celdaCastillo, baseCastillo, alturaCastillo);
        Zona zonaPlazaCentral = new Zona(celdaPlazaCentral, basePlazaCentral, alturaPlazaCentral);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        PlazaCentral plazaCentral = new PlazaCentral(celdaPlazaCentral, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(zonaPlazaCentral);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        castillo.atacar(plazaCentral);
    }

    @Test
    public void test11CastilloPuedeAtacarCuartelSiEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(10,4);
        Celda celdaCuartel = new Celda(4,4);

        int baseCastillo = Castillo.getTamanioBase();
        int alturaCastillo = Castillo.getTamanioAltura();

        int baseCuartel = Cuartel.getTamanioBase();
        int alturaCuartel = Cuartel.getTamanioAltura();


        Zona zonaCastillo = new Zona(celdaCastillo, baseCastillo, alturaCastillo);
        Zona zonaCuartel = new Zona(celdaCuartel, baseCuartel, alturaCuartel);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        int vidaInicial = cuartel.obtenerVida();

        castillo.atacar(cuartel); // Castillo saca 20 a unidades y edificios.

        Assert.assertEquals(vidaInicial-20,cuartel.obtenerVida());
    }

    @Test
    public void test12CastilloNoPuedeAtacarCuartelSiNoEstaEnSuAlcance(){
        Jugador jugador1 = new Jugador(100);
        Jugador jugador2 = new Jugador(100);

        Celda celdaCastillo = new Celda(11,4);
        Celda celdaCuartel = new Celda(4,4);

        int baseCastillo = Castillo.getTamanioBase();
        int alturaCastillo = Castillo.getTamanioAltura();

        int baseCuartel = Cuartel.getTamanioBase();
        int alturaCuartel = Cuartel.getTamanioAltura();


        Zona zonaCastillo = new Zona(celdaCastillo, baseCastillo, alturaCastillo);
        Zona zonaCuartel = new Zona(celdaCuartel, baseCuartel, alturaCuartel);

        Castillo castillo = new Castillo(celdaCastillo, jugador1);
        Cuartel cuartel = new Cuartel(celdaCuartel, jugador2);

        Mapa.obtenerInstancia().insertar(zonaCastillo);
        Mapa.obtenerInstancia().insertar(zonaCuartel);

        thrown.expect(NoEsPosibleAtacarEdificioFueraDelAlcanceException.class);
        castillo.atacar(cuartel);
    }

}
