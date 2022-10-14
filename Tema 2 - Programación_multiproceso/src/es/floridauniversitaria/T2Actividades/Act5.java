package es.floridauniversitaria.T2Actividades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Act5 {
	static void execute(int num1, int num2, String arch) {

		String clase = "es.floridauniversitaria.T2Actividades.Act1";

		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			
			File dir = new File ("C:/Users/alvar/Desktop/salida");
			File save = new File (arch);
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(Integer.toString(num1));
			command.add(Integer.toString(num2));
			
			ProcessBuilder builder = new ProcessBuilder(command);

			builder.directory(dir);
			builder.redirectOutput(save).start();
			
			mostrFich(save);

	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
		
	
	static void mostrFich(File dir) {
		
		String line;
		
		if(dir.exists()) {
			
			if(dir.isFile()) {
				
				try {
					FileReader fr = new FileReader(dir);
					BufferedReader  buffRead = new BufferedReader (fr);
					
					while((line = buffRead.readLine()) != null) {
						
						System.out.println(line);
						
					}
					buffRead.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else System.out.println("La ruta no es un archivo");
			
			
		} else System.out.println("Ruta no encontrada");
		
	}
	
	

	public static void main(String[] args) {
		
		
		Act5.execute(2,10,"Sal1.txt");
		Act5.execute(12,20,"Sal2.txt");
		
	

	}
}
