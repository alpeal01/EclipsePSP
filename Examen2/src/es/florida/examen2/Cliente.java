package es.florida.examen2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexion al servidor");
		InetSocketAddress direccion = new InetSocketAddress("localhost", 4200);
		Socket socket = new Socket();
		socket.connect(direccion);
		
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Indique nombre de usuario");
		String user = sc.nextLine();
		
		System.out.println("Indique contrasenya");
		String pswd = sc.nextLine();
		
		System.out.println("CLIENTE >>> Envio de la información al Servidor");
		pw.write(user+"\n");
		pw.write(pswd+"\n");
		pw.flush();
		
		System.out.println("CLIENTE >>> ESPERA A NUMERO DE VALIDACION");
		String valNum = bfr.readLine();
		
		if(!valNum.equals("ERROR")){
			
			System.out.println("Escriba el siguiente numero: " + valNum);
			String userNum = sc.nextLine();
			
			System.out.println("Cliente >>> ENVIO DE NUMERO AL SERVIDOR");
			
			pw.write(userNum+"\n");
			pw.flush();
			
			System.out.println("Cliente >>> Espera de contenido...");
			String content =  bfr.readLine();
			
			if(!content.equals("ERROR")) {
				
				System.out.println("EXITO: "+content);
				pw.write("RECIBIDO\n");
				pw.flush();
				
				
			}
			
			else {
				
				System.out.println("CLIENTE >>> ERROR!");
				
			}
			
			
		}else {
			System.out.println("CLIENTE >>> ERROR!");
			is.close();
			isr.close();
			bfr.close();
			pw.close();
			socket.close();
		}
		
		
		
		
		is.close();
		isr.close();
		bfr.close();
		pw.close();
		socket.close();
	}

}
