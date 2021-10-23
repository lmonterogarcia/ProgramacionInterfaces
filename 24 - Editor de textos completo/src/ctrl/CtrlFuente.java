package ctrl;

import java.awt.*;

import model.ConfiguracionDefecto;

public class CtrlFuente {

	public static Font nuevaFuente;
	
	public static void iniciarFuente() {
		
		new view.FrmFuentes();
	}
	
	public static void aceptar() {
		view.FrmPrincipal.textArea.setFont(nuevaFuente);

	}

	public static void guardarDef() {
		ctrl.CtrlPrincipal.guardarConfiguracion();

	}

	public static int definirEstilo() {
		int iEstilo;
		if (view.FrmFuentes.rdbtnNormal.isSelected()) {
			iEstilo = Font.PLAIN;
		} else if (view.FrmFuentes.rdbtnNegrita.isSelected()) {
			iEstilo = Font.BOLD;
		} else {
			iEstilo = Font.ITALIC;
		}
		
		return iEstilo;

	}

	public static void fuenteElegida() {
		int iFuente = view.FrmFuentes.lstFuente.getSelectedIndex();
		int iTamanio = view.FrmFuentes.lstTamanio.getSelectedIndex();
		int iEstilo = definirEstilo();
		nuevaFuente = new Font (view.FrmFuentes.aFuente[iFuente],iEstilo,Integer.parseInt(view.FrmFuentes.aTamanio[iTamanio]));
		view.FrmFuentes.lblTextoPrueba.setFont(nuevaFuente);
	}


}
