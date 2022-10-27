
public class MostrarASCII  implements Runnable{
	


	int tipo;
	
	public MostrarASCII(int t){
		this.tipo = t;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	


	@Override
	public void run() {
		String nombre;
		

		for(int i = 32; i < 127 ;i++){
			nombre = Thread.currentThread().getName ();
			if( i % 2 == 0 && this.tipo == 2 ) {
				System.out.println(nombre);
				System.out.println( (char)i);
			}else if( i % 2 == 1 && this.tipo == 1 ) {
				
				System.out.println(nombre);
				System.out.println( (char)i);
			}
			
			
			
		}
		
	}
	
	
	
	
	

}
