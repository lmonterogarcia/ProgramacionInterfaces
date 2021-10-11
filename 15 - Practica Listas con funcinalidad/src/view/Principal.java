package view;

import java.awt.*;
import java.awt.event.*;

public class Principal extends java.awt.Frame{

	final String[] A_STR_COLORES = {"Rojo", "Amarillo", "Blanco","Verde","Azul","Gris"}; 
	final Color[] A_CLR_COLORES = {Color.red,Color.yellow,Color.white,Color.green,Color.blue,Color.gray};

	final Font FNT_LBL_NORMAL = new Font ("Arial", Font.PLAIN, 12);
	final Font FNT_LBL_TITULO = new Font ("Arial", Font.BOLD, 16);

	public static void main(String[] args) {

		Principal miApp = new Principal();

		miApp.crearVentana();

	}

	private void crearVentana() {

		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						System.exit(0);
					}
				}
				);

		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		setTitle("Combinando Colores");
		setBounds(1400,100,255,255);
		setLayout(null);
		setResizable(false);

		crearComponente();

		setVisible(true);
	}

	private void crearComponente() {

		List lstColoresFondo = new List();
		lstColoresFondo.setBounds(25,50,90,120);
		for (String color : A_STR_COLORES) {
			lstColoresFondo.add(color);
		}


		List lstColoresLetras = new List();
		lstColoresLetras.setBounds(140,50,90,120);
		for (String color : A_STR_COLORES) {
			lstColoresLetras.add(color);
		}

		//lblResultado
		Label lblResultado = new Label ("Seleccione una combinacion", Label.CENTER);
		lblResultado.setBounds(5,205,245,30);
		lblResultado.setFont(FNT_LBL_TITULO);


		// EVENTOS

		lstColoresFondo.addItemListener(e ->{
			if (lblResultado.getForeground() != A_CLR_COLORES[lstColoresFondo.getSelectedIndex()]) {
				setBackground(A_CLR_COLORES[lstColoresFondo.getSelectedIndex()]);
				lblResultado.setBackground(A_CLR_COLORES[lstColoresFondo.getSelectedIndex()]);
			}
			
		});

		lstColoresLetras.addItemListener(e ->{
			if (getBackground() != A_CLR_COLORES[lstColoresLetras.getSelectedIndex()]) {
				lblResultado.setForeground(A_CLR_COLORES[lstColoresLetras.getSelectedIndex()]);
			}
			
		});

		//Aniadir al Frame

		add(lstColoresFondo);
		add(lstColoresLetras);
		add(lblResultado);

	}

}
