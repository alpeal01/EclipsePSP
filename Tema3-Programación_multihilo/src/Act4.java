
public class Act4 {

	public static void main(String[] args) {
		
		String [] calName = new String [] {"Antonio","Fernando","Felipe","Calico","JorseJuan"};
		Double [] vel = new Double [] {0.5,0.1,0.3,0.06,0.069};
		int [] priority = new int [] {8,3,5,7,2,10};
//		for (int i = 0; i < calName.length; i++) {
//			
//			Caracol carac = new Caracol(calName[i],vel[i]);
//			Thread hilo=new Thread(carac);
//			hilo.setPriority(priority[i]);
//			hilo.start();			
//			
//		}
		
		
		Thread hilo1=new Thread(new Caracol(calName[0],vel[0]));
		Thread hilo2=new Thread(new Caracol(calName[1],vel[1]));
		Thread hilo3=new Thread(new Caracol(calName[2],vel[2]));
		Thread hilo4=new Thread(new Caracol(calName[3],vel[3]));
		Thread hilo5=new Thread(new Caracol(calName[4],vel[4]));
		
		hilo1.setPriority(priority[0]);
		hilo2.setPriority(priority[1]);
		hilo3.setPriority(priority[2]);
		hilo4.setPriority(priority[3]);
		hilo5.setPriority(priority[4]);
		
		hilo1.start();
		hilo2.start();	
		hilo3.start();	
		hilo4.start();	
		hilo5.start();	
		

	}

}
