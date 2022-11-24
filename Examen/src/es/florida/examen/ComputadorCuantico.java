package es.florida.examen;

import java.util.ArrayList;
import java.util.List;

public class ComputadorCuantico implements Runnable {

	static List<Proteina> listPro = new ArrayList<Proteina>();
	static int proHechas;
	static int id = 0;
	
	static int tercio;
	
	//devolver un nombre de porteina aleatorio
	static String selectPrtotein() {
	
		ArrayList<String> proList = new ArrayList <String> ();
		int max = -1;
		if(tercio != numOf("Alfa")){
			proList.add("Alfa");
			
		}
		if(tercio != numOf("Beta")){
			proList.add("Beta");
			max++;
		}
		if(tercio != numOf("Gamma")){
			proList.add("Gamma");
			max++;
		}
		
		
		
		
		int pos =(int) Math.round(Math.random() * max);
		
		return proList.get(pos);
		
	}
	//saca un tiempo de proceso aleatorio
	static int tiempoTardio() {
		
		int time = ((int) Math.round(Math.random() * 2)+1);
		
		return time * 10;
	}
	//devuelve el numero de proteina que hay en la lista;
	static int numOf(String name) {
		
		int num=0;
		
		for (Proteina proteina : listPro) {
			
			if(proteina.getTipo().equals(name)) {
				
				num++;
			}
			
		}
		
		return num;
		
	}

	public static void main(String[] args) {

		int numProtein;

		try {
			
			numProtein =  Integer.valueOf(args[0]);
			
		}catch(Exception e) {
			
			numProtein = 100;
			
		}
		tercio = (numProtein / 3)+1;
		
		

		System.out.println("CC: numero de proteinas recicibido :" + numProtein);
		ComputadorCuantico compCaunt = new ComputadorCuantico();
		
		
		
			for (int i = 0; i < numProtein; i++) {
			
			Thread hilo = new Thread(compCaunt);
			hilo.start();
			}
		
			while(numProtein != proHechas) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		System.out.println("Lista de proteina de :" + listPro.size());
		System.out.println("0");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			int time = tiempoTardio();
			String nomPro =  selectPrtotein();
			
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ComputadorCuantico.listPro.add( new Proteina(id,nomPro,time));
			ComputadorCuantico.proHechas++;
			ComputadorCuantico.id++;
			
			System.out.println("Proteina numero: "+ id +" de tipo "+ nomPro+ " relizado en un tiempo de "+time + " milisegundos");
			
		}
		
	}
}