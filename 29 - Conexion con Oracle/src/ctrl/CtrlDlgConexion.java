package ctrl;

public class CtrlDlgConexion {

	public static void aceptar() {
		
		ctrl.CtrlGestConOracle.getConnInfon().setDbHOST(view.DlgConexion.txtHost.getText());
		ctrl.CtrlGestConOracle.getConnInfon().setDbPORT(view.DlgConexion.txtPuerto.getText());
		ctrl.CtrlGestConOracle.getConnInfon().setDbSID(view.DlgConexion.txtNombre.getText());
		
		view.DlgConexion.ventana.dispose();
		
	}

	public static void cancelar() {
		
		view.DlgConexion.ventana.dispose();
	}

}
