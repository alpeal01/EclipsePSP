package es.florida.servred;

import java.net.InetSocketAddress;

public class ServidorHTTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String host = "localhost"; //127.0.0.1
		int puerto = 5000;
		InetSocketAddress direccionTCPIP = new InetSocketAddress(host,puerto);
		int backlog = 0;
		HttpServer servidor = HttpServer.create(direccionTCPIP, backlog);
		GestorHTTP gestorHTTP = new GestorHTTP();
		String rutaRespuesta = "/test";
		servidor.createContext(rutaRespuesta, gestorHTTP);
		//Opcion 1 de ejecucion: no multihilo
		// servidor.setExecutor(null);
		//Opcion 2 de ejecucion: multihilo con ThreadPoolExecutor
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
		servidor.setExecutor(threadPoolExecutor);
		servidor.start();
		System.out.println("Servidor HTTP arranca en el puerto " + puerto);
		


	}

}
