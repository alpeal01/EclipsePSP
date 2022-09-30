package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej38 {

	/*
	 * Escribe un método que pida por teclado 2 números como extremos de un
	 * intervalo. Luego imprime por pantalla todos los números entre ese intervalo,
	 * indicando junto al número si es un número primo o no. Al terminar de mostrar
	 * los números por pantalla, debe mostrar un mensaje indicando el tiempo
	 * consumido en la ejecución del método.
	 */
	static boolean primo(int i) {

		for (int j = 2; j < i; j++) {

			if (i % j == 0) {
				return (false);
			}

		}

		return (true);

	}

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();

		int num2 = sc.nextInt();

		for (int i = num1; i < num2; i++) {

			if (primo(i)) {

				System.out.println(i + " - Primo");

			} else {
				System.out.println(i + " - no Primo");
			}

		}

		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
	
		System.out.println("Duracion dle proceso: " + duration / 1000000 +" milliseconds");

	}

}
