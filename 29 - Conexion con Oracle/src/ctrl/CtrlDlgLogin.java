package ctrl;

public class CtrlDlgLogin {


	public static void aceptar() {
		
		ctrl.CtrlGestConOracle.getConnInfon().setDbUSER(view.DlgLogin.txtUsuario.getText());
		ctrl.CtrlGestConOracle.getConnInfon().setDbPASSWORD(String.valueOf(view.DlgLogin.txtPassword.getPassword()));
		view.DlgLogin.ventana.dispose();
	}

	public static void cancelar() {
		view.DlgLogin.ventana.dispose();
	}

}
