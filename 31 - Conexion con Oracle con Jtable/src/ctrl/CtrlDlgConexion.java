package ctrl;

public class CtrlDlgConexion {

	public static void aceptar() {
		
		dbms.CtrlGestConOracle.getConnInfon().setDbHOST(view.DlgConexion.txtHost.getText());
		dbms.CtrlGestConOracle.getConnInfon().setDbPORT(view.DlgConexion.txtPuerto.getText());
		dbms.CtrlGestConOracle.getConnInfon().setDbSID(view.DlgConexion.txtNombre.getText());
		
		view.DlgConexion.ventana.dispose();
		
	}

	public static void cancelar() {
		
		view.DlgConexion.ventana.dispose();
	}

}
