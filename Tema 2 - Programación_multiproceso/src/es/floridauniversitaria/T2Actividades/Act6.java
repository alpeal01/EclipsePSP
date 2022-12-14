package es.floridauniversitaria.T2Actividades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Act6 {

	static void execute(int num1, int num2) {

		String clase = "es.floridauniversitaria.T2Actividades.Act1";

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

			
		
			builder.inheritIO().start();

	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		
		Act6.execute(2,10);
	

	}

}