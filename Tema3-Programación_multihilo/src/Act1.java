
public class Act1 {

	public static void main(String[] args) {


		int NUM_HILOS=2;
		MostrarASCII op;
		for (int i=0; i<NUM_HILOS; i++) {
			op = new MostrarASCII(i);
			Thread hilo=new Thread(op);
			hilo.start();
		}


	}

}
