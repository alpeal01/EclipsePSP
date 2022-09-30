package es.floridauniversiraria.T1Actividades;

public class Ej28 {

	/*
	 * Crea un programa que permita generar 5 objetos de clase “Vehículo”. Cada
	 * vehículo tendrá tres atributos: tipo (coche, motocicleta,…), marca y modelo.
	 * Una vez creados, el programa los mostrará por pantalla.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehiculo [] list = new Vehiculo [5];
		
		Vehiculo v1 = new Vehiculo("moto","kawasaki","onda");
		
		list[0] = v1;
		
		
		v1 = new Vehiculo("vehiculo","Panda","Fiat");
		
		list[1] = v1;
		
		v1 = new Vehiculo("vehiculo","Opel","Corsa");
		
		list[2] = v1;
		
		v1 = new Vehiculo("moto","M2","BMW");
		
		list[3] = v1;
		
		v1 = new Vehiculo("Vehiculo","Stratos","Lancia");
		
		list[4] = v1;
		
		for (Vehiculo vehiculo : list) {
			
			System.out.println(vehiculo.getDatos());
			
		}
		

	}

}