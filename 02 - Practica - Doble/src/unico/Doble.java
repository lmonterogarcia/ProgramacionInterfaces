package unico;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.*;

public class Doble extends java.awt.Frame{

		//Colores
	
		final Color CLR_BG_FONDO = new Color(30,30,31);
		final Color CLR_BG_Resaltado = Color.red;
		final Color CLR_FG_TEXTO = Color.white;
		
		//Typofgrafias
		
		final Font FNT_LBL_NORMAL = new Font("Arial" , Font.PLAIN , 12);
		final Font FNT_LBL_TITULO = new Font("Arial" , Font.BOLD , 14);
		
	public static void main(String[] args) {
		
		Doble miApp = new Doble();
		
		miApp.crearVentana();

	}

	private void crearVentana() {
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		setTitle("Doble");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int iAncho = 300, iAlto = 200; 
		
		setBounds(((screenSize.width - iAncho) / 2),((screenSize.height - iAlto) / 2),iAncho,iAlto);
		setBackground(CLR_BG_FONDO);
		setLayout(null);
		setVisible(true);
		
		crearComponentes();
		
	}

	private void crearComponentes() {
		
				//Button
		
				Button btnCalcularDoble = new Button("CALCULAR");
				btnCalcularDoble.setBounds(100,105,100,30);
				btnCalcularDoble.setFont(FNT_LBL_TITULO);

				//Labels
				
				Label lblNumero = new Label("Numero:");
				lblNumero.setBounds(50,66,66,20);
				lblNumero.setFont(FNT_LBL_NORMAL);
				lblNumero.setForeground(CLR_FG_TEXTO);

				Label lblResultado = new Label("Escriba un numero y pulse el boton");
				lblResultado.setBounds(20,150,280,20);
				lblResultado.setFont(FNT_LBL_TITULO);
				lblResultado.setForeground(CLR_FG_TEXTO);
				lblResultado.setAlignment(Label.CENTER);

				//TextFild
				
				TextField txtNumero = new TextField();
				txtNumero.setBounds(120,66,150,20);
				
				//Asignamos Eventos
				
				btnCalcularDoble.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							double dNumero  = Double.parseDouble(txtNumero.getText());
							dNumero = dNumero * 2;
							lblResultado.setForeground(CLR_FG_TEXTO);
							lblResultado.setText(Double.toString(dNumero));
						} catch (Exception e2) {
							if (txtNumero.getText().isEmpty()) {
								lblResultado.setForeground(CLR_BG_Resaltado);
								lblResultado.setText("Tiene que introducir ALGO");
							} else {
								lblResultado.setForeground(CLR_BG_Resaltado);
								lblResultado.setText("Solo puedes introducir NUMEROS");
							}
						}
					}
				});
				
				//Agregar Componentes
				
				add(btnCalcularDoble);
				add(lblNumero);
				add(lblResultado);
				add(txtNumero);
		
	}

}
