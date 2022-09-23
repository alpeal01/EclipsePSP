package es.floridauniversiraria.T1Actividades;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej21 {
	/*
	 * Crea un programa que almacene en una estructura el nombre de 5 personas que
	 * se irán introduciendo por teclado de uno en uno
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<String>(5);

		for (int i = 1; i <= 5; i++) {

			System.out.println("Indica " + i + "º nombre");

			list.add(sc.nextLine());

		}
		sc.close();

	}

}
