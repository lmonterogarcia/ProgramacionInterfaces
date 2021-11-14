package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.w3c.dom.events.*;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.MouseAdapter;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;

	private static JMenuItem mntmConexion;
	private static JMenuItem mntmLogin;
	private static JMenuItem mntmTest;
	private JPanel pnlTablas;
	private JPanel pnlDatos;
	public static JList<String> lstTablas;
	public static JTable tblDatos;
	private JLabel lblTablas;
	private JLabel lblDatos;

	public FrmPrincipal() {
		ventana = this;
		setTitle("Tablas de SCOTT");
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
		contentPane.setLayout(new BorderLayout(10, 0));
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

		pnlTablas = new JPanel();
//		pnlTablas.setBorder(new LineBorder(new Color(255, 200, 0), 1, true));
		contentPane.add(pnlTablas, BorderLayout.WEST);
		BorderLayout bl_pnlTablas = new BorderLayout();
		bl_pnlTablas.setVgap(5);
		bl_pnlTablas.setHgap(10);
		pnlTablas.setLayout(bl_pnlTablas);

		lblTablas = new JLabel("TABLAS");
		pnlTablas.add(lblTablas, BorderLayout.NORTH);

		lstTablas = new JList<String>();
		lstTablas.setFont(new Font("Courier", Font.PLAIN, 13));

		JScrollPane spTablas = new JScrollPane(lstTablas);
		pnlTablas.add(spTablas, BorderLayout.CENTER);

		// --------------------

		pnlDatos = new JPanel();
//		pnlDatos.setBorder(new LineBorder(new Color(255, 200, 0), 1, true));
		contentPane.add(pnlDatos, BorderLayout.CENTER);
		BorderLayout bl_pnlDatos = new BorderLayout();
		bl_pnlDatos.setVgap(5);
		pnlDatos.setLayout(bl_pnlDatos);

		lblDatos = new JLabel("DATOS");
		pnlDatos.add(lblDatos, BorderLayout.NORTH);

		tblDatos = new JTable();
		tblDatos.setFont(new Font("Courier", Font.PLAIN, 13));

		JScrollPane spDatos = new JScrollPane(tblDatos);
		pnlDatos.add(spDatos, BorderLayout.CENTER);

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

//		lstTablas.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e){
//				ctrl.CtrlFrmPrincipal.filaSeleccionada();
//			}	
//			});   

		lstTablas.addListSelectionListener(e -> {
			if (e.getValueIsAdjusting()) {
				ctrl.CtrlFrmPrincipal.filaSeleccionada();
			}
		});
		mntmConexion.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuConexion());
		mntmLogin.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuLogin());
		mntmTest.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuTest());

	}

}
