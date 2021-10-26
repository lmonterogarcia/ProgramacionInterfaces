package ctrl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.IProducto;
import model.Producto;

public class GestionFch implements IProducto {

	private String sRuta = "datos.db";
	private ArrayList<Producto> listadoMac;
	private ArrayList<Producto> listadoIpad;
	private ArrayList<Producto> listadoIphone;
	private ArrayList<Producto> listadoWatch;
	private ArrayList<Producto> listadoAirpods;
	private ArrayList<Producto> listadoAccesorios;
	
	public GestionFch(){
		listadoMac = new ArrayList<Producto>();
		listadoIpad = new ArrayList<Producto>();
		listadoIphone = new ArrayList<Producto>();
		listadoWatch = new ArrayList<Producto>();
		listadoAirpods = new ArrayList<Producto>();
		listadoAccesorios = new ArrayList<Producto>();
	}

	public ArrayList<Producto> getListadoMac() {
		return listadoMac;
	}

	public ArrayList<Producto> getListadoIpad() {
		return listadoIpad;
	}

	public ArrayList<Producto> getListadoIphone() {
		return listadoIphone;
	}

	public ArrayList<Producto> getListadoWatch() {
		return listadoWatch;
	}

	public ArrayList<Producto> getListadoAirpods() {
		return listadoAirpods;
	}

	public ArrayList<Producto> getListadoAccesorios() {
		return listadoAccesorios;
	}

	public void leerProductos() {

		try {
			ObjectInputStream br = new ObjectInputStream(new FileInputStream(sRuta));

			Object obj = br.readObject();

			if (obj instanceof ArrayList<?>) {
				ArrayList<Producto> listadoProducto = (ArrayList<Producto>) obj;

				for (Producto producto : listadoProducto) {
					String sCategoria = producto.getsCategoria();
					switch (sCategoria.toLowerCase()) {
					case "mac":
						listadoMac.add(producto);
						break;
					case "ipad":
						listadoIpad.add(producto);
						break;
					case "iphone":
						listadoIphone.add(producto);
						break;
					case "watch":
						listadoWatch.add(producto);
						break;
					case "airpods":
						listadoAirpods.add(producto);
						break;
					default:
						listadoAccesorios.add(producto);
						break;
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Se ha producido un error al acceder al fichero");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error no clasificado");
			e.printStackTrace();
		}
	}

	public void guardarProductos() {

		ArrayList<Producto> listadoProducto = new ArrayList<Producto>();

		if (listadoMac.size() > 0) {
			listadoProducto.addAll(listadoMac);
		}
		if (listadoIpad.size() > 0) {
			listadoProducto.addAll(listadoIpad);
		}
		if (listadoIphone.size() > 0) {
			listadoProducto.addAll(listadoIphone);
		}
		if (listadoWatch.size() > 0) {
			listadoProducto.addAll(listadoWatch);
		}
		if (listadoAirpods.size() > 0) {
			listadoProducto.addAll(listadoAirpods);
		}
		if (listadoAccesorios.size() > 0) {
			listadoProducto.addAll(listadoAccesorios);
		}

		try {
			ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(sRuta));

			bw.writeObject(listadoProducto);

			bw.close();
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Se ha producido un error al acceder al fichero");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error no clasificado");
			e.printStackTrace();
		}

	}
}
