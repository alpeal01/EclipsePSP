package es.florida.pi;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.net.httpserver.*;

public class GestorHTTP implements HttpHandler {

	private String handleGetRequest(HttpExchange httpExchange) {
		String[] op;
		
		op = ((httpExchange.getRequestURI().toString().split("\\?")));
		
		if(op.length == 2 && op[1].contains("=")) {
			return op[1];
		}
		else if (op.length == 1 && op[0].equals("/users")) {
			
			return "allUsers";
		}else
		
		return "Error";
	}

	//respuesta de la peticion get
	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "<html><body>" + requestParamValue + "</body></html>";
		if(requestParamValue.equals("allUsers")) {
			getAllUsers();
			htmlResponse = "<html><body>" + getAllUsers() + "</body></html>";
	
		}
		
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
		
		
		
	
	}

	private String handlePostRequest(HttpExchange httpExchange) {
		InputStream inputStream = httpExchange.getRequestBody();
		// Procesar lo que hay en inputStream, por ejemplo linea a linea y guardarlo
		// todo
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
	
	//Primero que nada
	public void handle(HttpExchange httpExchange) throws IOException {
		String requestParamValue = null;
		if ("GET".equals(httpExchange.getRequestMethod())) {
			
			requestParamValue = handleGetRequest(httpExchange);
			System.out.println(requestParamValue);
			
			handleGETResponse(httpExchange, requestParamValue);
			
		} else if ("POST".equals(httpExchange.getRequestMethod())) {
			
			requestParamValue = handlePostRequest(httpExchange);
			handlePOSTResponse(httpExchange, requestParamValue);
			
		}
	}
	
	static JSONObject getAllUsers() {
		
		JSONParser parser = new JSONParser();  
		JSONObject obj = new JSONObject();

	      obj.put("name", "foo");
	      obj.put("num", 100);
	      obj.put("balance",1000.21);
	      obj.put("is_vip",true);
	      
	      
		System.out.println(obj.toJSONString());
		
		return obj;
	}
}