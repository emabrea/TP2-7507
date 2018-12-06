package Vista;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Modelo.Juego.*;
import Modelo.Excepciones.*;
import Modelo.Edificio.*;
import Modelo.Unidad.*;
import Controladores.*;

public class Menu{    

    MenuItem item1;
    MenuItem item2;
    MenuItem item3;
    MenuItem item4;
    MenuItem item5;
    MenuItem item6;
    MenuItem item7;
    MenuItem item8;
    ContextMenu contextMenu;

    public ContextMenu crearMenu(ContenedorPrincipal contenedor){

        ContextMenu contextMenu = new ContextMenu(); 
        
        MenuItem item1 = new MenuItem("Contruir cuartel (50 oro)");
        item1.setOnAction(new EventHandler<ActionEvent>() { 

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Contruye cuartel");   
            Celda celda = PosicionActual.obtenerInstancia().celda();  
            Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
            try{
                if(unidadActual instanceof Aldeano){
                    Aldeano aldeano = (Aldeano)UnidadActual.obtenerInstancia().unidad();
                    aldeano.construirCuartelEnZona(new Zona(celda,2,2));            
                }           
            }
            catch(AldeanoOcupado e){
                new Alerta().AldeanoOcupado();
            }
            catch(NoEsPosibleConstruirException e){
                new Alerta().noSePuedeConstruirAhi();
            }   
            catch(OroInsuficienteException e){
                new Alerta().oroInsuficiente();
            }                        
            contenedor.actualizar();
           }
        });   


        MenuItem item2 = new MenuItem("Contruir plaza central (100 oro)"); 

        item2.setOnAction(new EventHandler<ActionEvent>() { 

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Contruye plaza central");   
            Celda celda = PosicionActual.obtenerInstancia().celda();  
            Unidad unidadActual = UnidadActual.obtenerInstancia().unidad();
            try{
                if(unidadActual instanceof Aldeano){
                    Aldeano aldeano = (Aldeano)UnidadActual.obtenerInstancia().unidad();
                    aldeano.construirPlazaCentralEnZona(new Zona(celda,2,2));           
                }
                else{
                    throw new NoEsPosibleConstruirException();
                }
            }
            catch(AldeanoOcupado e){
                new Alerta().AldeanoOcupado();
            }
            catch(NoEsPosibleConstruirException e){
                new Alerta().noSePuedeConstruirAhi();
            }
            catch(OroInsuficienteException e){
                new Alerta().oroInsuficiente();
            }                
            contenedor.actualizar();

            }
        });   

        MenuItem item3 = new MenuItem("Reparar edificio"); 

        item3.setOnAction(new EventHandler<ActionEvent>() { 

        @Override
        public void handle(ActionEvent event) {

            System.out.println("Repara");
            try{
                Edificio edificioActual = EdificioActual.obtenerInstancia().edificio();
                if(edificioActual==null){
                    throw new NoEsPosibleRepararException();
                }
                Unidad unidadQueRepara = UnidadActual.obtenerInstancia().unidad();

                if(unidadQueRepara instanceof Aldeano){
                    Aldeano aldeano = (Aldeano)unidadQueRepara;
                    aldeano.repararEdificio(edificioActual);
                    contenedor.actualizar();
                }
                else{
                    throw new NoEsPosibleRepararException();
                }
            }catch(NoEsPosibleRepararException e){
                new Alerta().noEsPosibleReparar();
            }catch(AldeanoOcupado e){
                new Alerta().AldeanoOcupado();
            }            
        }
        }); 

        MenuItem item4 = new MenuItem("Atacar"); 

        item4.setOnAction(new EventHandler<ActionEvent>() { 

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Ataca");

            ControladorDeTurno controladorDeTurno = ControladorDeTurno.getInstance();

            Jugador jugador = controladorDeTurno.jugadorEnTurno();

            Celda posicionActual = PosicionActual.obtenerInstancia().celda();
            Unidad unidadAtacante = UnidadActual.obtenerInstancia().unidad();
            Pieza piezaAAtacar = controladorDeTurno.jugadorFueraDeTurno().obtenerPieza(posicionActual);

            try{
                if(piezaAAtacar instanceof UnidadAtacable){
            
                    UnidadAtacable unidadAAtacar = (UnidadAtacable)piezaAAtacar;        
                    if(unidadAtacante instanceof AtacanteDeUnidades){
                        ((AtacanteDeUnidades)unidadAtacante).atacar(unidadAAtacar);
                    }

                }else if(piezaAAtacar instanceof EdificioAtacable){
                    EdificioAtacable edificioAAtacar = (EdificioAtacable)piezaAAtacar;        
                    if(unidadAtacante instanceof AtacanteDeEdificios){
                        ((AtacanteDeEdificios)unidadAtacante).atacar(edificioAAtacar);
                    }
                }
            }
            catch(JuegoTerminado e){
                new Alerta().juegoTerminado();
            }  
            contenedor.actualizar();
        }
        });

        MenuItem item5 = new MenuItem("Crear aldeano (25 oro)"); 

        item5.setOnAction(new EventHandler<ActionEvent>() { 

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Crea aldeano");   
            Celda celda = PosicionActual.obtenerInstancia().celda();  
            Edificio edificioActual = EdificioActual.obtenerInstancia().edificio();
            try{
                if(edificioActual instanceof PlazaCentral){
                    PlazaCentral plaza = (PlazaCentral)EdificioActual.obtenerInstancia().edificio();
                    plaza.crearAldeano(celda);          
                }
                else{
                    throw new NoEsPosibleCrearException();
                }
            }              
            catch(NoEsPosibleCrearException e){
                new Alerta().noSePuedeCrearAhi();
            }
            catch(OroInsuficienteException e){
                new Alerta().oroInsuficiente();
            }  
            catch(PoblacionExcedidaException e){
                new Alerta().poblacionExcedida();
            }           
            contenedor.actualizar();
        }
        });   

        MenuItem item6 = new MenuItem("Crear arquero (75 oro)"); 

        item6.setOnAction(new EventHandler<ActionEvent>() { 

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Crea arquero");   
            Celda celda = PosicionActual.obtenerInstancia().celda();  
            Edificio edificioActual = EdificioActual.obtenerInstancia().edificio();
            try{
                if(edificioActual instanceof Cuartel){
                    Cuartel cuartel = (Cuartel)EdificioActual.obtenerInstancia().edificio();
                    cuartel.crearArquero(celda);            
                }
                else{
                    throw new NoEsPosibleCrearException();
                }           
            }
            catch(NoEsPosibleCrearException e){
                new Alerta().noSePuedeCrearAhi();
            }   
            catch(OroInsuficienteException e){
                new Alerta().oroInsuficiente();
            } 
            catch(PoblacionExcedidaException e){
                new Alerta().poblacionExcedida();
            }         
           
            contenedor.actualizar();
        }
        });

        MenuItem item7 = new MenuItem("Crear espadachin (50 oro)"); 

        item7.setOnAction(new EventHandler<ActionEvent>() { 
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Crea espadachin");   
            Celda celda = PosicionActual.obtenerInstancia().celda();  
            Edificio edificioActual = EdificioActual.obtenerInstancia().edificio();
            try{
                if(edificioActual instanceof Cuartel){
                    Cuartel cuartel = (Cuartel)EdificioActual.obtenerInstancia().edificio();
                    cuartel.crearEspadachin(celda);         
                }
                else{
                    throw new NoEsPosibleCrearException();   
                }            
            }           
            catch(NoEsPosibleCrearException e){
                new Alerta().noSePuedeCrearAhi();
            } 
            catch(OroInsuficienteException e){
                new Alerta().oroInsuficiente();
            } 
            catch(PoblacionExcedidaException e){
                new Alerta().poblacionExcedida();
            } 
            contenedor.actualizar();
        }
        
        });

        MenuItem item8 = new MenuItem("Crear arma de asedio (200 oro)"); 

        item8.setOnAction(new EventHandler<ActionEvent>() { 
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Crea arma de asedio");   
            Celda celda = PosicionActual.obtenerInstancia().celda();  
            Jugador jugador = ControladorDeTurno.getInstance().jugadorEnTurno();
            Castillo castillo = jugador.obtenerCastillo();
            try{
                castillo.crearArmaDeAsedio(celda);    
            }
            catch(NoEsPosibleCrearException e){
                new Alerta().noSePuedeCrearAhi();
            }
            catch(OroInsuficienteException e){
                new Alerta().oroInsuficiente();
            } 
            catch(PoblacionExcedidaException e){
                new Alerta().poblacionExcedida();
            } 
            contenedor.actualizar();
        }
        
        });



        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.item7 = item7;
        this.item8 = item8;
        this.contextMenu = contextMenu;

        return  contextMenu;                
    }

	public void crearMenuAldeano(){
        contextMenu.getItems().addAll(item1,item2,item3);       	
              
	}

    public void crearMenuAtacante(){
        contextMenu.getItems().addAll(item4);                     
    }

    public void crearMenuPlazaCentral(){
        contextMenu.getItems().addAll(item5);                     
    }

    public void crearMenuCuartel(){
        contextMenu.getItems().addAll(item6,item7);                     
    }

    public void crearMenuCastillo(){
        contextMenu.getItems().addAll(item8);                     
    }





}