package es.florida.t4PCR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {

		System.err.println("SERVIDOR >>> Arranca el servidor, espera peticion");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(1234);
			
		} catch (IOException e) {
			System.err.println("SERVIDOR >>> Error");
			return;
		}
		while (true) {
			Socket conexion = socketEscucha.accept();
		
			System.err.println("SERVIDOR >>> Conexion recibida!");
			InputStream is = conexion.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(isr);
			
			System.err.println("SERVIDOR >>> Lee datos del cliente");
			String linea = bf.readLine();
			System.out.println(linea);
			
			System.err.println("SERVIDOR >>> Envio de notificacion");
			PrintWriter pw = new PrintWriter(conexion.getOutputStream());
			pw.print("Servidor: recivido\n");
			pw.flush();
			
			
			System.err.println("SERVIDOR >>> Espera nueva info");
		}
	}

}
