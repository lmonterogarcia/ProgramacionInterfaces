package ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import model.*;

public class GestFchXML {

	private Document docXML;

	public GestFchXML(String filename) {
		try {
			docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(filename);
			docXML.getDocumentElement().normalize();
		} catch (SAXException e) {
			System.err.println("Error SAX.");
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			System.err.println("Error con el PARSE");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero");
			e.printStackTrace();
		}
	}

	public ArrayList<CcAa> getCcAa() {

		ArrayList<CcAa> listadCcAa = new ArrayList<CcAa>();
		XPath xPath = XPathFactory.newInstance().newXPath();
		String sExpression = "/root/ccaa";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String sNombre;
					ArrayList<Provincia> listadoProvincias;
					try {
						sNombre = eElement.getAttribute("nombre");
					} catch (Exception e) {
						sNombre = "";
					}
					listadoProvincias = getProvincias(eElement.getAttribute("id"));
					listadCcAa.add(new CcAa(sNombre, listadoProvincias));
				}
			}
		} catch (XPathExpressionException e) {
			System.err.println("Error aplicando al expresion");
			e.printStackTrace();
		}

		return listadCcAa;
	}

	private ArrayList<Provincia> getProvincias(String attribute) {
		ArrayList<Provincia> listadProvincias = new ArrayList<Provincia>();
		NodeList nodes = docXML.getElementsByTagName("provincia");

		for (int i = 0; i < nodes.getLength(); i++) {
			Element nodo = (Element) nodes.item(i);
			String sIdCcAa = nodo.getAttribute("ccaa");
			if (sIdCcAa.equals(attribute)) {
				String sNombre;
				ArrayList<Ciudad> listadoCiudades;
				try {
					sNombre = nodo.getAttribute("nombre");
				} catch (Exception e) {
					sNombre = "";
				}

				listadoCiudades = getCiudades(nodo.getAttribute("id"));
				listadProvincias.add(new Provincia(sNombre, listadoCiudades));
			}
		}

		return listadProvincias;
	}

	private ArrayList<Ciudad> getCiudades(String attribute) {
		ArrayList<Ciudad> listadoCiudades = new ArrayList<Ciudad>();
		NodeList nodes = docXML.getElementsByTagName("ciudad");

		for (int i = 0; i < nodes.getLength(); i++) {
			Element nodo = (Element) nodes.item(i);

			if (nodo.getAttribute("cod_ine").startsWith(attribute.substring(0, 2))) { // &&
																						// nodo.getAttribute("capital").equals("1")
				String sNombre;
				Double dTempMin, dTempMax;
				try {
					sNombre = nodo.getAttribute("nombre");
				} catch (Exception e) {
					sNombre = "";
				}
				try {
					dTempMax = Double.parseDouble(nodo.getElementsByTagName("tmax").item(0).getTextContent());
				} catch (Exception e) {
					dTempMax = 0d;
				}
				try {
					dTempMin = Double.parseDouble(nodo.getElementsByTagName("tmin").item(0).getTextContent());
				} catch (Exception e) {
					dTempMin = 0d;
				}

				listadoCiudades.add(new Ciudad(sNombre, dTempMin, dTempMax));
			}
		}
		return listadoCiudades;
	}

	public static void downloadAemet(String sFecha, String fch) throws Exception {
		String sUrl = "http://www.aemet.es/es/api-eltiempo/temperaturas/" + sFecha + "/PB";

		File file = new File(fch);
		URLConnection conn = new URL(sUrl).openConnection();
		conn.connect();

		InputStream in = conn.getInputStream();
		OutputStream out = new FileOutputStream(file);
		int b = 0;

		while (b != -1) {
			b = in.read();
			if (b != -1) {
				out.write(b);
			}
		}
		out.close();
		in.close();
	}

}
