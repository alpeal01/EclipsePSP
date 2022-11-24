package es.florida.examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lanzadora {

	static boolean isMultip3(int num) {

		if (num % 3 == 0) {

			return true;

		} else {
			System.out.println("El numero indicado no es multiplo de 3");
			return false;
		}

	}

	static void execute(int proteins) {
		System.out.println("ejecuntando computador cuantico");
		String clase = "es.florida.examen.ComputadorCuantico";
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = clase;
		List<String> command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(className);
		command.add(String.valueOf(proteins));

		ProcessBuilder builder = new ProcessBuilder(command);

		File log = new File("proLog.txt");

		try {
			builder.redirectOutput(log).start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numPro;
		boolean loop = true;
		boolean readLog;
		String line;

		String op = "N";
		while (loop) {
			readLog = true;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.println("Indica numero de proteinas:");

				numPro = Integer.parseInt(sc.nextLine());

			} while (!isMultip3(numPro));

			execute(numPro);
			//Lectura del log para mostrar por pantalla su contenido
			try {
				FileReader fr = new FileReader("proLog.txt");
				BufferedReader br = new BufferedReader(fr);

				Thread.sleep(1000);

				while (readLog) {

					line = br.readLine();

					try {
						line.equals("0");
					} catch (Exception e) {
						line = "-";
					}

					if (line.equals("0")) {
						readLog = false;
					} else {
						if (!line.contains("-")) {
							System.out.println(line);
						}
					}

				}
				br.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		
			System.out.println("Quiere realizar otro porceso S/N");
			op = sc.nextLine();

			if (!op.toUpperCase().equals("S")) {
				loop = false;
			}
			
		}
		
	}

}
