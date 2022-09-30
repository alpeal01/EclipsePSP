package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej26 {

	/*
	 * Realiza una modificación sobre el programa de las notas (ejercicio 12)
	 * implemente la funcionalidad de determinar la calificación (suspenso,
	 * aprobado,…) en un método aparte (fuera del método “main”).
	 */
	
	static void calificaciones() {
		Scanner sc = new Scanner(System.in);

		int susp = 0;
		int aprob = 0;
		int notab = 0;
		int sobre = 0;
		int matr = 0;

		int nota;

		for (int i = 0; i < 10; i++) {

			System.out.println("Indique " + i + "º nota");
			nota = sc.nextInt();
			
			if(nota >= 10) {
				matr++;
			}else if(nota > 8) {
				sobre++;
			}else if(nota > 6)
				notab++;
			else if(nota > 4) {
				aprob++;
			}else {
				susp++;
			}
				
			

		}
		sc.close();
		System.out.println("Notas:\n" + "Suspensos: " + susp + "\nAprobados: " + aprob + "\nNotables: " + notab
				+ "\nSobresalientes: " + sobre + "\nMatricula: " + matr);

	}

		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		calificaciones();
		
		
	}

}

