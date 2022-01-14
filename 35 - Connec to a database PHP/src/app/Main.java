package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Coche;

public class Main {

	static final String URI = "http://bestipescook.es/Javi/";
	
	public static void main(String[] args) {
		
		try {
			// Listado de coche
			List<Coche> lstCoches = getCoches();
			lstCoches.forEach(c -> System.out.println(c));
			
			// obtener un solo coche
			//Coche c = getCoche(0);
			//System.out.println(c);
			
		} catch (Exception e) {
		
			System.err.println("Fallo: " + e.getMessage());
			
			
		}
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static Coche getCoche(int id) throws Exception {
		String url = URI + "get-coche.php?id=" + id;
		String requestHttp = peticionHttp(url);
		Coche  c = stringToCoches(requestHttp);
		return null;
	}

	private static Coche stringToCoches(String requestHttp) {		
		
		JSONArray jsonArr = new JSONArray(requestHttp);
		JSONObject jsonObj = jsonArr.getJSONObject(0);
			
		return objJson2Coche(jsonObj);
	}

	private static List<Coche> getCoches() throws Exception{
		 
		String url = URI + "lst-coche.php";
		String requestHttp = peticionHttp(url);
		List<Coche>  lstCoches = stringToListCoches(requestHttp);
		 
		return lstCoches;
	}

	private static String peticionHttp(String urlWebService) throws Exception{
		
		StringBuilder sbResult = new StringBuilder();
		
		// Realizar peticion http
		URL url = new URL(urlWebService);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		// Recoger los datos de respuesta
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String linea;
		while ((linea = rd.readLine()) != null) {
			sbResult.append(linea);
		}
		
		return sbResult.toString();
	}
	
	private static List<Coche> stringToListCoches(String requestHttp) {
		List<Coche> lstCoches = new ArrayList<>();
		
		JSONArray jsonArr = new JSONArray(requestHttp);
		
		for (int i = 0; i < jsonArr.length(); i++) {
			
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			Coche c = objJson2Coche(jsonObj);
			lstCoches.add(c);
			
		}
		
		return lstCoches;
	}

	private static Coche objJson2Coche(JSONObject jsonObj) {
		
		// Extraer los values del obj json
		Integer iId = jsonObj.getInt("id");
		String sMarca = jsonObj.getString("marca");
		String sModelo = jsonObj.getString("modelo");
		Integer iPotencia = jsonObj.getInt("potencia");
		
		
		return new Coche(iId, sMarca, sModelo, iPotencia);
	}

}
