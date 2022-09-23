package es.floridauniversiraria.T1Actividades;

import java.util.Locale;
import java.util.Scanner;

public class Ej13 {

	public static void main(String[] args) {
		/*
		 * Programa que lea un valor de grados centígrados desde teclado y lo muestre en grados
Fahrenheit con una precisión de 1 decimal.
		 */

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		
		float gradosC = sc.nextFloat();
		
		sc.close();
		
		
		
		
		float gradosF = (gradosC  * 9 / 5) + 32;
		
		System.out.println(String.format("%.1f", gradosF ));

		
		
		
	}

}
