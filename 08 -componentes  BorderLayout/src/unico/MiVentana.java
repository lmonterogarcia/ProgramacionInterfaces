package unico;

import java.awt.*;
import java.awt.event.*;


public class MiVentana extends java.awt.Frame {

	//Colores
	final Color CLR_BG_FONDO = new Color(250,250,250);
	final Color CLR_FG_USUARIO = Color.red;
	final Color CLR_FG_PASSWORD = Color.orange;

	//Fuentes
	final Font FNT_LBL_NORMAL = new Font("Arial" , Font.PLAIN , 12);
	final Font FNT_LBL_TITULO = new Font("Arial" , Font.PLAIN , 16);
	final Font FNT_LBL_RESALTADO = new Font("Arial" , Font.BOLD , 12);


	public static void main(String[] args) {
		MiVentana miApp = new MiVentana();
		miApp.crearVentana();
	}

	private void crearVentana() {

		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		setTitle("Creando componentes");
		setBounds(100,100,600,400);
		setBackground(CLR_BG_FONDO);
		setLayout(new BorderLayout());
		
		crearComponente();
		
		setVisible(true);
	}

	private void crearComponente() {

		Button btn1 = new Button("BOTON 1");
		Button btn2 = new Button("BOTON 2");
		Button btn3 = new Button("BOTON 3");
		Button btn4 = new Button("BOTON 4");
		Button btn5 = new Button("BOTON 5");
		Button btn6 = new Button("BOTON 6");
		Button btn7 = new Button("BOTON 7");
		Label lblUsuario = new Label("Usuario:");
		

		add(btn1, BorderLayout.NORTH);
		add(btn2, BorderLayout.SOUTH);
		add(btn3, BorderLayout.EAST);
		add(btn4, BorderLayout.WEST);
		add(btn5, BorderLayout.CENTER);

	}

}
