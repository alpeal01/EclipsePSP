package es.florida.t4PCR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) throws IOException {
		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexion al servidor");
		InetSocketAddress direccion = new InetSocketAddress("localhost", 1234);
		Socket socket = new Socket();
		socket.connect(direccion);
		
		System.out.println("CLIENTE >>> Preparado canal para recibir informacion");
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		
		System.out.println("CLIENTE >>> Envio de datos");
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.print("Hola mundo\n");
		pw.flush();
		
		//Recibir respues y mostrarla
		System.out.println("CLIENTE >> Reciviendo informacion");
		String respuesta = bfr.readLine();
		System.out.println("CLIENTE >> " + respuesta);
		
		
		socket.close();

		}


}
