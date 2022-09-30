package es.floridauniversiraria.T1Actividades;

import java.util.Iterator;

public class ej35 {

	/*
	 * Escribe un método que acepte un array o una lista de elementos y devuelva el
	 * mayor de ellos.
	 */
	
	static int mayNum (int [] list) {
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < list.length; i++) {
			
			if(list[i] > max) max = list[i];
		}
		
		return max;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] list = new int [] {1,3,4,51,2,5352,6,999,28};
		
		System.out.println(mayNum(list));

	}

}
