package es.floridauniversitaria.T2Actividades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Act2 {

	static void execute(String dir) {
		
			
					File direct = new File(dir);
			
					String clase = "es.floridauniversitaria.T2Actividades";
					String javaHome = System.getProperty("java.home");
					String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
					String classpath = System.getProperty("java.class.path");
					String className = clase;
					List<String> command = new ArrayList<>();
					command.add(javaBin);
					command.add("-cp");
					command.add(classpath);
					command.add(className);

					ProcessBuilder builder = new ProcessBuilder(command);
					builder.directory(direct);

					try {
						Process p = builder.start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

	public static void main(String[] args) {

		//Act2.execute("./src/es/floridauniversitaria/T2Actividades/Act1.java");
		
		Act2.execute("./Act1.java");

		System.out.println("Exit");

	}

}
