package unico;

import java.awt.*;
import java.awt.event.*;


public class MiVentana extends java.awt.Frame {

	//Colores
	final Color CLR_BG_FONDO = new Color(100,100,100);
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

		setTitle("Login");
		setBounds(100,100,200,170);
		setBackground(CLR_BG_FONDO);
		setLayout(new FlowLayout());
		setResizable(false);
		setVisible(true);
		
		crearComponente();
	}

	private void crearComponente() {

		TextField txtUsurio = new TextField(8);
		Label lblUsuario = new Label("USUARIO");
		TextField txtPassword = new TextField(8);
		Label lblPassword = new Label("PASSWORD");
		Button btnAceptar = new Button("ACEPTAR");
		
		Panel panOperacionesUsuario = new Panel();
		panOperacionesUsuario.setLayout(new FlowLayout());
		
		Panel panOperacionesPassword = new Panel();
		panOperacionesPassword.setLayout(new FlowLayout());
		
		Panel panOperacionesAceptar = new Panel();
		panOperacionesAceptar.setLayout(new FlowLayout());

		//Agregar componentes al PanelUsuario
		panOperacionesUsuario.add(lblUsuario);
		panOperacionesUsuario.add(txtUsurio);
		
		
		
		//Agregar componentes al PanelPassword
		panOperacionesPassword.add(lblPassword);
		panOperacionesPassword.add(txtPassword);
		
		
		//Agregar componentes al PanelAceptar
		panOperacionesAceptar.add(btnAceptar);
		
		//Agregar componentes al Frame
		add(panOperacionesUsuario);
		add(panOperacionesPassword);
		add(panOperacionesAceptar);
	}

}
