
public class Act5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int compis = 30;
		KFC kfc = new KFC();
		Thread hilo;
		for (int i = 0; i < compis; i++) {
			hilo = new Thread(kfc);
			
			hilo.setName("Compi " + i);
			
			hilo.start();
	
		}
	}

}
