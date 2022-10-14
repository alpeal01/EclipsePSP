package es.floridauniversitaria.T2Actividades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Actv8 {
	
	static ArrayList<String>  loadNEOsFile() {
		
		File arch = new File("NEOs.txt");
		ArrayList<String> list = new ArrayList<String>();
		String line;
		
		try {
			FileReader fr = new FileReader(arch);
			BufferedReader bf = new BufferedReader(fr);
			
			while((line = bf.readLine()) != null) {
				
				list.add(line);
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
		
		
		
	}
	
	static void execute(int num1, int num2) {

		String clase = "es.floridauniversitaria.T2Actividades.Act1";
		
		
		File arch = new File("salida/exit.txt");
		

		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(Integer.toString(num1));
			command.add(Integer.toString(num2));
			
			ProcessBuilder builder = new ProcessBuilder(command);

			
		
			
			builder.redirectOutput(arch).start();

	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	public static void main(String[] args) {
		
		ArrayList<String> nEOsList = loadNEOsFile();
		String [] nEOs;
		
		for (String data : nEOsList) {
			
			nEOs = data.split(",");
			
			
			
		
		}
		
		
		
		

	}


}
