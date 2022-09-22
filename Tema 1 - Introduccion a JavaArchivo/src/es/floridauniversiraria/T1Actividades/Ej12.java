package es.floridauniversiraria.T1Actividades;

import java.util.Scanner;

public class Ej12 {

	public static void main(String[] args) {
		// 2. Realiza un programa en Java que dadas 10 notas introducidas por teclado
		// (valores de 0 a
		// 10), las agrupe en suspensos, aprobados, notables, sobresalientes y
		// matrícula, y muestre
		// por pantalla cuantas notas hay en cada grupo.

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

}
