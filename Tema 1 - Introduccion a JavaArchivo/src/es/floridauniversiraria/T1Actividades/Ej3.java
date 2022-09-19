package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		// 3. Realiza un programa que lea dos números desde teclado y muestre la suma por pantalla.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Indica primer numero :");
		
		int num1 = sc.nextInt();
		
		System.out.print("Indica segundo numero :");
		
		int num2 = sc.nextInt();
		
		int res = num1 + num2;
		
		System.out.println("La suma es: "+ res);
		
		sc.close();
		
	}
	
}
