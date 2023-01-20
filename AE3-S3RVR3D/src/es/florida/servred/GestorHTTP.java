package es.florida.servred;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.*;

public class GestorHTTP implements HttpHandler {

	private String handleGetRequest(HttpExchange httpExchange) {
		
		System.out.println(httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1]);
		
		return httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
	}
	
	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "<html><body>Hola mundo:"+requestParamValue+"</body></html>";
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

//			requestParamValue = handlePostRequest(httpExchange);
//			
//			handlePOSTResponse(httpExchange, requestParamValue);
		}
	}
}
