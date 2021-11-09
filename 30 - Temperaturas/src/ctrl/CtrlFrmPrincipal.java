package ctrl;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CtrlFrmPrincipal {

	public static void inicio() {

		final String FILE_NAME = "PB.XML";
		GestFchXML fchXML = new GestFchXML(FILE_NAME);
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
	
	private static void downloadAemet(String sFecha, String fch) throws Exception{
		String sUrl = "http://www.aemet.es/es/api-eltiempo/temperaturas/" + sFecha + "/PB";
		
		File file = new File(fch);
		URLConnection conn = new URL(sUrl).openConnection();
		conn.connect();
	}

}
