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

	public static DefaultTableModel consulta(String sConsulta)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ResultSet resultado;

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

			for (int i = 0; i < iColumnas; i++) {
				aFila[i] = resultado.getString(i + 1);
			}
			tableModel.addRow(aFila);
		}
		dbms.CtrlGestConOracle.closeConn();

		return tableModel;
	}

	public static DefaultListModel<String> consultaTablas(String sConsulta) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ResultSet resultado;

		dbms.CtrlGestConOracle.openConn();
		Statement miOrden = dbms.CtrlGestConOracle.getConn().createStatement();
		miOrden.execute(sConsulta);
		resultado = miOrden.getResultSet();
		DefaultListModel<String> listModel = new DefaultListModel<String> ();
		ArrayList<String> aTablas = new ArrayList<String>();

		while (resultado.next()) {

			aTablas.add(resultado.getString(1));
		}
		
		listModel.addAll(aTablas);
		dbms.CtrlGestConOracle.closeConn();

		return listModel;
	}

	public static ArrayList<Chaleco> getListado() throws Exception {
		ArrayList<Chaleco> aListadoDept = new ArrayList<Chaleco>();

		dbms.CtrlGestConOracle.openConn();

		Statement miOrden = dbms.CtrlGestConOracle.getConn().createStatement();
		miOrden.execute("SELECT DEPTNO, DNAME, LOC FROM DEPT ORDER BY 1");

		ResultSet resultado = miOrden.getResultSet();

		ResultSetMetaData info = resultado.getMetaData();
		int iNumCampos = info.getColumnCount();

//			for (int i = 1; i <= iNumCampos; i++) {
//				System.out.print(info.getColumnName(i) + "\t\t");
//			}

		while (resultado.next()) {
//				System.out.println();
//				for (int i = 1; i <= iNumCampos; i++) {
//					System.out.print(resultado.getString(i) + "\t\t");
//				}
			Chaleco oDept = new Chaleco(resultado.getString("DEPTNO"), resultado.getString("DNAME"),
					resultado.getString("LOC"));
			aListadoDept.add(oDept);

//				System.out.println("Nombre: " + resultado.getString("ENAME"));
//				System.out.println("Salario: " + resultado.getInt("SAL"));
		}

		dbms.CtrlGestConOracle.closeConn();

		return aListadoDept;
	}

	public static void cambiarLocalidad(String sLocalidad, Integer iNumDept) throws Exception {

		dbms.CtrlGestConOracle.openConn();

		String sql = "{call CAMBIAR_DEPT_LOC(?,?)}";

		CallableStatement orden = dbms.CtrlGestConOracle.getConn().prepareCall(sql);

		orden.setString(1, sLocalidad);
		orden.setInt(2, iNumDept);

		orden.execute();

		dbms.CtrlGestConOracle.closeConn();

	}

	public static int getTotalEmpleados(int iDepartamento)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		int iTotal = 0;

		dbms.CtrlGestConOracle.openConn();

		String sql = "{ ? = call TOTAL_EMPS(?)}";

		CallableStatement orden = dbms.CtrlGestConOracle.getConn().prepareCall(sql);

		orden.registerOutParameter(1, Types.NUMERIC);
		orden.setInt(2, iDepartamento);

		orden.execute();

		iTotal = orden.getInt(1);

		dbms.CtrlGestConOracle.closeConn();

		return iTotal;
	}

	public static ArrayList<Chaleco> getDepts()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		ArrayList<Chaleco> listadoDepartamentos = new ArrayList<Chaleco>();

		dbms.CtrlGestConOracle.openConn();

		String sql = "{ ? = call GET_DEPT()}";

		CallableStatement orden = dbms.CtrlGestConOracle.getConn().prepareCall(sql);

		orden.registerOutParameter(1, OracleTypes.CURSOR);

		orden.execute();

		ResultSet resultado = (ResultSet) orden.getObject(1);
		while (resultado.next()) {
			listadoDepartamentos.add(new Chaleco(Integer.toString(resultado.getInt("DEPTNO")),
					resultado.getString("DNAME"), resultado.getString("LOC")));
		}

		dbms.CtrlGestConOracle.closeConn();

		return listadoDepartamentos;
	}

}
