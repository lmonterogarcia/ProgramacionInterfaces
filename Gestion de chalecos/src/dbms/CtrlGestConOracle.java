package dbms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import model.ConectionInfo;

public class CtrlGestConOracle {

	private static Connection conn;
	private static ConectionInfo connInfo;

	public static Connection getConn() {
		return conn;
	}

	public static ConectionInfo getConnInfon() {
		return connInfo;
	}

	public static void closeConn() throws SQLException {
		conn.close();
	}

	public static void openConn()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

//		leerConectionInfoMap();

		String dbHOST = connInfo.getDbHOST();
		String dbPORT = connInfo.getDbPORT();
		String dbSID = connInfo.getDbSID();
		String dbUSER = connInfo.getDbUSER();
		String dbPASSWORD = connInfo.getDbPASSWORD();

		String dbURL = "jdbc:oracle:thin:@" + dbHOST + ":" + dbPORT + ":" + dbSID;

		// Cargar el river en memoria
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Establecemos la conexion
		conn = DriverManager.getConnection(dbURL, dbUSER, dbPASSWORD);
	}

	public static void saveConnectionObject() {
		String fch = "oracleconnection.dat";
		try {

			ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream(fch));
			buff.writeObject(connInfo);
			buff.close();

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fch + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede escribir en el fichero.");
		}
	}

	public static void readConnectionObject() {
		String fch = "oracleconnection.dat";
		try {

			ObjectInputStream buff = new ObjectInputStream(new FileInputStream(fch));
			connInfo = (ConectionInfo) buff.readObject();
			buff.close();

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fch + " no existe.");
		} catch (IOException e) {
			System.err.println("ERROR: No se puede leer del fichero.");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: El fichero no contiene un coche");
		}
	}
}
