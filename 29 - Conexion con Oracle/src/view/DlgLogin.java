package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class DlgLogin extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTextField txtUsuario;
	public static JPasswordField txtPassword;
	public static JButton btnAceptar;
	public static JButton btnCancelar;
	public static JDialog ventana;

	public DlgLogin() {
		ventana = this;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 280, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		crearComponentes();

		setVisible(true);

	}

	private void crearComponentes() {
		JPanel pnlPrincipal = new JPanel();
		contentPanel.add(pnlPrincipal, BorderLayout.CENTER);
		pnlPrincipal.setLayout(new GridLayout(2, 2, 5, 20));
		
		JPanel pnlInferior = new JPanel();
		contentPanel.add(pnlInferior, BorderLayout.SOUTH);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPrincipal.add(lblUsuario);

		txtUsuario = new JTextField(ctrl.CtrlGestConOracle.getConnInfon().getDbUSER());
		pnlPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPrincipal.add(lblPassword);
		
		txtPassword = new JPasswordField(ctrl.CtrlGestConOracle.getConnInfon().getDbPASSWORD());
		pnlPrincipal.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnAceptar = new JButton("ACEPTAR");
		pnlInferior.add(btnAceptar);
		
		btnCancelar = new JButton("CANCELAR");
		pnlInferior.add(btnCancelar);
		
		crearEventos();
	}

	private void crearEventos() {
		
		btnAceptar.addActionListener( e -> ctrl.CtrlDlgLogin.aceptar());
		btnCancelar.addActionListener( e -> ctrl.CtrlDlgLogin.cancelar());
		
	}

}
