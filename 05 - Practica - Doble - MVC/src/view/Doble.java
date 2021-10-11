package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.*;

public class Doble extends java.awt.Frame{

	public static TextField txtNumero;
	public static Label lblResultado;

	public Doble() {
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlDoble.finalizarApp();
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

		Button btnCalcularDoble = new Button("CALCULAR");
		btnCalcularDoble.setBounds(100,105,100,30);
		btnCalcularDoble.setFont(Theme.FNT_LBL_TITULO);

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
				ctrl.CtrlDoble.calcualarDoble();
			}
		});

		//Agregar Componentes

		add(btnCalcularDoble);
		add(lblNumero);
		add(lblResultado);
		add(txtNumero);

	}

}
