
public class ControlSemaforos {

	String semaforo;

	public ControlSemaforos(String semaforo) {
		super();
		this.semaforo = semaforo;
	}

	public void encenderSemaforo1() {

		while (true) {
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (this) {
				
				if (this.semaforo.equals("verde")) {

					this.semaforo = "rojo";
				} else
					this.semaforo = "verde";

				notify();

					System.out.println("Semaforo1: "+this.semaforo);
					
					try {
						wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		}
	}

	public void encenderSemaforo2() {
		while (true) {
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (this) {
				
				if (this.semaforo.equals("verde")) {

					this.semaforo = "rojo";
				} else
					this.semaforo = "verde";

				notify();

					System.out.println("Semaforo2: "+this.semaforo);
					
					try {
						wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		}

	}

}
