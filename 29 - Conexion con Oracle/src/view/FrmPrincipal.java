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

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;
	
	private static JMenuItem mntmConexion;
	private static JMenuItem mntmLogin;
	private static JMenuItem mntmTest;

	public FrmPrincipal() {
		ventana = this;
		setTitle("Gestion de Productos");
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlFrmPrincipal.salir();

			}
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		crearComponentes();
		
		setVisible(true);
	}

	private void crearComponentes() {
		
		agregarMenu();
		agregarEventos();
		
		
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
