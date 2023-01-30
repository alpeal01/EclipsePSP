package es.florida.examen2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Hilo implements Runnable {

	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;

	public Hilo(Socket socket) {
		this.socket = socket;
	}

	static boolean compList(String user, String pass) throws IOException {
		File f = new File("./usuarios_autorizados.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {

			String[] data = line.split(";");
			if (data[0].equals(user) && data[1].equals(pass)) {

				return true;

			}

		}
		return false;

	}

	static int numGen() {

		int num = (int) (Math.random() * 10);

		return num;

	}

	static boolean compResp(int servNum, String userNum) {

		try {
			if (servNum == Integer.parseInt(userNum)) {

				return true;
			} else
				return false;

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}

	}
	
	static String getContenido(String user) throws IOException {
		
		File f = new File("./contenido.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {

			String [] list = line.split(";"); 
			
			if(list[0].equals(user)) {
				
				return list[1];
				
			}
			
		}
		return "";
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		InputStream is;
		try {

			is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);
			pw = new PrintWriter(socket.getOutputStream());

			System.err.println("SERVIDOR >>> EPERA DE INFORMACION");
			String user = bfr.readLine();
			String pwd = bfr.readLine();

			System.err.println("SERVIDOR >>> Informacion recivida validando acceso...");

			if (compList(user, pwd)) {
				System.err.println("SERVIDOR >>> Usuario encontrado, envio de numero de validacion");
				int ng = numGen();
				pw.write(ng + "\n");
				pw.flush();

				System.err.println("SERVIDOR >>> Espera al numero del usuario...");
				String userNum = bfr.readLine();
				System.err.println("SERVIDOR >> Validando numero de usuario...");
				
				if (compResp(ng, userNum)) {
					
					pw.write( getContenido(user)+"\n");
					pw.flush();
					
					System.err.println("SERVIDOR >>> Espera de recibido");
					String msg = bfr.readLine();
					
					System.err.println("Servidor >>> Mensaje del cliente: "+ msg);
					socket.close();
				}

				else {
					System.err.println("Servidor >>> ERROR VALIDACION");

					pw.write("ERROR\n");
					pw.flush();

					socket.close();
					

				}
				;

			} else {
				System.err.println("Servidor >>> ERROR VALIDACION");
				pw.write("ERROR\n");
				pw.flush();

				socket.close();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
