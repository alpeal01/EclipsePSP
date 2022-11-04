import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Caracol implements Runnable {
	
	Double velocidad;
	
	String nombre;
	
	
	

	public Caracol( String nombre,Double velocidad) {
		super();
		this.velocidad = velocidad;
		this.nombre = nombre;
	}




	@Override
	public  void run() {
		// TODO Auto-generated method stub
		boolean carrera = true;
		try {
		FileReader fr = new FileReader("./ganador.txt");
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("./ganador.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		double prog = 0;
		
		
	 while(carrera) {
		 Thread.sleep(500);
			
			prog += this.velocidad * 100 / 1;
			
//			System.out.println(this.nombre + ": "+prog+"%");
			
			if(br.lines().count() >= 1) {
				carrera = false;
				System.out.println(this.nombre + " ha abandonado con: "+prog+"% de progreso");
				br.close();
				bw.close();
				
				
			}
			if(prog >= 100) 
			{carrera= false;
				bw.write("Ganador: "+this.nombre+"\n");
				System.out.println("Ganador: "+this.nombre);
				bw.close();
				br.close();
				
			}
			
		}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
