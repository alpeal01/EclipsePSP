package es.florida.servred;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import com.sun.net.httpserver.*;

public class ServidorHTTP {
	public static void main(String[] args) throws Exception {
		String host = "localhost"; // 127.0.0.1
		int puerto = 5000;
		InetSocketAddress direccionTCPIP = new InetSocketAddress(host, puerto);
		int backlog = 0;
		HttpServer servidor = HttpServer.create(direccionTCPIP, backlog);
		GestorHTTP gestorHTTP = new GestorHTTP();
		String rutaRespuesta = "/servidor";
		servidor.createContext(rutaRespuesta, gestorHTTP);

		//multihilo con ThreadPoolExecutor
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		servidor.setExecutor(threadPoolExecutor);
		servidor.start();
		System.out.println("Servidor HTTP arranca en el puerto " + puerto);
	}
}