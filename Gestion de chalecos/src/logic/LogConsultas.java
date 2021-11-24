package logic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import model.Chaleco;
import oracle.jdbc.internal.OracleTypes;

public class LogConsultas {

	public static DefaultTableModel getListadoChalecos()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ResultSet resultado;
		String sConsulta = "SELECT * FROM CHALECO ORDER BY 1";

		dbms.CtrlGestConOracle.openConn();
		Statement miOrden = dbms.CtrlGestConOracle.getConn().createStatement();
		miOrden.execute(sConsulta);
		resultado = miOrden.getResultSet();
		DefaultTableModel tableModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		ResultSetMetaData info = resultado.getMetaData();
		int iColumnas = info.getColumnCount();
		String[] aFila = new String[iColumnas];

		for (int i = 0; i < iColumnas; i++) {
			tableModel.addColumn(info.getColumnName(i + 1));
		}

		while (resultado.next()) {
			int prueba;
			for (int i = 0; i < iColumnas; i++) {

				if (i == 2) {
					aFila[i] = model.IChaleco.sColor[resultado.getInt(i + 1)];
				} else if (i == 3) {
					aFila[i] = model.IChaleco.sTalla[resultado.getInt(i + 1)];
				} else {
					aFila[i] = resultado.getString(i + 1);
				}
			}
			tableModel.addRow(aFila);
		}
		dbms.CtrlGestConOracle.closeConn();

		return tableModel;
	}

	public static DefaultListModel<String> consultaTablas(String sConsulta)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ResultSet resultado;

		dbms.CtrlGestConOracle.openConn();
		Statement miOrden = dbms.CtrlGestConOracle.getConn().createStatement();
		miOrden.execute(sConsulta);
		resultado = miOrden.getResultSet();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		ArrayList<String> aTablas = new ArrayList<String>();

		while (resultado.next()) {

			aTablas.add(resultado.getString(1));
		}

		listModel.addAll(aTablas);
		dbms.CtrlGestConOracle.closeConn();

		return listModel;
	}

	public static void insertar(Chaleco oChaleco) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		dbms.CtrlGestConOracle.openConn();

		
		String sModelo = oChaleco.getsModelo();
		int iColor = oChaleco.getiColor();
		int iTalla = oChaleco.getiTalla();
		double dPrecio = oChaleco.getdPrecio();
		int iStock = oChaleco.getiStock();
		
		// INSERT INTO LUIS.CHALECO (MODELO,COLOR,TALLA,PRECIO,STOCK)
		// VALUES ('Verano2',2,3,123.87,123);
		Statement miOrden = dbms.CtrlGestConOracle.getConn().createStatement();
		miOrden.execute("INSERT INTO CHALECO (ID_CHALECO, MODELO, COLOR, TALLA, PRECIO, STOCK) VALUES (SEQ_CHALECO.nextval,'" + sModelo
				+ "', " + iColor + ", " + iTalla + ", " + dPrecio + ", " + iStock + ");");

		dbms.CtrlGestConOracle.closeConn();

	}

	public static void modificar(Chaleco modificarChaleco) {
		// TODO Auto-generated method stub

	}

	public static void borrar(int iIdChaleco)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		dbms.CtrlGestConOracle.openConn();

		Statement miOrden = dbms.CtrlGestConOracle.getConn().createStatement();
		miOrden.execute("DELETE FROM CHALECO WHERE ID_CHALECO =  " + iIdChaleco);
		miOrden.execute("COMMIT");

		dbms.CtrlGestConOracle.closeConn();

	}

}
