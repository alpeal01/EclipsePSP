package es.floridauniversiraria.T1Actividades;
import java.util.Scanner;



public class Ej16 {

/*
 * . Escribe un programa que dada la fecha de nacimiento de una persona devuelva su número
de la suerte (utiliza el algoritmo de cálculo que prefieras)
 * */
	
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Indique fecha nacimiento en DD/MM/YY");
		String fech = sc.nextLine();
		
		String[] parts = fech.split("/");
		
		
		int numLuck =  ((420 / Integer.parseInt(parts[0]) ) +  69 / (Integer.parseInt(parts[0]) )
		+ (Integer.parseInt(parts[0] ) / 666)) % 360;
		
		
		System.out.println("Tu numero de la suerte es: "+ numLuck);
		
		
	}
}
