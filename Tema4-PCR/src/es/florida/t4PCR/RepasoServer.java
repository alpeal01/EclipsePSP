package es.florida.t4PCR;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RepasoServer {

	public static void main(String[] args)throws IOException, ClassNotFoundException {
		int numeroPuerto = 5000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		
		System.err.println("SERVIDOR >> Escuchando...");
		
		Socket cliente = servidor.accept();
		
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		
		RepasoPerro p = new RepasoPerro("Nombre",2,"Goof");
		outObjeto.writeObject(p);
		
		System.err.println("SERVIDOR >> Envio a cliente: " + p.getNom() + " - " + p.getEdad());
		
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		
		RepasoPerro pMod = (RepasoPerro) inObjeto.readObject();
		
		System.err.println("SERVIDOR >> Recibo de cliente: " + pMod.getNom()+ " - " +pMod.getEdad());
		
		outObjeto.close();
		inObjeto.close ();
		cliente.close ();
		servidor.close(); 

	}

}
