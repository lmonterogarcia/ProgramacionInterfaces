package unico;
import java.awt.Frame;
public class Principal {

	public static void main(String[] args) {
		
		test1();
		test2();
		
		
	}
	
	private static void test1() {
		crearVentana("Primera", 400, 500);
		crearVentana("Segunda", 400, 500);
		crearVentana("Tercera", 400, 500);
	}
	
	private static void test2() {
		MiVentana v = new MiVentana();
	}
	
	private static void crearVentana(String sTitulo, int iAncho, int iAlto) {
		
		Frame ventana = new Frame(sTitulo);
		ventana.setBounds(100,100,iAncho,iAlto);
		ventana.setVisible(true);
		
		}
}
