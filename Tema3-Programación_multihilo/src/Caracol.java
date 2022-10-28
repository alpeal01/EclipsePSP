
public class Caracol implements Runnable {
	
	Double velocidad;
	
	String nombre;
	
	
	

	public Caracol( String nombre,Double velocidad) {
		super();
		this.velocidad = velocidad;
		this.nombre = nombre;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		double prog = 0;
		
		while(prog < 100) {
			
			prog += this.velocidad * 100 / 1;
			
			//System.out.println(this.nombre + ": "+prog+"%");
			
		}
		System.out.println(this.nombre+" recorrido finalizado");
		
		
		
	}
	
	

}
