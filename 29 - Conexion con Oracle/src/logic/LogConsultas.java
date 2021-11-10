package logic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LogConsultas {

	public static String getListado() throws Exception{
		String sResultadoConsulta = "";

		
			dbms.CtrlGestConOracle.openConn();

			Statement miOrden = dbms.CtrlGestConOracle.getConn().createStatement();
			miOrden.execute("SELECT DEPTNO, DNAME, LOC FROM DEPT ORDER BY 1");

			ResultSet resultado = miOrden.getResultSet();

			ResultSetMetaData info = resultado.getMetaData();
//			int iNumCampos = info.getColumnCount();

//			for (int i = 1; i <= iNumCampos; i++) {
//				System.out.print(info.getColumnName(i) + "\t\t");
//			}

//			while (resultado.next()) {
//				System.out.println();
//				for (int i = 1; i <= iNumCampos; i++) {
//					System.out.print(resultado.getString(i) + "\t\t");
//				}
//				Dept oDept = new Dept(resultado.getString("DEPTNO"), resultado.getString("DNAME"), resultado.getString("LOC"));
//				aListadoDept.add(oDept);

//				System.out.println("Nombre: " + resultado.getString("ENAME"));
//				System.out.println("Salario: " + resultado.getInt("SAL"));
			
			return sResultadoConsulta = info;
			
			dbms.CtrlGestConOracle.closeConn();
			return sResultadoConsulta;
			}

}
