package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej14 {

	/*
	 * Desarrolla un programa que lea el valor del radio de una circunferencia y
	 * devuelva por pantalla el diámetro y el área con una precisión de 3 decimales.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		double radio = sc.nextDouble();
		
		double diametro = Math.pow(radio, 2);
		
		double area = Math.PI * diametro;
		
		sc.close();
		
		System.out.println("Diametro: "+ String.format("%.3f", diametro )+"\narea: "+ String.format("%.3f",area));
	}

}
