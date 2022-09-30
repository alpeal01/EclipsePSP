package es.floridauniversiraria.T1Actividades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ej36 {
	/*
	 * Escribe un método que pida 5 números enteros (sin validación de momento), los
	 * muestre por consola en orden inverso y devuelva la suma de todos los números
	 * proporcionados.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		 List<Integer> list = new ArrayList<>();
		 
		 int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			
			list.add((sum+=sc.nextInt()));
			
			
		}
		
		Collections.reverse(list);
		
		System.out.println(list);
		System.out.println("Suma: "+sum);
		

	}

}
