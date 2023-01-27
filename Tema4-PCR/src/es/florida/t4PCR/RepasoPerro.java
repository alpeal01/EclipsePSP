package es.florida.t4PCR;

public class RepasoPerro {
	
	String nom;
	
	int edad;
	
	String sonido;

	public RepasoPerro(String nom, int edad, String sonido) {
		super();
		this.nom = nom;
		this.edad = edad;
		this.sonido = sonido;
	}

	public String getNom() {
		return nom;
	}

	public int getEdad() {
		return edad;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

	public String getSonido() {
		return sonido;
	}
	
	
	
	
	

}
