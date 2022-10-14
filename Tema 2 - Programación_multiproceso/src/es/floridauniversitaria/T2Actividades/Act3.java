package es.floridauniversitaria.T2Actividades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Act3 {

	static void execute(int num1, int num2) {

		String clase = "es.floridauniversitaria.T2Actividades.Act1";

		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			
			File dir = new File ("./salida");
			File save = new File ("./salida/Save.txt");
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(Integer.toString(num1));
			command.add(Integer.toString(num2));
			
			ProcessBuilder builder = new ProcessBuilder(command);

			
			compFichero(dir);
			
			builder.directory(dir);
			builder.redirectOutput(save).inheritIO().start();
			
			mostrFich(save);

	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static void compFichero( File dir) {
		
		if(!dir.exists()) {
			
			if(dir.mkdir()) {
				System.out.println("Directorio creado");
			}

		}else {
			System.out.println("Directorio encontrado");
		}
		
		
	}
	
	static void mostrFich(File nomArch) {
		

		
		
		
		
		String line;
		
		if(nomArch.exists()) {
			
			if(nomArch.isFile()) {
				
				try {
					FileReader fr = new FileReader(nomArch);
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
		
		
		Act3.execute(2,10);
	

	}

}
