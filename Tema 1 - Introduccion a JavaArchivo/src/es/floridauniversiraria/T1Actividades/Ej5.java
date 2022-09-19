package es.floridauniversiraria.T1Actividades;
import java.util.Scanner;



public class Ej5 {

	//Realiza un programa que lea dos números desde teclado en un bucle repetitivo. El bucle
	//deberá finalizar cuando los números leídos sean iguales.
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1;
		int num2;
		
		do {
			
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
		}while(num1 != num2);
		
		sc.close();
		
	}
	
}
