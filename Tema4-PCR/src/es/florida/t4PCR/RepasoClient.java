package es.florida.t4PCR;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class RepasoClient {

	public static void main(String[] args)throws UnknownHostException, IOException,ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		int puerto = 5000;
		System.out.println("CLIENTE >> Arranca cliente");
		Socket cliente = new Socket(host,puerto);
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		
		RepasoPerro p = (RepasoPerro) inObjeto.readObject();
		System.out.println("CLIENTE >> Recibo del servidor: "+p.getNom() + " - " +p.getEdad());
		p.setNom("Jose Garcia");
		p.setEdad(30);
		
		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
		pMod.writeObject(p);
		
		System.out.println("CLIENTE >> Envio al servidor: "+p.getNom() + " - " +p.getEdad());
		
		inObjeto.close();
		pMod.close();
		cliente.close();

	}

}
