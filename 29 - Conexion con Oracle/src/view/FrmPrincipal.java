package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;
	
	private static JMenuItem mntmConexion;
	private static JMenuItem mntmLogin;
	private static JMenuItem mntmTest;
	private JTextArea txtResultadoConsulta;
	private JPanel panel;
	private JButton btnEjecutar;
	private JTextArea txtConsulta;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	public FrmPrincipal() {
		ventana = this;
		setTitle("Gestion de Productos");
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
//		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlFrmPrincipal.salir();

			}
		});
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		crearComponentes();
		
		setVisible(true);
	}

	private void crearComponentes() {
		
		agregarMenu();
		agregarComponentes();
		agregarEventos();
		
		
	}

	private void agregarComponentes() {
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 200, 0), 1, true));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnEjecutar = new JButton("EJECUTAR");
		panel.add(btnEjecutar, BorderLayout.EAST);
		
		txtConsulta = new JTextArea();
		txtConsulta.setFont(new Font("Courier", Font.BOLD, 13));
		txtConsulta.setLineWrap(true);
		txtConsulta.setText("Escriba una consulta de SQL ...");
//		panel.add(txtConsulta, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane(txtConsulta);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		txtResultadoConsulta = new JTextArea();
		txtResultadoConsulta.setLineWrap(true);
		txtResultadoConsulta.setFont(new Font("Courier", Font.PLAIN, 13));
//		contentPane.add(txtResultadoConsulta, BorderLayout.CENTER);
		
		scrollPane_1 = new JScrollPane(txtResultadoConsulta);
		contentPane.add(scrollPane_1, BorderLayout.CENTER);
		
	}

	private void agregarMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnBaseDatos = new JMenu("Base de Datos");
		menuBar.add(mnBaseDatos);
		
		mntmConexion = new JMenuItem("Conexión");
		mnBaseDatos.add(mntmConexion);
		
		mntmLogin = new JMenuItem("Login");
		mnBaseDatos.add(mntmLogin);
		
		mnBaseDatos.addSeparator();
		
		mntmTest = new JMenuItem("Test");
		mnBaseDatos.add(mntmTest);
		
	}
	
	private void agregarEventos() {
		
		mntmConexion.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuConexion());
		mntmLogin.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuLogin());
		mntmTest.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuTest());
		
	}

}
