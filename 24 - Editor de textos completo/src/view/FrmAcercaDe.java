package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class FrmAcercaDe extends JDialog {

	/**
	 * Create the dialog.
	 */
	public FrmAcercaDe() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Acerca de");
		setBounds(100, 100, 350, 200);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(null);
		
		JLabel lblIcono = new JLabel(new ImageIcon ("media/IconoAhoraViajar.png"));
		lblIcono.setBounds(30, 35, 100, 100);

		JLabel lblTituloApp = new JLabel("EDITOR DE TEXTO");
		lblTituloApp.setBounds(160, 35, 118, 16);
		
		JLabel lblVersion = new JLabel("Version 1.0");
		lblVersion.setBounds(160, 78, 77, 16);
		
		JLabel lblAutor = new JLabel("Autor Luis Montero");
		lblAutor.setBounds(160, 119, 126, 16);

		getContentPane().add(lblIcono);
		getContentPane().add(lblTituloApp);
		getContentPane().add(lblVersion);
		getContentPane().add(lblAutor);
		
		setVisible(true);

	}
}
