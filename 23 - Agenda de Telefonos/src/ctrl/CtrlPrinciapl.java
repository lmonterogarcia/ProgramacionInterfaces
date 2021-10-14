package ctrl;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Persona;

public class CtrlPrinciapl {

	public static void inicio() {

		new view.FrmPrincipal();
	}

	public static void abrirAgenda() {
		String sRuta = leerRuta();
		File fchAgenda = new File(sRuta);
		ArrayList<Persona> aPersonas = leerAgenda(fchAgenda);
	}

	private static ArrayList<Persona> leerAgenda(File fchAgenda) {
		ArrayList<Persona> aPersonas = new ArrayList<Persona>();

		return aPersonas;
	}

	private static String leerRuta() {
		String sRuta  ="";
		JFileChooser selectorFch = new JFileChooser();
		selectorFch.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Formato de Agenda", "txt");
		selectorFch.setFileFilter(imgFilter);

		int iBtnFch = selectorFch.showOpenDialog(null);

		if (iBtnFch != JFileChooser.CANCEL_OPTION) {
			File fileName = selectorFch.getSelectedFile();
			if (fileName != null && !fileName.getName().equals("")) {
				sRuta = fileName.getAbsolutePath();
			}
		}

		return sRuta;
	}

	public static void guardarAgenda() {

	}

	public static void editar() {

	}

	public static void guardar() {

	}

	public static void mostarNumero() {

	}



}
