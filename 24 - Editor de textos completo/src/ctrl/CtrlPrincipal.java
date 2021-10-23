package ctrl;

import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.ConfiguracionDefecto;

public class CtrlPrincipal {

	private static String sRuta = "";
	private final static String sRutaConfiguracion = "configuracion.db";
	public static ConfiguracionDefecto confDefecto = new ConfiguracionDefecto();

	public static void iniciar() {
		leerConfiguracion();
		new view.FrmPrincipal();
	}

	public static void nuevo() {
		if (hayCambios()) {
			int iOpcion = JOptionPane.showConfirmDialog(null, "Quieres guardar los cambios?", "Gestor de Guardado",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (iOpcion == JOptionPane.YES_OPTION) {
				guardar();
				sRuta = "";
				view.FrmPrincipal.textArea.setText("");
			} else if (iOpcion == JOptionPane.NO_OPTION) {
				sRuta = "";
				view.FrmPrincipal.textArea.setText("");
			}
		} else {
			sRuta = "";
			view.FrmPrincipal.textArea.setText("");
		}
	}

	public static void abrir() {
		sRuta = leerRuta();
		try {
			RandomAccessFile fichero = new RandomAccessFile(sRuta, "rw");
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

		if (hayCambios()) {
			int iOpcion = JOptionPane.showConfirmDialog(null, "Quieres guardar los cambios?", "Gestor de Guardado",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (iOpcion == JOptionPane.YES_OPTION) {
				guardar();
				exit();
			} else if (iOpcion == JOptionPane.NO_OPTION) {
				exit();
			}
		} else {
			exit();
		}
	}
	
	private static void exit() {
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
			RandomAccessFile fichero = new RandomAccessFile(sRuta, "rw");
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
		boolean booHayCambios =  false;

		if (sRuta.equals("")) {
			if (!view.FrmPrincipal.textArea.getText().equals("")) {
				booHayCambios = true;
			} else {
				booHayCambios = false;
			}
			
		} else {
			try {
				RandomAccessFile fichero = new RandomAccessFile(sRuta, "r");
				if (!view.FrmPrincipal.textArea.getText().equals(leerTexto(fichero))) {
					booHayCambios = true;
				} else {
					booHayCambios = false;
				}
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

		return booHayCambios;
	}
	
	private static void leerConfiguracion() {
		
		try {
			ObjectInputStream br = new ObjectInputStream(new FileInputStream(sRutaConfiguracion));
			
			Object obj = br.readObject();
			
			if (obj instanceof ConfiguracionDefecto) {
				confDefecto = (ConfiguracionDefecto) obj;
			} else {
				confDefecto = new ConfiguracionDefecto();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
			e.printStackTrace();
		} catch (IOException e){
			System.err.println("Se ha producido un error al acceder al fichero");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error no clasificado");
			e.printStackTrace();
		}
	}
	
	public static void guardarConfiguracion() {
		
		confDefecto.setFntPredemeditada(ctrl.CtrlFuente.nuevaFuente);
		confDefecto.setClrFuente(null);
		confDefecto.setClrFondo(null);
		
		try {
			ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(sRutaConfiguracion));
			
			bw.writeObject(confDefecto);
			
			bw.close();
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
			e.printStackTrace();
		} catch (IOException e){
			System.err.println("Se ha producido un error al acceder al fichero");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Ha ocurrido un error no clasificado");
			e.printStackTrace();
		}
		
		
	}
}
