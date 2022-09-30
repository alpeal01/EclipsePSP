package es.floridauniversiraria.T1Actividades;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej23 {
	/*
	 * Amplía el programa anterior para que, una vez tenga almacenados los nombres
	 * en una variable, los muestre por pantalla de uno en uno de la siguiente
	 * forma: primera línea: “1. Primer nombre”, segunda línea: “2. Segundo
	 * nombre”,…
	 */

	public static void main(String[] args) {

		boolean loop = true;
		String nom;
		Scanner sc = new Scanner(System.in);
		int num = 1;

		ArrayList<String> list = new ArrayList<String>(5);
			
		

		do {

			System.out.println("Indica " + "nombre");

			nom = sc.nextLine();

			if (nom.matches("0")) {
				for (String name : list) {

					System.out.println(num + "." + name);
					num++;

				}

				loop = false;
			} else {
				list.add(nom);
			}

		} while (loop);
		sc.close();

	}

}