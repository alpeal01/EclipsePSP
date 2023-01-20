package es.florida.servred;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.net.httpserver.*;

public class GestorHTTP implements HttpHandler {

	private String handleGetRequest(HttpExchange httpExchange) {
		if (httpExchange.getRequestURI().toString().lastIndexOf("?") != -1 && httpExchange.getRequestURI().toString().lastIndexOf("alias") != -1) {
			return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		} else if (httpExchange.getRequestURI().toString().lastIndexOf("mostrarTodos") != -1){
			return httpExchange.getRequestURI().toString().split("/")[2];
		}
		return "error";
		
	}
	
	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "<html><body>Hola "+requestParamValue+"</body></html>";
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
		}
	
	private String handlePostRequest(HttpExchange httpExchange) {
		InputStream inputStream = httpExchange.getRequestBody();
		//Procesar lo que hay en inputStream, por ejemplo linea a linea y guardarlo todo en un string, que sera el que devuelve el metodo
		String postRequest = "";
		
		return postRequest;
		}
	
	private void handlePOSTResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "Respuesta a la petición POST";
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
		}

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		
		System.out.println("handle");
		
		String requestParamValue = null;

		if ("GET".equals(httpExchange.getRequestMethod())) {

			requestParamValue = handleGetRequest(httpExchange);
			
			handleGETResponse(httpExchange, requestParamValue);

		} else if ("POST".equals(httpExchange.getRequestMethod())) {

			requestParamValue = handlePostRequest(httpExchange);
			
			handlePOSTResponse(httpExchange, requestParamValue);
		}
	}
}
