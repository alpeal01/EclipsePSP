package es.florida.t4PCR;
import java.io.Serializable;
@SuppressWarnings ("serial")
public class Libro implements Serializable  {
	String titulo;
	String autor;
	
	public Libro (String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}
}
