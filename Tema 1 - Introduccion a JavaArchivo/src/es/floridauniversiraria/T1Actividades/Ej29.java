package es.floridauniversiraria.T1Actividades;

import java.util.ArrayList;

public class Ej29 {

	/*
	 * Modifica el programa anterior para que el programa admita una lista de
	 * longitud indeterminada de vehículos.
	 */
	public static void main(String[] args) {

		ArrayList<Vehiculo> list = new ArrayList<Vehiculo>();

		Vehiculo v1 = new Vehiculo("moto", "kawasaki", "onda");

		list.add(v1);

		v1 = new Vehiculo("vehiculo", "Panda", "Fiat");

		list.add(v1);
		list.add(v1);

		v1 = new Vehiculo("vehiculo", "Opel", "Corsa");

		list.add(v1);
		list.add(v1);

		v1 = new Vehiculo("moto", "M2", "BMW");

		list.add(v1);

		v1 = new Vehiculo("Vehiculo", "Stratos", "Lancia");

		list.add(v1);

		for (Vehiculo vehiculo : list) {

			System.out.println(vehiculo.getDatos());

		}

	}

}
