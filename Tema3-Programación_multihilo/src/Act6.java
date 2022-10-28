
public class Act6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ControlSemaforos cs = new ControlSemaforos("verde");
		
		Thread hil1 = new Thread (new Runnable() {

			@Override
			public void run() {
				cs.encenderSemaforo1();
				// TODO Auto-generated method stub
			}
			
		});
		Thread hil2 = new Thread (new Runnable() {

			@Override
			public void run() {
				cs.encenderSemaforo2();
				// TODO Auto-generated method stub
				
			}
			
		});
		
		hil1.start();
		hil2.start();
		
		try {
			hil1.join();
			hil2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

	
		
		
		

	}

}
