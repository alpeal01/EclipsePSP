

public class Contador implements Runnable {
	
	String nombreHilo;
	
	int inicioContador;
	
	int limiteContador;
	

	

	public Contador( String name ,int inicioContador, int limiteContador) {
		
		this.nombreHilo = name ;
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
	}




	public String getNombreHilo() {
		return nombreHilo;
	}


	public int getInicioContador() {
		return inicioContador;
	}



	public int getLimiteContador() {
		return limiteContador;
	}




	public void setLimiteContador(int limiteContador) {
		this.limiteContador = limiteContador;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = this.inicioContador; i <= this.limiteContador; i++) {
			
			System.out.println( this.nombreHilo +": "+i);
			
		}
		
	}


}
