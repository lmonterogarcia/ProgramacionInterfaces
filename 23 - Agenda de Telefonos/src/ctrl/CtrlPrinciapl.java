package ctrl;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Persona;

public class CtrlPrinciapl {

	private static ArrayList<Persona> aPersonas;
	private static File fch;

	public static void inicio() {

		new view.FrmPrincipal();
	}

	public static void abrirAgenda() {
		fch = new File(leerRuta());
		aPersonas = leerAgenda(fch);
		mostarNombres();

	}

	private static void mostarNombres() {
		for (int i = 0;i < aPersonas.size(); i++) {
			view.FrmPrincipal.sModel.addElement(aPersonas.get(i).getsNombre());
		}
	}

	private static ArrayList<Persona> leerAgenda(File fchAgenda) {
		ArrayList<Persona> aPersonas = new ArrayList<Persona>();

		try {

			BufferedReader bufLectura =  new BufferedReader(new FileReader(fchAgenda));

			String sLinea = bufLectura.readLine();

			while(sLinea != null) {
				//Procesamos el fichero

				StringTokenizer stLinea = new StringTokenizer(sLinea,"#");
				String sNombre = stLinea.nextToken();
				String sNumTel = stLinea.nextToken();
				aPersonas.add(new Persona(sNombre, sNumTel));

				//Leemos siguiente linea
				sLinea = bufLectura.readLine();

			}

			bufLectura.close();
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
		} catch (IOException ioe){
			System.err.println("Se ha producido un error al acceder al fichero");
		} catch (Exception eiu) {
			System.err.println("Ha ocurrido un error no clasificado");
			System.err.println(eiu);
		}
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

		boolean booPrimera = true;

		view.FrmPrincipal.btnGuardar.setVisible(false);
		view.FrmPrincipal.txtNombre.setVisible(false);
		view.FrmPrincipal.txtNumTel.setVisible(false);

		try {

			BufferedWriter buffWriter = new BufferedWriter(new FileWriter(fch));
			final String sSeparador = "#";

			for (Persona persona : aPersonas) {
				if (booPrimera) {
					booPrimera = !booPrimera;
				} else {
					buffWriter.newLine();
				}

				buffWriter.write(persona.getsNombre() +  sSeparador + persona.getsNumTel());	
			}

			buffWriter.flush();
			buffWriter.close();
			JOptionPane.showInternalMessageDialog(null, "La agenda se ha guardado correctamente");
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (IOException ioe){
			System.out.println("Se ha producido un error al acceder al fichero");
		}
	}

	public static void editar() {
		String sNumTel = aPersonas.get(view.FrmPrincipal.lstAgenda.getSelectedIndex()).getsNumTel();
		String sNombre = aPersonas.get(view.FrmPrincipal.lstAgenda.getSelectedIndex()).getsNombre();		

		view.FrmPrincipal.btnGuardar.setVisible(true);
		view.FrmPrincipal.txtNombre.setText(sNombre);
		view.FrmPrincipal.txtNombre.setVisible(true);
		view.FrmPrincipal.txtNumTel.setVisible(true);
		view.FrmPrincipal.txtNumTel.setText(sNumTel);
	}

	public static void guardar() {
		int iPosicion = view.FrmPrincipal.lstAgenda.getSelectedIndex();
		view.FrmPrincipal.btnGuardarAgenda.setEnabled(true);
		String sNumTel = view.FrmPrincipal.txtNumTel.getText();
		String sNombre = view.FrmPrincipal.txtNombre.getText();
		Persona aPersona = new Persona(sNombre.trim(),sNumTel.trim());
		aPersonas.set(iPosicion, aPersona);
		view.FrmPrincipal.sModel.setElementAt(sNombre, iPosicion);
		mostarNumero();
		view.FrmPrincipal.btnGuardar.setVisible(false);
		view.FrmPrincipal.txtNombre.setVisible(false);
		view.FrmPrincipal.txtNumTel.setVisible(false);

	}

	public static void mostarNumero() {
		String sNumTel = aPersonas.get(view.FrmPrincipal.lstAgenda.getSelectedIndex()).getsNumTel();
		view.FrmPrincipal.lblNumTel.setText(sNumTel);
	}

	public static void salir() {
		
		if (view.FrmPrincipal.btnGuardarAgenda.isEnabled()) {
			int iOpcSeleccionada = JOptionPane.showConfirmDialog(null,"Desea guardar los cambios antes de salir?", "Asistente de salida", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (iOpcSeleccionada == JOptionPane.YES_OPTION) {
				
				guardarAgenda();
				view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			} else {
				view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		} else {
			System.exit(0);
		}
		
		
	}

}
