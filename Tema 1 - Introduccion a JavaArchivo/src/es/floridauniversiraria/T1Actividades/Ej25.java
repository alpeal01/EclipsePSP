package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej25 {

	/*
	 * 25. Ampliar el programa anterior para que permita apostar 3 números a la vez.

	 */
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
	int[] numlist = {};
	int numRand =(int) Math.floor(Math.random()*(10-1)+1);

	for (int i = 0; i < 3; i++) {
		
		numlist[i] = sc.nextInt();
		
		System.out.println(numlist[i]+" | "+ numRand);
		
		if(numlist[i] == numRand) {
			
			System.out.println("Has acertado");
			
		}else {
			
			System.out.println("Los números no coinciden");
		}
	}
		
		
		sc.close();

	}

}
