package ctrl;

public class CtrlDlgTest {

	
	public static String testConection() {
		
		String sMensaje;
		
		if (dbms.CtrlGestConOracle.testDbOracle()) {
			sMensaje = "Se puede establecer conexion con la base de datos";
		} else {
			sMensaje = "No se puede establecer conexion con la base de datos";
		}
		
		return sMensaje;
	}
}
