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
		setLayout(null);
		setVisible(true);
		
		crearComponente();
	}

	private void crearComponente() {

		//		Button btnAceptar = new Button();
		//		btnAceptar.setLabel("ACEPTAR");

		//		Button btnAceptar = new Button("Aceptar");
		//		btnAceptar.setBounds(50,50,80,40);
		//		Button btnCancelar = new Button ("Cancelar");
		//		btnCancelar.setBounds(135,50,80,40);
		//		
		//Agregar boton al Frame

		//		add(btnAceptar);
		//		add(btnCancelar);

		Button btnSevilla = new Button("SEVILLA");
		btnSevilla.setBounds(10,35,50,20);
		Button btnNo = new Button("NO");
		btnNo.setBounds(65,35,20,20);
		Button btnSi = new Button("SI");
		btnSi.setBounds(10,60,20,20);
		Button btnAndalucia = new Button("ANDALUCIA");
		btnAndalucia.setBounds(35,60,80,20);

		add(btnSevilla);
		add(btnNo);
		add(btnSi);
		add(btnAndalucia);

		//Agregar Texto LABEL al Frame

		//		Label lblUsuario = new Label();
		//		lblUsuario.setText("Usuario");

		Label lblUsuario = new Label("Usuario:");
		lblUsuario.setBounds(10,90,54,20);
		lblUsuario.setForeground(CLR_FG_USUARIO);
		lblUsuario.setFont(FNT_LBL_RESALTADO);
		//lblUsuario.setBackground(Color.yellow);

		Label lblPassword = new Label("Password:");
		lblPassword.setBounds(10,115,65,20);
		lblPassword.setForeground(CLR_FG_PASSWORD);
		lblPassword.setFont(FNT_LBL_NORMAL);
		//lblPassword.setBackground(Color.yellow);

		add(lblUsuario);
		add(lblPassword);
		
		
		//Agregar Cuadro de texto al Frame
		
//		TextField txtCuadroTexto = new TextField();
//		TextField txtCuadroTexto = new TextField(8);
		
		TextField txtCuadroTexto = new TextField("Medac" , 8);
		
		txtCuadroTexto.setBounds(10,150,150,90);
		
		add(txtCuadroTexto);
		


	}

}
