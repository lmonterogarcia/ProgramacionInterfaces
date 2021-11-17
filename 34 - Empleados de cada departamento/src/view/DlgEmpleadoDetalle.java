package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class DlgEmpleadoDetalle extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	public static JTextField txtNombre;
	public static JTextField txtOficio;
	public static JTextField txtSalario;
	public static JTextField txtComision;
	public static JTextField txtFchAlta;
	public static JTextField txtJefe;

	public DlgEmpleadoDetalle() {
		definirVentana();
		crearComponentes();
		ctrl.CtrlDlgEmpleadoDetalle.rellenarEmpleado();
		setVisible(true);
	}

	private void definirVentana() {
		setTitle("Detalle de Empleado");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 300, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	}

	private void crearComponentes() {
		
		crearLabels();
		crearTxt();
		
	}

	private void crearTxt() {
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(97, 30, 180, 26);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtOficio = new JTextField();
		txtOficio.setEditable(false);
		txtOficio.setBounds(97, 65, 180, 26);
		contentPanel.add(txtOficio);
		txtOficio.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setEditable(false);
		txtSalario.setBounds(97, 100, 180, 26);
		contentPanel.add(txtSalario);
		txtSalario.setColumns(10);
		
		txtComision = new JTextField();
		txtComision.setEditable(false);
		txtComision.setBounds(97, 135, 180, 26);
		contentPanel.add(txtComision);
		txtComision.setColumns(10);
		
		txtFchAlta = new JTextField();
		txtFchAlta.setEditable(false);
		txtFchAlta.setBounds(97, 170, 180, 26);
		contentPanel.add(txtFchAlta);
		txtFchAlta.setColumns(10);
		
		txtJefe = new JTextField();
		txtJefe.setEditable(false);
		txtJefe.setBounds(97, 205, 180, 26);
		contentPanel.add(txtJefe);
		txtJefe.setColumns(10);
		
	}

	private void crearLabels() {
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNombre.setBounds(10, 35, 75, 16);
		contentPanel.add(lblNombre);
		
		JLabel lblOficio = new JLabel("OFICIO:");
		lblOficio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOficio.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblOficio.setBounds(10, 70, 75, 16);
		contentPanel.add(lblOficio);
		
		JLabel lblSalario = new JLabel("SALARIO:");
		lblSalario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalario.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblSalario.setBounds(10, 105, 75, 16);
		contentPanel.add(lblSalario);
		
		JLabel lblComision = new JLabel("COMISION:");
		lblComision.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComision.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblComision.setBounds(10, 140, 75, 16);
		contentPanel.add(lblComision);
		
		JLabel lblFchAlta = new JLabel("FCH ALTA:");
		lblFchAlta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFchAlta.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFchAlta.setBounds(10, 175, 75, 16);
		contentPanel.add(lblFchAlta);
		
		JLabel lblJefe = new JLabel("JEFE:");
		lblJefe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJefe.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblJefe.setBounds(10, 210, 75, 16);
		contentPanel.add(lblJefe);
		
	}
}
