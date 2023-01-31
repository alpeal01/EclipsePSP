package es.florida.servred;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.net.httpserver.*;

public class GestorHTTP implements HttpHandler {

	private void enviarMail(String mensaje, String asunto, String email_remitente, String email_destino, String pass)
			throws AddressException, MessagingException {

		// using host as localhost
		String host = "127.0.0.1";

		Properties properties = System.getProperties();

		properties.setProperty("mail.smtp.host", host);

		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(email_remitente));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_destino));

			message.setSubject(asunto);

			message.setText(mensaje);

			Transport transport = session.getTransport("smtp");
			transport.connect(host, email_remitente, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();


			System.out.println("Mail successfully sent");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	private String handleGetRequest(HttpExchange httpExchange) {

		if (httpExchange.getRequestURI().toString().lastIndexOf("?") != -1
				&& httpExchange.getRequestURI().toString().lastIndexOf("alias") != -1) {

			return "alias," + httpExchange.getRequestURI().toString().split("\\?")[1].split("=")[1];

		} else if (httpExchange.getRequestURI().toString().lastIndexOf("mostrarTodos") != -1) {

			return httpExchange.getRequestURI().toString().split("/")[2];

		} else if (httpExchange.getRequestURI().toString().lastIndexOf("nuevo") != -1) {

			return httpExchange.getRequestURI().toString().split("/")[2];

		}
		return "error";

	}

	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {

		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "";
		if (requestParamValue.equals("mostrarTodos")) {
			// mostrar lista de delincuentes
			htmlResponse = "<html><Head><H1>Lista de Delincuentes: </H1><body>" + mostrarTodos() + "</body></html>";

		} else if (requestParamValue.contains("alias")) {

			// mostrar datos de un delincuente
			htmlResponse = "<html><Head><H1>Datos del delincuente: </H1><body>"
					+ delincuente(requestParamValue.split(",")[1]) + "</body></html>";
		} else if (requestParamValue.equals("nuevo")) {

			// crear un nuevo delincuente
			// meter la imagen a subir en la carpeta images
			htmlResponse = "<html><Head><H1>Lista de Delincuentes: </H1><body>"
					+ "<form name=\"createDelincuente\" method=\"post\" action=\"mostrarTodos\">\r\n"
					+ "Alias: <input type=\"text\" name=\"alias\"/> <br/>"
					+ "nombreCompleto: <input type=\"text\" name=\"nombreCompleto\"/> <br/>"
					+ "fechaNacimiento: <input type=\"text\" name=\"fechaNacimiento\"/> <br/>"
					+ "nacionalidad: <input type=\"text\" name=\"nacionalidad\"/> <br/>"
					+ "imagen en base64: <input type=\"text\" name=\"imagen\"/> <br/>"
					+ "<input type=\"submit\" value=\"Crear\" />\r\n" + "</form>";

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
		System.out.println("Recibida URI tipo PUT: " + httpExchange.getRequestBody().toString());
		InputStream is = httpExchange.getRequestBody();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private void handlePOSTResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		// System.out.println("handlePOSTResponse");
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "Respuesta a la petición POST";
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
	}

	private void crearLog(String ip, String hora) throws IOException {

		String log = "IP: " + ip + "\n" + "Día y hora: " + hora + "\n";

		FileWriter fw = new FileWriter("log.txt");
		System.out.println("Entra");
		fw.write(log);
		fw.close();
	}

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {

		String ip = httpExchange.getRemoteAddress().toString();
		String hora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
		crearLog(ip, hora);

		System.out.println("handle");

		String requestParamValue = null;

		if ("GET".equals(httpExchange.getRequestMethod())) {

			requestParamValue = handleGetRequest(httpExchange);

			handleGETResponse(httpExchange, requestParamValue);

		} else if ("POST".equals(httpExchange.getRequestMethod())) {

			System.out.println("Posteo");

			requestParamValue = handlePostRequest(httpExchange);

			try {
				guardarDelincuente(requestParamValue);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

				JSONObject delincuente = (JSONObject) delincuentes.get(i);
				list += "<p>" + delincuente.get("alias") + "</p>";
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

		if (alias.contains("%20")) {
			alias = alias.replaceAll("%20", " ");

		}

		System.out.println(alias);

		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("./src/es/florida/servred/delincuentes.json"));
			JSONObject json = (JSONObject) obj;
			JSONArray delincuentes = (JSONArray) json.get("delincuentes");

			for (int i = 0; i < delincuentes.size(); i++) {

				JSONObject delincuente = (JSONObject) delincuentes.get(i);

				if (delincuente.get("alias").equals(alias)) {

					datos += "<p> Alias: " + delincuente.get("alias") + "</p>";
					datos += "<p> Nombre: " + delincuente.get("nombreCompleto") + "</p>";
					datos += "<p>Fecha de nacimiento: " + delincuente.get("fechaNacimiento") + "</p>";
					datos += "<p> Nacionalidad: " + delincuente.get("nacionalidad") + "</p>";
					datos += "<p> <img src=\"data:image/png;base64, " + delincuente.get("imagen")
							+ "\" alt=\"Foto del delinecuente\" /> </p>";

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

	void guardarDelincuente(String requestParamValue) throws AddressException, MessagingException {

		String[] list = requestParamValue.split("&");
		System.out.println(Arrays.toString(list));
		String[] mail = { "hesalu@floridauniversitaria.es" };

		enviarMail(requestParamValue, "Delincuente añadido", "emailRemitente", "emailDestino", "contraseña");
		// meter la imagen a subir en la carpeta images
		byte[] fileContent;
		try {

			JSONParser parser = new JSONParser();

			try {

				Object obj = parser.parse(new FileReader("./src/es/florida/servred/delincuentes.json"));
				JSONObject json = (JSONObject) obj;
				JSONArray delincuentes = (JSONArray) json.get("delincuentes");

				JSONObject newDel = new JSONObject();

				for (int i = 0; i < list.length; i++) {

					String[] line = list[i].split("=");

					if (line[1].contains("+")) {

						line[1] = line[1].replace("+", " ");
						newDel.put(line[0], line[1]);

					} else
						newDel.put(line[0], line[1]);

				}
				delincuentes.add(newDel);

				JSONObject finalJson = new JSONObject();

				finalJson.put("delincuentes", delincuentes);

				System.out.println("Json actualizado");

				FileWriter file = new FileWriter("./src/es/florida/servred/delincuentes.json");
				file.write(finalJson.toJSONString());
				file.close();

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

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
