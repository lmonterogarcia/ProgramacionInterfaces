package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmColores extends javax.swing.JDialog {

	final String[] A_STR_COLORES = {"Rojo", "Amarillo", "Blanco","Verde","Azul","Gris"}; 
	final Color[] A_CLR_COLORES = {Color.red,Color.yellow,Color.white,Color.green,Color.blue,Color.gray};

	final Font FNT_LBL_NORMAL = new Font ("Arial", Font.PLAIN, 12);
	final Font FNT_LBL_TITULO = new Font ("Arial", Font.BOLD, 16);
	
	public FrmColores() {
		setTitle("Colores");
		setModal(true);
		setBounds(1400,100,255,255);
		setLayout(null);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {
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
