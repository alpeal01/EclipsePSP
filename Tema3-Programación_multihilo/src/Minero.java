
public class Minero implements Runnable {

	int bolsa;
	String nombre;
	long tiempoExtraccion;
	Mina mina;
	
	
	public Minero(long tiempoExtraccion, String n, Mina m) {
		super();
		this.bolsa = 0;
		this.tiempoExtraccion = tiempoExtraccion;
		this.nombre = "Minero "+ n;
		this.mina = m;
	}

	
	 public void extraerRecurso() {
		 
		try {
			synchronized(this) {
			while (mina.stock > 0) {
					
				
//					Thread.sleep(this.tiempoExtraccion);
					mina.stock =  mina.stock - 1;
					this.bolsa++;
					System.out.println("Mina: "+mina.stock +" "+ this.nombre + " bolsa: " + this.bolsa);
				
				
			}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void run() {
		
			 
				extraerRecurso();
				

		System.out.println(this.nombre+ " tiene "+this.bolsa + " de oro------------------------------");
		
		
		
	}

}
