package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej24 {

	public static void main(String[] args) {

		/*
		 * Escribe un programa que tome como parámetro de entrada (en la llamada al
		 * programa) un número entre 1 y 10, obtenga de forma aleatorio un número
		 * (también entre 1 y 10), compare ambos números, los muestre por pantalla y de
		 * un premio (a elegir) si coinciden
		 */

		
		Scanner sc = new Scanner(System.in);
		
		int usrNum = sc.nextInt();
		
		int numRand =(int) Math.floor(Math.random()*(10-1)+1);
		
		System.out.println(usrNum+" | "+ numRand);
		
		if(usrNum == numRand) {
			
			System.out.println("Has acertado");
			
		}else {
			
			System.out.println("Los números no coinciden");
		}
		
		
		
		sc.close();

	}
	

}
