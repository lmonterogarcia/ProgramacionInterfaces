package ctrl;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CtrlPrincipal {
	
	ImageIcon iiAjo = new ImageIcon("archivos/ajo.png");
	ImageIcon iiAtaud = new ImageIcon("archivos/ataud.png");
	ImageIcon iiCalabaza = new ImageIcon("archivos/calabaza.png");
	ImageIcon iiCrucifijo = new ImageIcon("archivos/crucifijo.png");
	ImageIcon iiDracula = new ImageIcon("archivos/dracula.png");
	ImageIcon iiMurcielago = new ImageIcon("archivos/murcielago.png");
	ImageIcon iiSol = new ImageIcon("archivos/sol.png");

	public static void inicio() {
		
		new view.FrmPrincipal();
		
	}
	
	public static void salir() {

		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null, "Realmente desea salir?", "Asistente de salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (iOpcSeleccionada == JOptionPane.YES_OPTION) {

			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} else if (iOpcSeleccionada == JOptionPane.NO_OPTION) {
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		}

	}
	
}
