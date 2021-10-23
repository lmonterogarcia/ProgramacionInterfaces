package ctrl;

public class CtrlColores {

	public static void cambiarColorfuente(int iPosicion) {
		if (view.FrmColores.aBtnFuente.get(iPosicion).getBackground() 
				!= view.FrmColores.lblTextoPrueba.getBackground()) {
			
			view.FrmColores.lblTextoPrueba.setForeground(
					view.FrmColores.aBtnFuente.get(iPosicion).getBackground());
			
		}

	}

	public static void cambiarColorFondo(int iPosicion) {
		if (view.FrmColores.aBtnFondo.get(iPosicion).getBackground() 
				!= view.FrmColores.lblTextoPrueba.getForeground()) {
			
			view.FrmColores.lblTextoPrueba.setBackground(
					view.FrmColores.aBtnFondo.get(iPosicion).getBackground());
			
		}

	}

	public static void aceptar() {
		
		view.FrmPrincipal.textArea.setForeground(view.FrmColores.lblTextoPrueba.getForeground());
		view.FrmPrincipal.textArea.setBackground(view.FrmColores.lblTextoPrueba.getBackground());

	}

	public static void guardarDef() {
		ctrl.CtrlPrincipal.guardarConfiguracion();
	}

}
