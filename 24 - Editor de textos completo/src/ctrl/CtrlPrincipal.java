package ctrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CtrlPrincipal {

	private static RandomAccessFile fichero;
	private static String sRuta = "";

	public static void iniciar() {
		new view.FrmPrincipal();
	}

	public static void nuevo() {
		if (hayCambios()) {
			guardar();
		}
		sRuta = "";
		view.FrmPrincipal.textArea.setText("");
	}

	public static void abrir() {
		sRuta = leerRuta();
		try {
			fichero = new RandomAccessFile(sRuta, "rw");
			view.FrmPrincipal.textArea.setText(leerTexto(fichero));
			fichero.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Ha habido un problema al abrir el fichero");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error no tipificado\n" + e);
			e.printStackTrace();
		}
	}

	public static void guardar() {
		String sTexto = view.FrmPrincipal.textArea.getText();
		if (sRuta == "") {
			guardarComo();
		} else {
			guardarTexto(sTexto);
		}

	}

	public static void guardarComo() {
		String sTexto = view.FrmPrincipal.textArea.getText();
		sRuta = leerRutaParaGuardar();
		guardarTexto(sTexto);
	}

	public static void salir() {

		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null, "Desea salir?", "Asistente de salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (iOpcSeleccionada == JOptionPane.YES_OPTION) {
			System.exit(0);
		} else {
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		}

	}

	private static String leerRuta() {
		String sRuta = "";
		JFileChooser selectorFch = new JFileChooser();
		selectorFch.setDialogTitle("Eliga la fichero");
		selectorFch.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Formato de texto", "txt");
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

	private static String leerRutaParaGuardar() {
		String sRuta = "";
		JFileChooser guardarFch = new JFileChooser();
		guardarFch.setDialogTitle("Eliga la fichero");

		int iBtnFch = guardarFch.showSaveDialog(null);

		if (iBtnFch != JFileChooser.CANCEL_OPTION) {
			File fileName = guardarFch.getSelectedFile();
			if (fileName != null && !fileName.getName().equals("")) {
				sRuta = fileName.getAbsolutePath();
			}
		}

		return sRuta;
	}

	private static String leerTexto(RandomAccessFile fch) {
		String sTexto = "";

		try {
			byte[] bytesLeidos = new byte[(int) fch.length()];
			fch.readFully(bytesLeidos);
			sTexto = new String(bytesLeidos);
			fch.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Ha habido un problema al abrir el fichero");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error no tipificado\n" + e);
			e.printStackTrace();
		}

		return sTexto;
	}

	private static void guardarTexto(String sTexto) {
		try {
			fichero = new RandomAccessFile(sRuta, "rw");
			fichero.writeBytes(sTexto);
			fichero.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Ha habido un problema al abrir el fichero");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error no tipificado\n" + e);
			e.printStackTrace();
		}
	}

	private static boolean hayCambios() {
		boolean booHayCambios;

		if (sRuta.equals("")) {
			if (!view.FrmPrincipal.textArea.getText().equals("")) {
				booHayCambios = true;
			} else {
				booHayCambios = false;
			}
		} else {
			if (!view.FrmPrincipal.textArea.getText().equals(leerTexto(fichero))) {
				booHayCambios = true;
			} else {
				booHayCambios = false;
			}
		}

//		if (sRuta != "" && view.FrmPrincipal.textArea.getText() != "" ) {
//			booHayCambios = true;
//		} else if (!view.FrmPrincipal.textArea.getText().equals(leerTexto(fichero))){
//			booHayCambios = true;
//		} else {
//			booHayCambios = false;
//		}

		return booHayCambios;
	}
}
