package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej4 {

	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		System.out.print("Indica primer numero :");
		
		int num1 = sc.nextInt();
		
		System.out.print("Indica segundo numero :");
		
		int num2 = sc.nextInt();
		
		if(num1 > num2) {
			
			System.out.println(num1 + " es mayor " + num2);
			
		}
		else if(num1 < num2) {
			
			
			System.out.println(num2 + " es mayor que " + num1);
		}
		else
			System.out.println(num1 + " y "+ num2 + " son iguales");
		sc.close();
	}
	
}
