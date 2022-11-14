package es.florida.ae1;

/**
 * @author Alvaro
 * 
 *La clase procesador procesa las conquetas pasando por argumentos su cantidad y el orden de prioridad;
 */
public class Procesadora implements Runnable {

	static int[] lista;
	static int totalCroq;
	String[] lPriod;

	/**
	 * @param croc1 croqueta del primer lugar de prioridad
	 * @param croc2 croqueta del segundo segundo de prioridad
	 * @param croc3 croqueta del tercer lugar de prioridad
	 * @param croc4 croqueta del cuartor lugar de prioridad
	 * @param prioridad
	 */
	public Procesadora(int croc1, int croc2, int croc3, int croc4, String[] prioridad) {
		super();
		Procesadora.totalCroq = croc1 + croc2 + croc3 + croc4;

		Procesadora.lista = new int[] { croc1, croc2, croc3, croc4 };
		this.lPriod = prioridad;

	}

	/**
	 * Ordenes del hilo
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		synchronized (this) {
		
			if (Procesadora.lista[0] > 0) {
				Procesadora.lista[0]--;
				Procesadora.totalCroq--;
				System.out.println(
						"Croqueta de " + lPriod[0] + " fabricada quedan :" + Procesadora.totalCroq + " en Total");
				try {
					Thread.sleep(5000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else if (Procesadora.lista[1] > 0) {
				Procesadora.lista[1]--;
				Procesadora.totalCroq--;
				System.out.println(
						"Croqueta de " + lPriod[1] + " fabricada quedan :" + Procesadora.totalCroq + " en Total");
				try {
					Thread.sleep(6000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else if (Procesadora.lista[2] > 0) {
				Procesadora.lista[2]--;
				Procesadora.totalCroq--;
				System.out.println(
						"Croqueta de " + lPriod[2] + " fabricada quedan :" + Procesadora.totalCroq + " en Total");
				try {
					Thread.sleep(7000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else if (Procesadora.lista[3] > 0) {
				Procesadora.lista[3]--;
				Procesadora.totalCroq--;
				System.out.println(
						"Croqueta de " + lPriod[3] + " fabricada quedan :" + Procesadora.totalCroq + " en Total");
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

		String[] lista = new String[] { args[4], args[5], args[6], args[7] };

		Procesadora proc = new Procesadora(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
				Integer.parseInt(args[2]), Integer.parseInt(args[3]), lista);
		Thread hilo;

		while (Procesadora.lista[0] != 0 || Procesadora.lista[1] != 0 || Procesadora.lista[2] != 0
				|| Procesadora.lista[3] != 0) {
			cont = Thread.activeCount();

			if (cont <= 100) {
				hilo = new Thread(proc);
				hilo.start();
			
				
			} else {
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Fabricacion de croquetas finalizada");
		System.out.println("0");
		fin = System.currentTimeMillis();
		System.out.println("Fabricacion finalizada tiempo tardado: " + (double) ((fin - inicio) / 1000.00) + " s");

	}

}
