package ctrl;

public class CtrlDlgDatabase {

	public static void aceptar() {
		
		dbms.CtrlGestConOracle.getConnInfon().setDbHOST(view.DlgDatabase.txtHost.getText());
		dbms.CtrlGestConOracle.getConnInfon().setDbPORT(view.DlgDatabase.txtPuerto.getText());
		dbms.CtrlGestConOracle.getConnInfon().setDbSID(view.DlgDatabase.txtNombre.getText());
		
		view.DlgDatabase.ventana.dispose();
		
	}

	public static void cancelar() {
		
		view.DlgDatabase.ventana.dispose();
	}

}
