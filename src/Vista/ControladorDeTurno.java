package Vista;

import Modelo.Unidad.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import java.util.ArrayList;


public class ControladorDeTurno {
    
    public Jugador actual;    
    public ArrayList<Jugador> jugadores;
    private static ControladorDeTurno instancia = new ControladorDeTurno();

    public void asignarJugadores(ArrayList<Jugador> unosJugadores){
        this.jugadores = unosJugadores;
        this.actual = unosJugadores.get(0);        
    }

    public static ControladorDeTurno getInstance(){        
        return ControladorDeTurno.instancia;
    }    

    public Jugador jugador(){
        return this.actual;
    } 
    
   

}