
public class Act2 {

	public static void main(String[] args) {
		int NUM_HILOS = 5;
		Contador cont;
		int limit = 2;
		for (int i=1; i<=NUM_HILOS; i++) {
			cont = new Contador("Hilo-"+Integer.toString(i) ,1,limit);
			Thread hilo=new Thread(cont);
			limit++;
			hilo.start();
		}
		
	}
}


	



