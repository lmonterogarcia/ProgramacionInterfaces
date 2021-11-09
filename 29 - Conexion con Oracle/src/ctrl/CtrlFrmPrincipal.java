package ctrl;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CtrlFrmPrincipal {

	
	public static void inicio() {
		
		ctrl.CtrlGestConOracle.readConnectionObject();
		new view.FrmPrincipal();

	}
	
	public static void salir() {

		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null, "Desea salir?", "Asistente de salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (iOpcSeleccionada == JOptionPane.YES_OPTION) {
			ctrl.CtrlGestConOracle.saveConnectionObject();
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} else if (iOpcSeleccionada == JOptionPane.NO_OPTION) {
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		}

	}

	public static void menuConexion() {
		
		new view.DlgConexion();

	}

	public static void menuLogin() {
		
		new view.DlgLogin();

	}

	public static void menuTest() {
		
		new view.DlgText();

	}
}
