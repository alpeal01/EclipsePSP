package es.florida.t4PCR;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
			
			System.err.println("Libro recibido: "+lib.getTitulo() +"|"+ lib.getAutor());
			
			
			lib.setTitulo("Cascara de Banan");
			
			ObjectOutputStream pMod = new ObjectOutputStream(socket.getOutputStream());
			pMod.writeObject(lib);
			System.err.println("Servidor >> Envio del Libro al cliente");
			
			pMod.close();
			socket.close();
			
			
			
			}
		}
		

		

		} 

}
