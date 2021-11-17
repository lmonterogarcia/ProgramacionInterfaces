package ctrl;

import java.sql.SQLException;

public class CtrlDlgEmpleadoDetalle {

	private static String sEmpNo;
	
	public static void inicio(String ssEmpNo) {
		sEmpNo = ssEmpNo;
		new view.DlgEmpleadoDetalle();
	}

	public static void rellenarEmpleado() {
		
		String[] aEmpleado;
		try {
			aEmpleado = logic.LogConsultas.consultaDetalle(sEmpNo);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			aEmpleado= null;
			e.printStackTrace();
		};
		
		view.DlgEmpleadoDetalle.txtNombre.setText(aEmpleado[0]);
		view.DlgEmpleadoDetalle.txtOficio.setText(aEmpleado[1]);
		view.DlgEmpleadoDetalle.txtSalario.setText(aEmpleado[2]);
		view.DlgEmpleadoDetalle.txtComision.setText(aEmpleado[3]);
		view.DlgEmpleadoDetalle.txtFchAlta.setText(aEmpleado[4]);
		view.DlgEmpleadoDetalle.txtJefe.setText(aEmpleado[5]);

	}

}
