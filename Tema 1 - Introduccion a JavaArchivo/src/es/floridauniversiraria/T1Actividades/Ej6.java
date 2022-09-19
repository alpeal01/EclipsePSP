package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej6 {
	public static void main(String[] args) {
		//Realiza un programa que lea cinco números desde teclado y muestre la suma por pantalla.
		//Sugerencia: utilizar una estructura de bucle
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			
			sum += sc.nextInt();
			
		
		}
		System.out.println("La suma es :" + sum);
		sc.close();
		
		
	}
}
