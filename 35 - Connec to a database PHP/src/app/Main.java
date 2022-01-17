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

	static final String URI = "http://bestipescook.es/Luis/";
	
	public static void main(String[] args) {
		
		try {
			
			// Insertar un coche
			Coche a = new Coche("Peugeot", 2500);
			System.out.println(insCoche(a));
			
			// Borrar coche
			
			
			// Listado de coche
			List<Coche> lstCoches = getCoches();
			lstCoches.forEach(c -> System.out.println(c));
			
			// obtener un solo coche
			Coche d = getCoche(1);
			System.out.println(d);
			
		} catch (Exception e) {
		
			System.err.println("Fallo: " + e.getMessage());
			
		}

	}

	private static String insCoche(Coche a) throws Exception {
		String sMensaje;
		String url = URI + "ins_coche.php?txtMarca=" + a.getsMarca() + "&txtPotencia=" + a.getiPotencia();
		System.out.println(url);
		String requestHttp = peticionHttp(url);
		System.out.println(requestHttp);
		if (requestHttp.equals("200")) {
			sMensaje = "Se ha insertado el coche";
		} else {
			sMensaje = "No se ha podido insertar el coche";
		}
		
		return sMensaje;
		
	}

	private static Coche getCoche(int id) throws Exception {
		String url = URI + "get_coche.php?txtId=" + id;
		String requestHttp = peticionHttp(url);
		Coche  c = stringToCoche(requestHttp);
		return c;
	}

	private static Coche stringToCoche(String requestHttp) {		
		
		JSONObject jsonObj = new JSONObject(requestHttp);
			
		return objJson2Coche(jsonObj);
	}

	private static List<Coche> getCoches() throws Exception{
		 
		String url = URI + "lst_coche.php";
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
		
		return sbResult.toString().trim();
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
		Integer iId = jsonObj.getInt("id_coche");
		String sMarca = jsonObj.getString("marca");
		//String sModelo = jsonObj.getString("modelo");
		Integer iPotencia = jsonObj.getInt("potencia");
		
		
		//return new Coche(iId, sMarca, sModelo, iPotencia);
		return new Coche(iId, sMarca, iPotencia);
	}

}
