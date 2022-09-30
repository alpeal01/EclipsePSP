package es.floridauniversiraria.T1Actividades;

import java.util.ArrayList;

public class Ej32 {
	/*
	 * Crea un array de elementos que contenga el nombre de 6 compañeros de clase y
	 * haz que se escriban por la consola en líneas consecutivas. Ahora haz lo
	 * mismo, pero empleando un objeto de tipo lista.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] listStr = new String[] { "Alvaro", "Antonio", "Marcos" };

		for (int i = 0; i < listStr.length; i++) {
			System.out.println(listStr[i]);
		}
		
		System.out.println("----------------------");
		
		ArrayList <String> arrList = new ArrayList <String>();
		
		arrList.add("Alvaro");
		arrList.add("Antonio");
		arrList.add("Marcos");
		
		for (String string : arrList) {
			
			System.out.println(string);
		}
		

	}

}
