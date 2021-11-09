package ctrl;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.CcAa;
import model.Ciudad;
import model.Provincia;

public class CtrlFrmPrincipal {
	
	public static GestFchXML fchXML;

	public static void inicio() {

		final String FILE_NAME = "PB.XML";
		String sHoy = DateTimeFormatter.ofPattern("yyy-MM-dd").format(LocalDateTime.now());
		try {
			ctrl.GestFchXML.downloadAemet(sHoy, FILE_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fchXML = new GestFchXML(FILE_NAME);
		new view.FrmPrincipal();
		
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
	
	public static ArrayList<String> crearArrayComunidades() {
		ArrayList<String> listadoComunidades = new ArrayList<String>();
		for (CcAa ca : ctrl.CtrlFrmPrincipal.fchXML.getCcAa()) {
			listadoComunidades.add(ca.getsNombre());
		}
		return listadoComunidades;
	}
	
	public static ArrayList<String> crearArrayProvincias(int iPosition) {
		ArrayList<String> listadoProvincias = new ArrayList<String>();
		for (Provincia pr : ctrl.CtrlFrmPrincipal.fchXML.getCcAa().get(iPosition).getListadoProvincias()) {
			listadoProvincias.add(pr.getsNombre());
		}
		return listadoProvincias;
	}
	
	public static ArrayList<String> crearArrayCiudades(int iPositionCcAa, int iPositionProv) {
		ArrayList<String> listadoComunidades = new ArrayList<String>();
		for (Ciudad ci : ctrl.CtrlFrmPrincipal.fchXML.getCcAa().get(iPositionCcAa).getListadoProvincias().get(iPositionProv).getListadoCiudades()) {
			listadoComunidades.add(ci.getsNombre());
		}
		return listadoComunidades;
	}

	public static void comunidadSeleccionada() {
		view.FrmPrincipal.cbCiudad.removeAllItems();
		view.FrmPrincipal.cbProvincia.removeAllItems();
		view.FrmPrincipal.cbCiudad.setEnabled(false);
		view.FrmPrincipal.cbProvincia.setEnabled(true);
		ArrayList<String> listadoProvincias = crearArrayProvincias(view.FrmPrincipal.cbComunidad.getSelectedIndex());
		for (String provincia : listadoProvincias) {
			view.FrmPrincipal.cbProvincia.addItem(provincia);
		}

	}

	public static void provinciaSeleccionada() {
		view.FrmPrincipal.cbCiudad.removeAllItems();
		view.FrmPrincipal.cbCiudad.setEnabled(true);
		ArrayList<String> listadoCiudades = crearArrayCiudades(view.FrmPrincipal.cbComunidad.getSelectedIndex(), view.FrmPrincipal.cbProvincia.getSelectedIndex());
		for (String provincia : listadoCiudades) {
			view.FrmPrincipal.cbCiudad.addItem(provincia);
		}

	}

	public static void ciudadSeleccionada() {
		double dTempMin;
		double dTempMax;
//		if (view.FrmPrincipal.cbCiudad.getSelectedIndex() != -1 && view.FrmPrincipal.cbProvincia.getSelectedIndex() != -1) {
			dTempMin = ctrl.CtrlFrmPrincipal.fchXML.getCcAa().get(view.FrmPrincipal.cbComunidad.getSelectedIndex()).getListadoProvincias().get(view.FrmPrincipal.cbProvincia.getSelectedIndex()).getListadoCiudades().get(view.FrmPrincipal.cbCiudad.getSelectedIndex()).getdTempMin();
			dTempMax = ctrl.CtrlFrmPrincipal.fchXML.getCcAa().get(view.FrmPrincipal.cbComunidad.getSelectedIndex()).getListadoProvincias().get(view.FrmPrincipal.cbProvincia.getSelectedIndex()).getListadoCiudades().get(view.FrmPrincipal.cbCiudad.getSelectedIndex()).getdTempMax();
			
//		} else {
//			dTempMin = ctrl.CtrlFrmPrincipal.fchXML.getCcAa().get(view.FrmPrincipal.cbComunidad.getSelectedIndex()).getListadoProvincias().get(0).getListadoCiudades().get(0).getdTempMin();
//			dTempMax = ctrl.CtrlFrmPrincipal.fchXML.getCcAa().get(view.FrmPrincipal.cbComunidad.getSelectedIndex()).getListadoProvincias().get(0).getListadoCiudades().get(0).getdTempMax();
//			
//		}
		view.FrmPrincipal.lblTemperaturas.setText(dTempMin + " - " + dTempMax );
		view.FrmPrincipal.lblTemperaturas.setVisible(true);
	}

	public static void guardarPorDefecto() {
		

	}

}
