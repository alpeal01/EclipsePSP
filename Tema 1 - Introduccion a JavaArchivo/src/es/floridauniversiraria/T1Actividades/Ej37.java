package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej37 {

	/*
	 * Escribe un método que pida por teclado el nombre y los años de experiencia
	 * como desarrollador de software y muestre el nivel y el salario en base al
	 * siguiente criterio:
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Indica nombre");
		
		String frase;
		sc.nextLine();
		
		System.out.println("Indica años como desarrollador");
		int any = sc.nextInt();
		
		if(any > 8) {
			
			frase="Analista / Arquitecto. Salario a convenir en base a ro";
			
		}else if(any >= 5) {
			
			frase ="Desarrollador Senior L2 – 28000-36000";
		}
		else if (any >= 3) {
			frase = "Desarrollador Senior L1 – 22000-28000";
		}else if (any >= 1) {
			frase = "Desarrollador Junior L2 – 18000-22000";
			
		}else {
			frase = "Desarrollador Junior L1 – 15000-18000";
		}
		
		System.out.println(frase);

	}

}
