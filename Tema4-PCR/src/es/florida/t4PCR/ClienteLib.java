package es.florida.t4PCR;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteLib {
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		String host = "localhost";
		int puerto = 1234;
		System.out.println("CLIENTE >> Arranca cliente");
		Socket cliente = new Socket(host,puerto);
		Libro lib = new Libro("Las uvas de la ira", "Nelson Muntz");
		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
		pMod.writeObject(lib); 
		System.out.println("CLIENTE >>> Envio de inforacion al servidor");
		pMod.close();
		cliente.close();  
		
		
		
		
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}

}