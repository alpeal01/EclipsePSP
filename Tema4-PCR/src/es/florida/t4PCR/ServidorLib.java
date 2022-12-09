package es.florida.t4PCR;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorLib {

	public static void main(String[] arg) throws IOException, ClassNotFoundException {
		int numeroPuerto = 1234;
		try (ServerSocket servidor = new ServerSocket(numeroPuerto)) {
			
			while(true) {
			System.err.println("SERVIDOR >> Escuchando...");
			Socket socket = servidor.accept();
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
			
			System.err.println("SERVIDOR >> recive objeto");
			Libro lib = (Libro) inObjeto.readObject();
			
			System.out.println("Libro recivido: "+lib.getTitulo() +"|"+ lib.getAutor());
			inObjeto.close();
			socket.close();
			
			}
		}
		

		

		} 

}
