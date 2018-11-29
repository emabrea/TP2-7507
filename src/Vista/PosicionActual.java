package Vista;


public class PosicionActual{
	int x ;
	int y;	

	private static PosicionActual instancia = new PosicionActual();
	
	public void actualizar(int x, int y){
		this.x = x;
		this.y = y;
	}	

	public static PosicionActual obtenerInstancia(){		
		return instancia;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}
	


}