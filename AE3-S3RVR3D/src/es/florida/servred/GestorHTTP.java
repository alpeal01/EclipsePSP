package es.florida.servred;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.net.httpserver.*;

public class GestorHTTP implements HttpHandler {

	private String handleGetRequest(HttpExchange httpExchange) {

		if (httpExchange.getRequestURI().toString().lastIndexOf("?") != -1
				&& httpExchange.getRequestURI().toString().lastIndexOf("alias") != -1) {

			return "alias,"+httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];

		} else if (httpExchange.getRequestURI().toString().lastIndexOf("mostrarTodos") != -1) {

			return httpExchange.getRequestURI().toString().split("/")[2];

		}
		return "error";

	}

	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {

		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "";
		if (requestParamValue.equals("mostrarTodos")) {
			//mostrar lista de delincuentes 
			htmlResponse = "<html><body>" + mostrarTodos() + "</body></html>";
			
		}else if(requestParamValue.contains("alias")) {
			
			//mostrar datos de un delincuente
			htmlResponse = "<html><body>" + delincuente(requestParamValue.split(",")[1]) + "</body></html>";
		}
		
		else {
			System.out.println(requestParamValue);
			htmlResponse = "<html><body>Url no valida </body></html>";
		}

		httpExchange.sendResponseHeaders(200, htmlResponse.length());

		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
	}

	private String handlePostRequest(HttpExchange httpExchange) {
		InputStream inputStream = httpExchange.getRequestBody();
		// Procesar lo que hay en inputStream, por ejemplo linea a linea y guardarlo
		// todo en un string, que sera el que devuelve el metodo
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

	String mostrarTodos() {

		String list = "";

		JSONParser parser = new JSONParser();

	
			try {
				
				Object obj = parser.parse(new FileReader("./src/es/florida/servred/delincuentes.json"));
				JSONObject json = (JSONObject) obj;
				JSONArray delincuentes = (JSONArray) json.get("delincuentes");
				
				
				
				for (int i = 0; i < delincuentes.size(); i++) {
					
					JSONObject delincuente =  (JSONObject) delincuentes.get(i);
					list += "<p>"+delincuente.get("alias")+"</p>";
					
					
					
				}
				
				  
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return list;
	}
	
	String delincuente(String alias) {
		
		String datos = "";
		
		if(alias.contains("%20")) {
			alias = alias.replaceAll("%20", " ");
			
		}
		
		System.out.println(alias);
		

		JSONParser parser = new JSONParser();

	
			try {
				
				Object obj = parser.parse(new FileReader("./src/es/florida/servred/delincuentes.json"));
				JSONObject json = (JSONObject) obj;
				JSONArray delincuentes = (JSONArray) json.get("delincuentes");
				
				
				
				for (int i = 0; i < delincuentes.size(); i++) {
					
					JSONObject delincuente =  (JSONObject) delincuentes.get(i);
					
					if(delincuente.get("alias").equals(alias)) {
						
						datos += "<p> Alias: "+delincuente.get("alias")+"</p>";
						datos += "<p> Nombre: "+delincuente.get("nombreCompleto")+"</p>";
						datos += "<p>Fecha de nacimiento: "+delincuente.get("fechaNacimiento")+"</p>";
						datos += "<p> Nacionalidad: "+delincuente.get("nacionalidad")+"</p>";
						
						return datos;
						
					}
					
					
					
				}
				
				  
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	
		return datos;
		
	}
	
}
