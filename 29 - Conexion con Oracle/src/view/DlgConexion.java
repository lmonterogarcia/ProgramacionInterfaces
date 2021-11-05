package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DlgConexion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField txtHost;
	public static JTextField txtPuerto;
	public static JTextField txtNombre;
	public static JButton btnAceptar;
	public static JButton btnCancelar;

	public DlgConexion() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 280, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		crearComponentes();
		
		setVisible(true);
	}
	
	private void crearComponentes() {
		
		JPanel pnlPrincipal = new JPanel();
		contentPanel.add(pnlPrincipal, BorderLayout.CENTER);
		pnlPrincipal.setLayout(new GridLayout(3, 3, 5, 8));
		
		JPanel pnlInferior = new JPanel();
		contentPanel.add(pnlInferior, BorderLayout.SOUTH);
		
		JLabel lblHost = new JLabel("Host:");
		lblHost.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPrincipal.add(lblHost);

		txtHost = new JTextField();
		pnlPrincipal.add(txtHost);
		txtHost.setColumns(10);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPrincipal.add(lblPuerto);
		
		txtPuerto = new JTextField();
		pnlPrincipal.add(txtPuerto);
		txtPuerto.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		pnlPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnAceptar = new JButton("ACEPTAR");
		pnlInferior.add(btnAceptar);
		
		btnCancelar = new JButton("CANCELAR");
		pnlInferior.add(btnCancelar);
		
		crearEventos();
	}

	private void crearEventos() {
		
		btnAceptar.addActionListener( e -> ctrl.CtrlDlgConexion.aceptar());
		btnAceptar.addActionListener( e -> ctrl.CtrlDlgConexion.cancelar());
		
	}

}
