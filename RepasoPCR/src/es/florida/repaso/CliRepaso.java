package es.florida.repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class CliRepaso {

	public static void main(String[] args)throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexion al servidor");
		InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
		Socket socket = new Socket();
		socket.connect(direccion);
		
//		System.out.println("CLIENTE >>> Preparado canal para recibir resultado");
//		InputStream is = socket.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader bfr = new BufferedReader(isr);
//		
//		System.out.println("CLIENTE >>> Envio de datos");
//		PrintWriter pw = new PrintWriter(socket.getOutputStream());
//		pw.print("Que tal\n");
//		pw.flush();
//		
//		String resultado = bfr.readLine();
//		
//		System.out.println("CLIENTE >>> Recibe respuesta: " + resultado);
		ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
		Persona p = new Persona("JoseJuan", 24);
		
		outObj.writeObject(p);
		
		System.out.println("CLiente envia persona: "+p.getNombre());
		
		p =  (Persona) inObj.readObject();
		
		System.out.println("Cliente recive nueva persona: "+ p.getNombre());
		outObj.close();
		inObj.close();
		

	}

}
