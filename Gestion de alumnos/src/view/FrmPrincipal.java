package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FrmPrincipal extends JFrame {

	//Colores
	public static final Color CLR_BG_PANEL = Color.blue;
	public static final Color CLR_FG_BTN = Color.white;
	
	private JPanel contentPane;
	public static JFrame ventana;
	public static JTextField txtNombre;
	public static JTextField txtApellidos;
	public static JComboBox cbTalla;
	public static JRadioButton rdbtnDam;
	public static JRadioButton rdbtnDaw;
	public static JRadioButton rdbtnAsir;
	public static JRadioButton rdbtnManiana;
	public static JRadioButton rdbtnTarde;
	public static JRadioButton rdbtnOnLine;
	public static JTextArea txtaComentarios;
	public static JList lstSedes;
	public static JButton btnPrincipio;
	public static JButton btnAtras;
	public static JButton btnSiguiente;
	public static JButton btnUltimo;
	public static JButton btnEditar;
	public static JButton btnGuardar;
	public static JButton btnCancelar;
	public static JCheckBox chckReponsable;

	
	public FrmPrincipal() {
		ventana = this;
		setTitle("Gestion de Alumnos");
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlPrincipal.salir();

			}
		});
		setBounds(100, 100, 450, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		agregarComponentes();
		
		setVisible(true);
		
		
	}


	private void agregarComponentes() {
		

		// PANEL PRINCIPAL
		
		JPanel pnlPrincipal = new JPanel();
		contentPane.add(pnlPrincipal, BorderLayout.CENTER);
		pnlPrincipal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 428, 113);
		pnlPrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(6, 16, 61, 16);
		panel.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(6, 59, 72, 16);
		panel.add(lblApellidos);
		
		txtNombre = new JTextField("");
		txtNombre.setBounds(90, 11, 173, 26);
		txtNombre.setEnabled(false);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField("");
		txtApellidos.setBounds(90, 54, 332, 26);
		txtApellidos.setEnabled(false);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setBounds(275, 16, 43, 16);
		panel.add(lblTalla);
		
		cbTalla = new JComboBox(model.IAlumno.sTalla);
		cbTalla.setBounds(320, 12, 102, 27);
		cbTalla.setEnabled(false);
		panel.add(cbTalla);
		
		JPanel pnlCiclos = new JPanel();
		pnlCiclos.setBounds(6, 131, 428, 42);
		pnlPrincipal.add(pnlCiclos);
		pnlCiclos.setLayout(null);
		
		JLabel lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setBounds(6, 13, 61, 16);
		pnlCiclos.add(lblCiclo);
		
		rdbtnDam = new JRadioButton("DAM");
		rdbtnDam.setBounds(79, 9, 86, 23);
		rdbtnDam.setEnabled(false);
		pnlCiclos.add(rdbtnDam);
		
		rdbtnDaw = new JRadioButton("DAW");
		rdbtnDaw.setBounds(177, 9, 69, 23);
		rdbtnDaw.setEnabled(false);
		pnlCiclos.add(rdbtnDaw);
		
		rdbtnAsir = new JRadioButton("ASIR");
		rdbtnAsir.setBounds(281, 9, 141, 23);
		rdbtnAsir.setEnabled(false);
		pnlCiclos.add(rdbtnAsir);
		
		ButtonGroup btngrCiclo = new ButtonGroup();
		btngrCiclo.add(rdbtnDam);
		btngrCiclo.add(rdbtnDaw);
		btngrCiclo.add(rdbtnAsir);
		
		JPanel pnlTurnos = new JPanel();
		pnlTurnos.setBounds(6, 185, 428, 42);
		pnlPrincipal.add(pnlTurnos);
		pnlTurnos.setLayout(null);
		
		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setBounds(6, 13, 61, 16);
		pnlTurnos.add(lblTurno);
		
		rdbtnManiana = new JRadioButton("Maniana");
		rdbtnManiana.setBounds(79, 9, 86, 23);
		rdbtnManiana.setEnabled(false);
		pnlTurnos.add(rdbtnManiana);
		
		rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setBounds(177, 9, 80, 23);
		rdbtnTarde.setEnabled(false);
		pnlTurnos.add(rdbtnTarde);
		
		rdbtnOnLine = new JRadioButton("On-Line");
		rdbtnOnLine.setBounds(281, 9, 141, 23);
		rdbtnOnLine.setEnabled(false);
		pnlTurnos.add(rdbtnOnLine);
		
		ButtonGroup btngrTurno = new ButtonGroup();
		btngrTurno.add(rdbtnManiana);
		btngrTurno.add(rdbtnTarde);
		btngrTurno.add(rdbtnManiana);
		
		JLabel lblComentarios = new JLabel("Comentarios:");
		lblComentarios.setBounds(11, 239, 93, 16);
		pnlPrincipal.add(lblComentarios);
		
		txtaComentarios = new JTextArea("");
		txtaComentarios.setEnabled(false);
		JScrollPane scrollPaneComentarios = new JScrollPane(txtaComentarios);
		scrollPaneComentarios.setBounds(11, 267, 223, 95);
		pnlPrincipal.add(scrollPaneComentarios);
		
		JLabel lblSede = new JLabel("Sede:");
		lblSede.setBounds(246, 239, 61, 16);
		pnlPrincipal.add(lblSede);
		
		lstSedes = new JList(model.IAlumno.sSede);
		lstSedes.setEnabled(false);
		JScrollPane scrollPaneSedes = new JScrollPane(lstSedes);
		scrollPaneSedes.setBounds(256, 265, 100, 95);
		pnlPrincipal.add(scrollPaneSedes);
		
		chckReponsable = new JCheckBox("Es Responsable Economico?");
		chckReponsable.setBounds(13, 363, 215, 23);
		chckReponsable.setEnabled(false);
		pnlPrincipal.add(chckReponsable);
		
		// PANEL INFERIOR
		
		JPanel pnlInferior = new JPanel();
		pnlInferior.setBounds(0,390,440,42);
		pnlInferior.setLayout(null);
		pnlInferior.setBackground(CLR_BG_PANEL);
//		contentPane.add(pnlInferior, BorderLayout.SOUTH);
		pnlPrincipal.add(pnlInferior);
		
		btnPrincipio = new JButton("|<");
		btnPrincipio.setBounds(6, 6, 30, 30);
		btnPrincipio.setBackground(CLR_FG_BTN);
		pnlInferior.add(btnPrincipio);
		
		btnAtras = new JButton("<<");
		btnAtras.setBounds(48, 7, 30, 30);
		btnAtras.setBackground(CLR_FG_BTN);
		pnlInferior.add(btnAtras);
		
		btnSiguiente = new JButton(">>");
		btnSiguiente.setBounds(90, 7, 30, 30);
		btnSiguiente.setBackground(CLR_FG_BTN);
		pnlInferior.add(btnSiguiente);
		
		btnUltimo = new JButton(">|");
		btnUltimo.setBounds(132, 7, 30, 30);
		btnUltimo.setBackground(CLR_FG_BTN);
		pnlInferior.add(btnUltimo);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(180, 10, 77, 29);
		btnEditar.setBackground(CLR_FG_BTN);
		pnlInferior.add(btnEditar);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(251, 10, 94, 29);
		btnGuardar.setBackground(CLR_FG_BTN);
		btnGuardar.setVisible(false);
		pnlInferior.add(btnGuardar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(340, 10, 94, 29);
		btnCancelar.setBackground(CLR_FG_BTN);
		btnCancelar.setVisible(false);
		pnlInferior.add(btnCancelar);
		
		
		// EVENTOS
		btnPrincipio.addActionListener(e -> ctrl.CtrlPrincipal.primero());
		btnAtras.addActionListener(e -> ctrl.CtrlPrincipal.atras());
		btnSiguiente.addActionListener(e -> ctrl.CtrlPrincipal.siguiente());
		btnUltimo.addActionListener(e -> ctrl.CtrlPrincipal.ultimo());
		btnEditar.addActionListener(e -> ctrl.CtrlPrincipal.editar());
		btnGuardar.addActionListener(e -> ctrl.CtrlPrincipal.guardar());
		btnCancelar.addActionListener(e -> ctrl.CtrlPrincipal.cancelar());
		
	}
}
