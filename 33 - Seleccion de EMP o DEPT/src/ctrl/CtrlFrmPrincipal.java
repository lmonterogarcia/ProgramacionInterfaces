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
		getTables();

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

	public static void getTables() {
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		String sConsulta = "SELECT TABLE_NAME FROM USER_TABLES ORDER BY 1";

			try {
				listModel = logic.LogConsultas.consultaTablas(sConsulta);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//		listModel.add(0, e.getMessage());
		view.FrmPrincipal.lstTablas.setModel(listModel);
	}

	public static void filaSeleccionada() {

		String sTabla = view.FrmPrincipal.lstTablas.getSelectedValue();

		ejecutarConslta("SELECT * FROM " + sTabla, view.FrmPrincipal.tblDatos);

	}

	public static void ejecutarConslta(String sConsulta, JTable tabla) {

		DefaultTableModel tableModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		try {

			tableModel = logic.LogConsultas.consulta(sConsulta);

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			tableModel.addColumn(e.getMessage());
			e.printStackTrace();
		}

		tabla.setModel(tableModel);

	}
}
