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
	static final String URI = "localhost";
	public static void main(String[] args) {
		try {
			List<Coche> lstCoches = getCoches();
			lstCoches.forEach(c -> System.out.println(c));
		} catch (Exception e) {
			System.err.println("Fallo: " + e.getMessage());
		}
	}
	private static List<Coche> getCoches() throws Exception{
		String url = URI + "lst_coche.php";
		String requestHttp = peticionHttp(url);
		List<Coche>  lstCoches = stringToListCoches(requestHttp);
		return lstCoches;
	}
	private static String peticionHttp(String urlWebService) throws Exception{
		StringBuilder sbResult = new StringBuilder();
		URL url = new URL(urlWebService);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
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
		Integer iId = jsonObj.getInt("id_coche");
		String sMarca = jsonObj.getString("marca");
		Integer iPotencia = jsonObj.getInt("potencia");
		return new Coche(iId, sMarca, iPotencia);
	}
}