package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrmManual extends JDialog {

	private JPanel contentPane;
	
	public FrmManual() {
		setTitle("Manual");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JLabel lblTextoManual = new JLabel("");
		lblTextoManual.setText(ctrl.CtrlManual.mostrarTexto());
		
		JScrollPane scrollPane = new JScrollPane(lblTextoManual);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		setVisible(true);

	}

}
