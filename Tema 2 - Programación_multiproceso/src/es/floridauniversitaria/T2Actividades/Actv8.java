package es.floridauniversitaria.T2Actividades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Actv8 {

	static ArrayList<String> loadNEOsFile() {

		File arch = new File("NEOs.txt");
		ArrayList<String> list = new ArrayList<String>();
		String line;

		try {
			FileReader fr = new FileReader(arch);
			BufferedReader bf = new BufferedReader(fr);

			while ((line = bf.readLine()) != null) {

				list.add(line);

			}

			bf.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	static void execute(String name, String num1, String num2) {

		String clase = "es.floridauniversitaria.T2Actividades.NEOs";

		File arch = new File("salida/NEOsResult.txt");

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
			command.add(name);
			command.add(num1);
			command.add(num2);

			ProcessBuilder builder = new ProcessBuilder(command);

			builder.redirectOutput(Redirect.appendTo(arch)).start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static public ArrayList<String> compNEOs() {

		File arch = new File("./salida/NEOsResult.txt");
		ArrayList<String> list = new ArrayList<String>();
		String line;

		try {
			FileReader fr = new FileReader(arch);
			BufferedReader bf = new BufferedReader(fr);

			while ((line = bf.readLine()) != null) {

				list.add(line);

			}

			bf.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		ArrayList<String> nEOsList = loadNEOsFile();
		String[] nEOs;
		double prob;
		int lines;
		DecimalFormat formatea = new DecimalFormat("#.##");
		for (String data : nEOsList) {

			nEOs = data.split(",");
			execute(nEOs[0], nEOs[1], nEOs[2]);

		}
		lines = nEOsList.size();
		nEOs = null;
		nEOsList = null;

		do {
			nEOsList = compNEOs();
		} while (nEOsList.size() < lines);

		for (String data : nEOsList) {

			nEOs = data.split(":");
			prob = Double.parseDouble(nEOs[1]);

			if (prob > 10) {
				System.err
						.println(nEOs[0] + ": Peligro!!! Probabilidad de impacto del " + (formatea.format(prob) + "%"));

			} else {
				System.out.println(nEOs[0] + ": Baja probabilidad de impacto: " + formatea.format(prob)
						+ "%. El mundo vive otro día...");

			}

		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Duration: " + duration / 1000000000.000 + " s");

	}

}
