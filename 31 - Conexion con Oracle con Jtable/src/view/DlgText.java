package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DlgText extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JDialog ventana;

	public DlgText() {
		ventana = this;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 350, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		crearComponentes();
		
		setVisible(true);

	}

	private void crearComponentes() {
		
		String sMensaje = ctrl.CtrlDlgTest.testConection();
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(113, 55, 117, 29);
		contentPanel.add(btnAceptar);
		
		JLabel lblResultadoTest = new JLabel(sMensaje);
		lblResultadoTest.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblResultadoTest.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoTest.setBounds(6, 16, 338, 35);
		contentPanel.add(lblResultadoTest);
		
		btnAceptar.addActionListener(e -> dispose());
		
	}
}
