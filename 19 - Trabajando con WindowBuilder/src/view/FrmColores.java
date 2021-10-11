package view;

import java.awt.*;
import javax.swing.*;

public class FrmColores extends JDialog {

	/**
	 * Launch the application.
	 */

	final String[] A_STR_COLORES = {"Rojo", "Amarillo", "Blanco","Verde","Azul","Gris"}; 
	final Color[] A_CLR_COLORES = {Color.red,Color.yellow,Color.white,Color.green,Color.blue,Color.gray};

	final Font FNT_LBL_NORMAL = new Font ("Arial", Font.PLAIN, 12);
	final Font FNT_LBL_TITULO = new Font ("Arial", Font.BOLD, 16);

	public static void main(String[] args) {
		try {
			FrmColores dialog = new FrmColores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmColores() {
		setTitle("Colores");
		setModal(true);
		setBounds(100,100,255,255);
		getContentPane().setLayout(null);
		setResizable(false);

		crearComponentes();

		setVisible(true);

	}

	private void crearComponentes() {

		// COMPONENTES SWING

		JList lstColoresFondo = new JList(A_STR_COLORES);
		lstColoresFondo.setBounds(26, 32, 90, 150);

		JList lstColoresLetras = new JList(A_STR_COLORES);
		lstColoresLetras.setBounds(140, 32, 90, 150);

		JLabel lblResultado = new JLabel ("Seleccione una combinacion");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(7, 188, 241, 30);
		lblResultado.setFont(FNT_LBL_TITULO);

		JLabel lblFondo = new JLabel("FONDO");
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(26, 4, 90, 16);

		JLabel lblLetras = new JLabel("LETRAS");
		lblLetras.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetras.setBounds(140, 4, 90, 16);

		//EVENTOS SWING
		lstColoresFondo.addListSelectionListener(e ->{
			if (lblResultado.getForeground() != A_CLR_COLORES[lstColoresFondo.getSelectedIndex()]) {
				getContentPane().setBackground(A_CLR_COLORES[lstColoresFondo.getSelectedIndex()]);
				lblResultado.setBackground(A_CLR_COLORES[lstColoresFondo.getSelectedIndex()]);
			}

		});


		lstColoresLetras.addListSelectionListener(e ->{
			if (getContentPane().getBackground() != A_CLR_COLORES[lstColoresLetras.getSelectedIndex()]) {
				lblResultado.setForeground(A_CLR_COLORES[lstColoresLetras.getSelectedIndex()]);
			}

		});


		// COMPONENTES AWT
		//		List lstColoresFondo = new List();
		//		lstColoresFondo.setBounds(25,50,90,120);
		//		for (String color : A_STR_COLORES) {
		//			lstColoresFondo.add(color);
		//		}
		//
		//
		//		List lstColoresLetras = new List();
		//		lstColoresLetras.setBounds(140,50,90,120);
		//		for (String color : A_STR_COLORES) {
		//			lstColoresLetras.add(color);
		//		}
		//
		//		//lblResultado
		//		Label lblResultado = new Label ("Seleccione una combinacion", Label.CENTER);
		//		lblResultado.setBounds(5,205,245,30);
		//		lblResultado.setFont(FNT_LBL_TITULO);
		//
		//
		// EVENTOS AWT

		//		lstColoresFondo.addItemListener(e ->{
		//			if (lblResultado.getForeground() != A_CLR_COLORES[lstColoresFondo.getSelectedIndex()]) {
		//				getContentPane().setBackground(A_CLR_COLORES[lstColoresFondo.getSelectedIndex()]);
		//				lblResultado.setBackground(A_CLR_COLORES[lstColoresFondo.getSelectedIndex()]);
		//			}
		//			
		//		});


		//ANIADIR al DIALOG
		getContentPane().add(lstColoresFondo);
		getContentPane().add(lstColoresLetras);
		getContentPane().add(lblResultado);
		getContentPane().add(lblFondo);
		getContentPane().add(lblLetras);

	}
}
