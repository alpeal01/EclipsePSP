package es.floridauniversitaria.T2Actividades;

public class NEOs {
	
	
	static double calcNEOs(double posicionNEO, double velocidadNEO) {
		
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO - posicionTierra)/(posicionNEO + posicionTierra)), 2);
		
		return resultado;
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println(args[0]+":"+calcNEOs(Double.parseDouble(args[1]),Double.parseDouble(args[2])));
		
		
	}
}