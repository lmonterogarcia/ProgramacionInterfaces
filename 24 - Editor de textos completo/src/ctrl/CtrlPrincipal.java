package ctrl;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CtrlPrincipal {

	public static void iniciar() {
		new view.FrmPrincipal();
	}

	public static void nuevo() {

	}

	public static void abrir() {

	}

	public static void guardar() {

	}

	public static void guardarComo() {

	}

	public static void salir() {
		
			int iOpcSeleccionada = JOptionPane.showConfirmDialog(null,
					"Desea salir?", "Asistente de salida",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (iOpcSeleccionada == JOptionPane.YES_OPTION) {
				System.exit(0);
			} else  {
				view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			} 
		
	}
}
