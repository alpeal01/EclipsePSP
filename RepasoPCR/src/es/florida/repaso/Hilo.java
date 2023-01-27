package es.florida.repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Hilo implements Runnable {
	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;

	public Hilo(Socket socket){
		this.socket = socket;
	}




	public void run() {
		try {
//			InputStream is = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is);
//			bfr = new BufferedReader(isr);
//			OutputStream os = socket.getOutputStream();
//			pw = new PrintWriter(os);
//			
//			System.err.println("Servidor a la espera de string");
//			String linea = bfr.readLine();
//			System.out.println(linea);
//			
//			System.err.println("Servidor envio de info");
//			
//			pw.print("hey\n");
//			pw.flush();
			
			ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());


			
			System.err.println("Servidor espera persona");
			Persona p =  (Persona) inObjeto.readObject();
			
			System.err.println("Servidor recive persona: "+p.getNombre());
			
			p.setNombre("Juancalo");
			
			outObjeto.writeObject(p);
			System.err.println("Servidor envio de la persona modificada");
			
			outObjeto.close();
			inObjeto.close();
			

			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("SERVIDOR >>> Error.");
		}
	}
}
