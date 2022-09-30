package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej27 {

	/*
	 * 7. De la misma forma que en el ejercicio anterior, implementar en un método
	 * adicional el cálculo de la letra del DNI (ejercicio 11) para que sea llamado
	 * desde “main”
	 */
	
	static void genLetra () {
		
		Scanner sc = new Scanner(System.in);
		char abc[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int num = sc.nextInt();
		int resto = num % 23;
		
		char let = abc[resto];
		
		System.out.print(num);
		System.out.println(let);
		
		sc.close();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		genLetra();

	}

}
