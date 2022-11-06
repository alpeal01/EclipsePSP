package es.florida.ae1;

public class Procesadora implements Runnable {
	
	int cJamon;
	int cPollo;
	int cBacalao;
	int cQueso;
	

	

	public Procesadora(int cJamon, int cPollo, int cBacalao, int cQueso) {
		super();
		this.cJamon = cJamon;
		this.cPollo = cPollo;
		this.cBacalao = cBacalao;
		this.cQueso = cQueso;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
