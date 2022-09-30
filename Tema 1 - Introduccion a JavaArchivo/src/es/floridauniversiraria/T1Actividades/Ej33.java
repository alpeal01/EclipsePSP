package es.floridauniversiraria.T1Actividades;

/*
 * Escribe un método que sume los números pares hasta el número que acepta como
parámetro y devuelva el resultado de la suma.
 */

public class Ej33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			
			if(i % 2 == 0) {
				
				sum+= i;
			}
			
		}
		System.out.println("El resultado es: "+sum);

	}

}
