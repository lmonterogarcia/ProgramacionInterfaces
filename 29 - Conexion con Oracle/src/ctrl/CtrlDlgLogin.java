package ctrl;

public class CtrlDlgLogin {


	public static void aceptar() {
		
		dbms.CtrlGestConOracle.getConnInfon().setDbUSER(view.DlgLogin.txtUsuario.getText());
		dbms.CtrlGestConOracle.getConnInfon().setDbPASSWORD(String.valueOf(view.DlgLogin.txtPassword.getPassword()));
		view.DlgLogin.ventana.dispose();
	}

	public static void cancelar() {
		view.DlgLogin.ventana.dispose();
	}

}
