package es.florida.t4PCR;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GestorDescargas {
	
	public void descargarArchivo(String url_descargar, String nombreArchivo) {
		System.out.println(" Descargando " + url_descargar);
		try {
			URL laUrl = new URL(url_descargar);
			InputStream is = laUrl.openStream();
			
			FileOutputStream escritorFichero = new FileOutputStream(nombreArchivo);
			
			
			BufferedImage image = ImageIO.read(is);
			
			ImageIO.write(image, "PNG", escritorFichero);
			
		
			
			
			
		} catch (MalformedURLException e) {
			System.out.println("URL mal escrita!");
		} catch (IOException e) {
			System.out.println("Fallo en la lectura del fichero");
		}
	}
	
	public static void main (String[] args){
		GestorDescargas gd=new GestorDescargas();
		String url =
		"http://localhost:80"+
		"/dashboard/capybara.jpg";
		String fichero = "capybara.jpg";
		gd.descargarArchivo(url,fichero);
		}
		
	
	
}
