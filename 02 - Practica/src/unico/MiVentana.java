package unico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

public class MiVentana extends java.awt.Frame {

	//Colores
	
	final Color CLR_BG_FONDO = new Color(100,100,100);
	final Color CLR_BG_Resaltado = Color.red;
	
	//Typofgrafias
	
	final Font FNT_LBL_NORMAL = new Font("Arial" , Font.PLAIN , 12);
	final Font FNT_LBL_TITULO = new Font("Arial" , Font.PLAIN , 16); 
	
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
		
		setTitle("Login de Usuario");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int iAncho = 300, iAlto = 200, x = ((screenSize.width - iAncho) / 2),y = ((screenSize.height - iAlto) / 2); 
		
		setBounds(x,y,iAncho,iAlto);
		setBackground(CLR_BG_FONDO);
		setLayout(null);
		setVisible(true);
		
		crearComponentes();
		
	}

	private void crearComponentes() {
		
		//Button
		Button btnAceptar = new Button("ACEPTAR");
		btnAceptar.setBounds(100,135,100,30);
		
		add(btnAceptar);
		
		//Labels
		Label lblUsuario = new Label("USUARIO:");
		lblUsuario.setBounds(30,66,66,20);
		lblUsuario.setFont(FNT_LBL_NORMAL);
		
		add(lblUsuario);
		
		Label lblPassword = new Label("PASSWORD:");
		lblPassword.setBounds(30,90,70,20);
		lblPassword.setFont(FNT_LBL_NORMAL);
		
		add(lblPassword);
		
		//TextFild
		
		TextField txtUsuario = new TextField();
		txtUsuario.setBounds(120,66,150,20);
		
		add(txtUsuario);
		
		TextField txtPassword = new TextField();
		txtPassword.setBounds(120,90,150,20);
		
		add(txtPassword);
	}

}
