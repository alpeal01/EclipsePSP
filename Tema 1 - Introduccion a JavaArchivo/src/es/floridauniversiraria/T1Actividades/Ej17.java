package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej17 {

	/*
	 * Realiza un programa que controle los requisitos de una contraseña introducida por teclado
(mínimo 5 caracteres, 1 número y 1 letra mayúscula)
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Indica Contrseña");
		
		String passwd = sc.nextLine();
		String list [] = passwd.split("");
		
		boolean mayusq = false;
		boolean numero = false;
		char let;
		
		if(passwd.length() < 5) {
			System.out.println("ERROR:La contraseña debe tener mas de 4 caracteres");
		}
		else {
			
			for (String letra : list) {
				
				let = letra.charAt(0);
				
				if(let >= 'A' && let <= 'Z') {
					mayusq = true;
				}else if (let >= '0' && let <= '9') {
					numero = true;
				}
				
				
			}
			
			if(!mayusq) {
				
				System.out.println("ERROR:La contraseña debe tener almenos una letra mayuscula");
				
			}
			
			if(!numero) {
				System.out.println("ERROR:La contraseña debe tener almenos un numero");
			}
			
			
		}
		
		
		
		

	}

}
