
public class Act7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] calName = new String [] {"Antonio","Fernando","Felipe","Calico","JorseJuan"};
		Double [] vel = new Double [] {0.02,0.01,0.03,0.06,0.069};
		
		for (int i = 0; i < calName.length; i++) {
			
			Caracol carac = new Caracol(calName[i],vel[i]);
			Thread hilo=new Thread(carac);
			hilo.start();			
			
		}
		
			
	}

}
