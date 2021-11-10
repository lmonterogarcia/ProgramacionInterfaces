package ctrl;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.CcAa;
import model.Ciudad;
import model.Provincia;

public class CtrlFrmPrincipal {
	
	public static GestFchXML fchXML;
	public static String[] arrayComunidades;
	public static String[] arrayProvincias;
	public static String[] arrayCiudades;
	private static ArrayList<CcAa> listadoComunidades;

	public static void inicio() {

		final String FILE_NAME = "PB.XML";
		String sHoy = DateTimeFormatter.ofPattern("yyy-MM-dd").format(LocalDateTime.now());
		try {
			ctrl.GestFchXML.downloadAemet(sHoy, FILE_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fchXML = new GestFchXML(FILE_NAME);
		listadoComunidades = ctrl.CtrlFrmPrincipal.fchXML.getCcAa();
		new view.FrmPrincipal();
		crearDatosInicial();
		mostrarTemperatura();
	
	}

	public static void salir() {

		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null, "Desea salir?", "Asistente de salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (iOpcSeleccionada == JOptionPane.YES_OPTION) {
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} else if (iOpcSeleccionada == JOptionPane.NO_OPTION) {
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		}

	}
	
	public static void crearArrayComunidades() {
		arrayComunidades = null;
		arrayComunidades = new String[listadoComunidades.size()];
		for (int i = 0; i < arrayComunidades.length; i++) {
			arrayComunidades[i] = listadoComunidades.get(i).getsNombre();
		}
		
		view.FrmPrincipal.cbComunidad.removeAll();
		rellenarComunidades();

	}
	
	private static void rellenarComunidades() {
		
		for (String ccaa : arrayComunidades) {
			view.FrmPrincipal.cbComunidad.add(ccaa);
		}
		
	}

	public static void crearArrayProvincias(int iPosition) {
		
		arrayProvincias = null;
		arrayProvincias = new String[listadoComunidades.get(iPosition).getListadoProvincias().size()];
		for (int i = 0; i < arrayProvincias.length; i++) {
			arrayProvincias[i] = listadoComunidades.get(iPosition).getListadoProvincias().get(i).getsNombre();
		}
		view.FrmPrincipal.cbProvincia.removeAll();
		rellenarProvincias();
		
	}
	
	private static void rellenarProvincias() {
		for (String provincia : arrayProvincias) {
			view.FrmPrincipal.cbProvincia.add(provincia);
		}
		
	}

	public static void crearArrayCiudades(int iPositionCcAa, int iPositionProv) {
		
		arrayCiudades = null;
		arrayCiudades = new String[listadoComunidades.get(iPositionCcAa).getListadoProvincias().get(iPositionProv).getListadoCiudades().size()];
		for (int i = 0; i < arrayCiudades.length; i++) {
			arrayCiudades[i] = listadoComunidades.get(iPositionCcAa).getListadoProvincias().get(iPositionProv).getListadoCiudades().get(i).getsNombre();
		}
		view.FrmPrincipal.cbCiudad.removeAll();
		rellenarCiudades();

	}
	
	private static void rellenarCiudades() {
		for (String ciudad : arrayCiudades) {
			view.FrmPrincipal.cbCiudad.add(ciudad);
		}
		
	}

	private static void crearDatosInicial() {
		crearArrayComunidades();
		crearArrayProvincias(0);
		crearArrayCiudades(0, 0);
		view.FrmPrincipal.cbProvincia.select(0);
		view.FrmPrincipal.cbCiudad.select(0);
		
	}

	private static void mostrarTemperatura() {
		double dTempMin;
		double dTempMax;
		dTempMin = listadoComunidades.get(view.FrmPrincipal.cbComunidad.getSelectedIndex()).getListadoProvincias().get(view.FrmPrincipal.cbProvincia.getSelectedIndex()).getListadoCiudades().get(view.FrmPrincipal.cbCiudad.getSelectedIndex()).getdTempMin();
		dTempMax = listadoComunidades.get(view.FrmPrincipal.cbComunidad.getSelectedIndex()).getListadoProvincias().get(view.FrmPrincipal.cbProvincia.getSelectedIndex()).getListadoCiudades().get(view.FrmPrincipal.cbCiudad.getSelectedIndex()).getdTempMax();
		view.FrmPrincipal.lblTemperaturas.setText(dTempMin + " - " + dTempMax );
		
	}

	public static void comunidadSeleccionada() {
		
		crearArrayProvincias(view.FrmPrincipal.cbComunidad.getSelectedIndex());
		view.FrmPrincipal.cbProvincia.select(0);
		provinciaSeleccionada();
		
	}

	public static void provinciaSeleccionada() {
		
		crearArrayCiudades(view.FrmPrincipal.cbComunidad.getSelectedIndex(), view.FrmPrincipal.cbProvincia.getSelectedIndex());
		view.FrmPrincipal.cbCiudad.select(0);
		ciudadSeleccionada();
	}

	public static void ciudadSeleccionada() {
		mostrarTemperatura();
	}

	public static void guardarPorDefecto() {
		

	}

}
