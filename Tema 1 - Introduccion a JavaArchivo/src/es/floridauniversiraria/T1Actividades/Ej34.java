package es.floridauniversiraria.T1Actividades;

public class Ej34 {

	/*
	 * Escribe el código necesario para calcular el factorial del número 15, en
	 * menos de 5 instrucciones.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero = 15;
		int factorial = 1;

		while (numero != 0) {
			factorial = factorial * numero;
			numero--;
		}

		System.out.println(factorial);
	}

}
