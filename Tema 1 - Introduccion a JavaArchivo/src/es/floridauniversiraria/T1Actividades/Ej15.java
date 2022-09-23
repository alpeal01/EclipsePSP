package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej15 {

	/*
	 * Amplia el programa anterior para que devuelve el volumen de una esfera
	 * definida por el mismo radio.
	 * 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double radio = sc.nextDouble();

		double diametro = Math.pow(radio, 2);

		double area = Math.PI * diametro;
		
		double volEsfera = 4 / 3 * Math.PI * Math.pow(radio, 3);

		sc.close();

		System.out.println("Diametro: " + String.format("%.3f", diametro) + "\nArea: " + String.format("%.3f", area)+
				"\nVolumen de la esfera: "+String.format("%.3f", volEsfera));
	}

}
