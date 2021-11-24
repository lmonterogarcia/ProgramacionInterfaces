package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;
	
	public static JMenuItem mntmDatabase;
	public static JMenuItem mntmLogin;
	public static JMenuItem mntmActualizar;
	public static JMenuItem mntmSalir;
	
	public static JMenuItem mntmNuevo;
	public static JMenuItem mntmEditar;
	public static JMenuItem mntmBorrar;
	public static JMenuItem mntmConsultar;
	
	public static JTable tblChalecos;

	public FrmPrincipal() {
		ventana = this;
		setTitle("Gestion de Chalecos");
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
//		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlFrmPrincipal.salir();

			}
		});
		setBounds(100, 100, 1000, 600);
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
	
	private void agregarMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnGestion = new JMenu("Gestión");
		menuBar.add(mnGestion);

		JMenu mntmConexion = new JMenu("Conexión");
		mnGestion.add(mntmConexion);

		mntmDatabase = new JMenuItem("Database");
		mntmConexion.add(mntmDatabase);
		
		mntmLogin = new JMenuItem("Login");
		mntmConexion.add(mntmLogin);

		mntmActualizar = new JMenuItem("Actualizar");
		mnGestion.add(mntmActualizar);
		
		mnGestion.addSeparator();
		
		mntmSalir = new JMenuItem("Salir");
		mnGestion.add(mntmSalir);
		
		JMenu mnChaleco = new JMenu("Chaleco");
		menuBar.add(mnChaleco);
		
		mntmNuevo = new JMenuItem("Nuevo");
		mnChaleco.add(mntmNuevo);
		
		mntmEditar = new JMenuItem("Editar");
		mnChaleco.add(mntmEditar);
		
		mntmBorrar = new JMenuItem("Borrar");
		mnChaleco.add(mntmBorrar);
		
		mntmConsultar = new JMenuItem("Consultar");
		mnChaleco.add(mntmConsultar);
		
		
		
	}

	private void agregarComponentes() {

		tblChalecos = new JTable();
		contentPane.add(new JScrollPane(tblChalecos), BorderLayout.CENTER);
		
		tblChalecos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

	}
	
	private void agregarEventos() {

		mntmDatabase.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuDatabase());
		mntmLogin.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuLogin());
		mntmActualizar.addActionListener(e -> ctrl.CtrlFrmPrincipal.actualizar());
		mntmSalir.addActionListener(e -> ctrl.CtrlFrmPrincipal.salir());
		
		mntmNuevo.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuNuevo());
		mntmEditar.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuEditar());
		mntmBorrar.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuBorrar());
		mntmConsultar.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuConsultar());

	}

}
