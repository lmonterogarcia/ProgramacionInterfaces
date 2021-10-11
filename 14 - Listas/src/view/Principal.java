package view;

import java.awt.*;
import java.awt.event.*;

public class Principal extends java.awt.Frame{

	//Colores
		final Color CLR_BG_FONDO = new Color(200,200,200);
		final Color CLR_FG_USUARIO = Color.red;
		final Color CLR_FG_PASSWORD = Color.orange;

		//Fuentes
		final Font FNT_LBL_NORMAL = new Font("Arial" , Font.PLAIN , 12);
		final Font FNT_LBL_TITULO = new Font("Arial" , Font.PLAIN , 16);
		final Font FNT_LBL_RESALTADO = new Font("Arial" , Font.BOLD , 12);
		
	public static void main(String[] args) {
		Principal miApp = new Principal();
		
		miApp.crearCrearVentana();

	}

	private void crearCrearVentana() {
		
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
			}
		);
		
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		setTitle("Ficha de alumno");
		setBounds(100,100,300,300);
		setBackground(CLR_BG_FONDO);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		
		crearComponente();
		
	}

	private void crearComponente() {
		
		
		// LISTAS
		List lstCiudades = new List();
		
		lstCiudades.add("Sevilla");
		lstCiudades.add("Cordoba");
		lstCiudades.add("Huelva");
		lstCiudades.add("Cadiz");
		lstCiudades.add("Malaga");
		lstCiudades.add("Granada");
		
		lstCiudades.setBounds(50,50,80,100);
		
//		lstCiudades.addItemListener( new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				System.out.println(lstCiudades.getSelectedItem());
//			}
//		});
		
		lstCiudades.addItemListener (e -> {
			System.out.println(lstCiudades.getSelectedItem());
		});
		
		//LISTAS desplegables
		
		Choice chcCursos = new Choice();
		
		chcCursos.add("DAM");
		chcCursos.add("DAW");
		chcCursos.add("ASIR");
		chcCursos.add("GAME3D");
		
		chcCursos.setBounds(50,160,80,30);
		
		chcCursos.addItemListener( e->{
			System.out.println(chcCursos.getSelectedItem());
		});
		
		//Aniadiar al FRAME
		add(lstCiudades);
		add(chcCursos);
		
		
		
		
	}

}
