package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej18 {

	/*
	 * Amplía el programa anterior haciendo que el usuario repita la contraseña y comprobando
que lo ha hecho correctamente
*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		boolean mayusq = false;
		boolean numero = false;
		boolean correct = false;
		char let;
		
		do {
		
		System.out.println("Indica Contrseña");
		String passwd = sc.nextLine();
		String list[] = passwd.split("");
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
			
			if(mayusq && numero ) {
				correct = true;
			}
			
			
		}
		}while(!correct);
		
		System.out.println("Contraseña correcta");
		
		sc.close();
		
		

	}

}
