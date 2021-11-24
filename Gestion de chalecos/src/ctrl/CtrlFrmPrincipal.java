package ctrl;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Chaleco;

public class CtrlFrmPrincipal {

	public static void inicio() {

		dbms.CtrlGestConOracle.readConnectionObject();
		new view.FrmPrincipal();
		actualizar();

	}

	public static void salir() {

		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null, "Desea salir?", "Asistente de salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (iOpcSeleccionada == JOptionPane.YES_OPTION) {
			dbms.CtrlGestConOracle.saveConnectionObject();
			System.exit(0);

		} else if (iOpcSeleccionada == JOptionPane.NO_OPTION) {
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		}

	}

	public static void menuDatabase() {

		new view.DlgDatabase();
	}

	public static void menuLogin() {

		new view.DlgLogin();

	}

	public static void actualizar() {
		try {

			view.FrmPrincipal.tblChalecos.setModel(logic.LogConsultas.getListadoChalecos());
			ocultarColumna(view.FrmPrincipal.tblChalecos, 0);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	private static void ocultarColumna(JTable tabla, int iColumna) {
		tabla.getColumnModel().getColumn(iColumna).setMinWidth(0);
		tabla.getColumnModel().getColumn(iColumna).setMaxWidth(0);
	}

	public static void menuNuevo() {
		new ctrl.CtrlDlgDetalleChaleco().detalleInicio(0, new Chaleco());
	}

	public static void menuEditar() {
		new ctrl.CtrlDlgDetalleChaleco().detalleInicio(1, crearChaleco(getFila()));
	}

	public static void menuBorrar() {
		try {
			logic.LogConsultas.borrar(Integer.parseInt(view.FrmPrincipal.tblChalecos.getValueAt(getFila(), 0).toString()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		actualizar();
	}

	public static void menuConsultar() {
		new ctrl.CtrlDlgDetalleChaleco().detalleInicio(2, crearChaleco(getFila()));
	}

	private static Chaleco crearChaleco(int iFila) {

		int iId = Integer.parseInt(view.FrmPrincipal.tblChalecos.getValueAt(iFila, 0).toString());
		String sModelo = view.FrmPrincipal.tblChalecos.getValueAt(iFila, 1).toString();
		int iColor = 0;
		switch (view.FrmPrincipal.tblChalecos.getValueAt(iFila, 1).toString()) {
		case "Rojo":
			iColor = 0;
			break;
		case "Verde":
			iColor = 1;
			break;
		case "Azul":
			iColor = 2;
			break;
		case "Amarillo":
			iColor = 3;
			break;
		}

		int iTalla = 0;
		switch (view.FrmPrincipal.tblChalecos.getValueAt(iFila, 1).toString()) {
		case "S":
			iTalla = 0;
			break;
		case "M":
			iTalla = 1;
			break;
		case "L":
			iTalla = 2;
			break;
		case "XL":
			iTalla = 3;
			break;
		}

		double dPrecio = Double.parseDouble(view.FrmPrincipal.tblChalecos.getValueAt(iFila, 4).toString());
		int iStock = Integer.parseInt(view.FrmPrincipal.tblChalecos.getValueAt(iFila, 5).toString());

		return new Chaleco(iId, sModelo, iColor, iTalla, dPrecio, iStock);

	}

	private static int getFila() {
		return view.FrmPrincipal.tblChalecos.getSelectedRow();
	}

}
