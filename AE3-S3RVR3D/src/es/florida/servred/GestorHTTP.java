package es.florida.servred;

import java.io.IOException;
import com.sun.net.httpserver.HttpServer;

public class GestorHTTP {

	
	public void handle(HttpExchange httpExchange) throws IOException {
		String requestParamValue = null;
		if ("GET".equals(httpExchange.getRequestMethod())) {
			requestParamValue = handleGetRequest(httpExchange);
			handleGETResponse(httpExchange, requestParamValue);
		} else if ("POST".equals(httpExchange.getRequestMethod())) {
			requestParamValue = handlePostRequest(httpExchange);
			handlePOSTResponse(httpExchange, requestParamValue);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
