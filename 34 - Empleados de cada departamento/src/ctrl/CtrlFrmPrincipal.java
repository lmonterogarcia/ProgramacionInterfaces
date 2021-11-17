package ctrl;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class CtrlFrmPrincipal {

	private static ResultSet sResultadoConsulta;

	public static void inicio() {

		dbms.CtrlGestConOracle.readConnectionObject();
		new view.FrmPrincipal();
		getDepartamentos();

	}

	public static void salir() {

		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null, "Desea salir?", "Asistente de salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (iOpcSeleccionada == JOptionPane.YES_OPTION) {
			dbms.CtrlGestConOracle.saveConnectionObject();
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} else if (iOpcSeleccionada == JOptionPane.NO_OPTION) {
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		}

	}

	public static void menuConexion() {

		new view.DlgConexion();

	}

	public static void menuLogin() {

		new view.DlgLogin();

	}

	public static void menuTest() {

		new view.DlgText();

	}

	public static void getDepartamentos() {
		
		String sConsulta = "SELECT DEPTNO, DNAME AS DEPARTAMENTO, LOC AS LOCALIDAD FROM DEPT ORDER BY DNAME";
		ejecutarConsulta(sConsulta, view.FrmPrincipal.tblDepartamentos);

	}

	public static void departamentoSeleccionado() {

		int iFila = view.FrmPrincipal.tblDepartamentos.getSelectedRow();
		String sDeptNo = view.FrmPrincipal.tblDepartamentos.getValueAt(iFila, 0).toString();

		String sConsulta = "SELECT EMPNO AS ID, ENAME AS NOMBRE, JOB AS EMPLEO, SAL AS SALARIO FROM EMP E WHERE E.DEPTNO = " + sDeptNo;
		ejecutarConsulta(sConsulta, view.FrmPrincipal.tblEmpleados);

	}

	private static void ejecutarConsulta(String sConsulta, JTable tabla) {

		try {

			tabla.setModel(logic.LogConsultas.consultaParaTablas(sConsulta));
			ocultarColumna(tabla, 0);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}
	
	private static void ocultarColumna(JTable tabla, int iColumna) {
		tabla.getColumnModel().getColumn(iColumna).setMinWidth(0);
		tabla.getColumnModel().getColumn(iColumna).setMaxWidth(0);
	}
	
	public static void empleadoSeleccionado() {
		int iFila = view.FrmPrincipal.tblEmpleados.getSelectedRow();
		String sEmpNo = view.FrmPrincipal.tblEmpleados.getValueAt(iFila, 0).toString();
		CtrlDlgEmpleadoDetalle.inicio(sEmpNo);

	}

}
