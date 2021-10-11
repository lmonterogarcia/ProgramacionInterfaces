package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.*;

public class MiniCalculo extends java.awt.Frame{

	public static TextField txtNumero;
	public static Label lblResultado;

	public MiniCalculo() {
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlCalculo.finalizarApp();
			}
		});

		setTitle("Doble");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int iAncho = 300, iAlto = 200; 

		setBounds(((screenSize.width - iAncho) / 2),((screenSize.height - iAlto) / 2),iAncho,iAlto);
		setBackground(Theme.CLR_BG_FONDO);
		setLayout(null);
		setVisible(true);

		crearComponentes();

	}

	private void crearComponentes() {

		//Button

		Button btnCalcularDoble = new Button("DOBLE");
		btnCalcularDoble.setBounds(20,105,80,30);
		btnCalcularDoble.setFont(Theme.FNT_LBL_TITULO);
		
		Button btnCalcularTriple = new Button("TRIPLE");
		btnCalcularTriple.setBounds(110,105,80,30);
		btnCalcularTriple.setFont(Theme.FNT_LBL_TITULO);
		
		Button btnCalcularMitad = new Button("MITAD");
		btnCalcularMitad.setBounds(200,105,80,30);
		btnCalcularMitad.setFont(Theme.FNT_LBL_TITULO);

		//Labels

		Label lblNumero = new Label("Numero:");
		lblNumero.setBounds(50,66,66,20);
		lblNumero.setFont(Theme.FNT_LBL_NORMAL);
		lblNumero.setForeground(Theme.CLR_FG_TEXTO);

		lblResultado = new Label("Escriba un numero y pulse el boton");
		lblResultado.setBounds(20,150,280,20);
		lblResultado.setFont(Theme.FNT_LBL_TITULO);
		lblResultado.setForeground(Theme.CLR_FG_TEXTO);
		lblResultado.setAlignment(Label.CENTER);

		//TextFild

		txtNumero = new TextField();
		txtNumero.setBounds(120,66,150,20);

		//Asignamos Eventos

		btnCalcularDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlCalculo.calcualarDoble();
			}
		});
		
		btnCalcularTriple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlCalculo.calcualarTriple();
			}
		});
		
		btnCalcularMitad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlCalculo.calcualarMitad();
			}
		});

		//Agregar Componentes

		add(btnCalcularDoble);
		add(btnCalcularTriple);
		add(btnCalcularMitad);
		add(lblNumero);
		add(lblResultado);
		add(txtNumero);

	}

}
