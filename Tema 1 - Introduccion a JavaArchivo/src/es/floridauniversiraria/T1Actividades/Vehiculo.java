package es.floridauniversiraria.T1Actividades;

public class Vehiculo {

	String tipo;
	String marca;
	String modelo;

	public Vehiculo(String tip, String marc, String model) {

		this.tipo = tip;
		this.marca = marc;
		this.modelo = model;

	}
	
	public String getDatos() {
		
		
		return(this.tipo+": "+this.marca+" | "+this.modelo);
		
	} 

}
