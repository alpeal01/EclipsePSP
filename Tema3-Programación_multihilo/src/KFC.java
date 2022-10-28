
public class  KFC implements Runnable {
	int alitas = 100;
	static int alitasConsumidas = 0;
	
	

	public static int getAlitasConsumidas() {
		return alitasConsumidas;
	}



	synchronized void consumirAlita (String nombre,int alitPedidas) {
	
		if(alitPedidas <= this.alitas) {
		
			this.alitas -= alitPedidas;
			KFC.alitasConsumidas += alitPedidas;
			System.out.println(nombre + " ha consumido " + alitPedidas+" alitas"+ "Quedan: "+ this.alitas);
			
		}else {System.out.println("No quedan alitas D:");}
		
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int alitPedidas = (int) (Math.random() *10+1);
		String nombre = Thread.currentThread().getName ();
		consumirAlita(nombre,alitPedidas);
		
	}

	
	
	
}
