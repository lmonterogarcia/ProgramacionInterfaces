package unico;
import java.awt.*;
public class MiVentana extends java.awt.Frame {

	public MiVentana() {
		
		Color fondoVentana = Color.blue;
		Color fondoError = Color.red;
		Color fondoNormal = Color.gray;
		Color ejemplo = new Color (255,255,255);
		
		setTitle("Ejemplo");
//		setBounds(100,100,600,400);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int iAncho = 600, iAlto = 400, x = ((screenSize.width - iAncho) / 2),y = ((screenSize.height - iAlto) / 2); 
		
		setBounds(x,y,600,400);
		setVisible(true);
		setBackground(fondoVentana);

	}

}
