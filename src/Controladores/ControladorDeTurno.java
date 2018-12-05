package Controladores;

import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import java.util.ArrayList;
import Vista.*;


public class ControladorDeTurno {
    
    public Jugador actual;
    public ArrayList<Jugador> jugadores;    
    private static ControladorDeTurno instancia = new ControladorDeTurno();
    private ContenedorPrincipal contenedorPrincipal;
    

    public void asignarJugadores(ArrayList<Jugador> unosJugadores){
        this.jugadores = unosJugadores;
        this.actual = unosJugadores.get(0);        
    }

    public static ControladorDeTurno getInstance(){        
        return ControladorDeTurno.instancia;
    }    

    public Jugador jugadorEnTurno(){
        return this.actual;
    }

    public Jugador jugadorFueraDeTurno(){
        for(Jugador jugador: this.jugadores){
            if(jugador != this.actual){
                return jugador;
            }
        }
        return null;
    }

    public void cambiarJugador(){
        if(this.actual == this.jugadores.get(0)){
            this.actual = this.jugadores.get(1);
        }
        else{
            this.actual= this.jugadores.get(0);
        }
        this.contenedorPrincipal.actualizar();
    }

    public void setearContenedor(ContenedorPrincipal contenedorPrincipal) {
        this.contenedorPrincipal = contenedorPrincipal;
    }
}