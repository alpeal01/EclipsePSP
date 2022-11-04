
public class Actv9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mina mina = new Mina();
		int numHilos = 10;
		Thread th ;
		Minero [] mn = new Minero [10];
		
		for (int i = 0; i < numHilos; i++) {
			mn[i]= new Minero(1000,Integer.toString(i),mina);
			th = new Thread(mn[i]);
			th.setName("Minero"+i);
			th.start();
			
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int total = 0;
		for (int i = 0; i < numHilos; i++) {
			total += mn[i].bolsa;
		}
		System.out.println(total);
		

	}

}
