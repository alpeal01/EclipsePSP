package es.florida.ae1;

public class Procesadora implements Runnable {

	static int[] lista;
	static int totalCroq;
	

	public Procesadora(int cJamon, int cPollo, int cBacalao, int cQueso) {
		super();
		Procesadora.totalCroq = cJamon+cPollo+cBacalao+cQueso;
		
		Procesadora.lista = new int[] { cJamon, cPollo, cBacalao, cQueso };
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		synchronized (this) {
			// Jamon
			if (Procesadora.lista[0] > 0) {
				Procesadora.lista[0]--;
				Procesadora.totalCroq--;
				System.out.println("Croqueta de jamon fabricada quedan :" + Procesadora.totalCroq);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			// Pollo
			else if (Procesadora.lista[1] > 0) {
				Procesadora.lista[1]--;
				Procesadora.totalCroq--;
				System.out.println("Croqueta de pollo fabricada quedan :" + Procesadora.totalCroq);
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			// bacalao
			else if (Procesadora.lista[2] > 0) {
				Procesadora.lista[2]--;
				Procesadora.totalCroq--;
				System.out.println("Croqueta de bacalao fabricada quedan :" + Procesadora.totalCroq);
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			// queso
			else if (Procesadora.lista[3] > 0) {
				Procesadora.lista[3]--;
				Procesadora.totalCroq--;
				System.out.println("Croqueta de queso fabricada quedan :" + Procesadora.totalCroq);
				try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Iniciando procesadora");
		
		long inicio = System.currentTimeMillis();
		long fin;

		int cont = Thread.activeCount();
	
		
		Procesadora proc = new Procesadora(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
				Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		Thread hilo;

		while (Procesadora.lista[0] != 0 || Procesadora.lista[1] != 0 || Procesadora.lista[2] != 0
				|| Procesadora.lista[3] != 0) {
			cont = Thread.activeCount();
			
			if (cont <= 100) {
				hilo = new Thread(proc);
				hilo.start();
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fabricacion de croquetas finalizada");
		System.out.println("0");
		fin = System.currentTimeMillis();
		System.out.println("Fabricacion finalizada tiempo tardado: " + (double) ((fin - inicio) / 1000) + " s");

	}

}
