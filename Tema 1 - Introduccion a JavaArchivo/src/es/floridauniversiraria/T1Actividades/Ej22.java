package es.floridauniversiraria.T1Actividades;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej22 {
/*
 * 2. Modifica el programa anterior para que almacene en una estructura el nombre de un
número cualquiera de personas, introducidos por teclado de uno en uno. La condición de
finalización es introducir un 0 por teclado
 */
	
	
	public static void main(String[] args) {
		
		boolean loop = true;
		String nom;
		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<String>(5);

		do {

			System.out.println("Indica " + "nombre");
			
			nom = sc.nextLine();
			
			if(nom == "0") {
				loop = false;
			}
			else {
				list.add(nom);
			}
			
			

		}while(loop);
		sc.close();

	}

}
