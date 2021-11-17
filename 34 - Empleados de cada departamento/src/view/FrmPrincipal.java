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
	private JPanel pnlDepartamentos;
	private JPanel pnlEmpleados;
	public static JTable tblDepartamentos;
	public static JTable tblEmpleados;
	private JLabel lblDepartamentos;
	private JLabel lblEmpleados;

	public FrmPrincipal() {
		ventana = this;
		setTitle("Gestion de empleados por departamento");
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
//		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlFrmPrincipal.salir();

			}
		});
		setBounds(100, 100, 1000, 400);
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

		pnlDepartamentos = new JPanel();
//		pnlTablas.setBorder(new LineBorder(new Color(255, 200, 0), 1, true));
		contentPane.add(pnlDepartamentos, BorderLayout.WEST);
		BorderLayout bl_pnlTablas = new BorderLayout();
		bl_pnlTablas.setVgap(5);
		bl_pnlTablas.setHgap(10);
		pnlDepartamentos.setLayout(bl_pnlTablas);

		lblDepartamentos = new JLabel("DEPARTAMENTOS");
		pnlDepartamentos.add(lblDepartamentos, BorderLayout.NORTH);

		tblDepartamentos = new JTable();
		tblDepartamentos.setFont(new Font("Courier", Font.PLAIN, 13));

		JScrollPane spDepartamentos = new JScrollPane(tblDepartamentos);
		pnlDepartamentos.add(spDepartamentos, BorderLayout.CENTER);

		// --------------------

		pnlEmpleados = new JPanel();
		contentPane.add(pnlEmpleados, BorderLayout.CENTER);
		BorderLayout bl_pnlDatos = new BorderLayout();
		bl_pnlDatos.setVgap(5);
		pnlEmpleados.setLayout(bl_pnlDatos);

		lblEmpleados = new JLabel("EMPLEADOS");
		pnlEmpleados.add(lblEmpleados, BorderLayout.NORTH);

		tblEmpleados = new JTable();
		tblEmpleados.setFont(new Font("Courier", Font.PLAIN, 13));

		JScrollPane spEmpleados = new JScrollPane(tblEmpleados);
		pnlEmpleados.add(spEmpleados, BorderLayout.CENTER);

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

		tblDepartamentos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e){
				ctrl.CtrlFrmPrincipal.departamentoSeleccionado();
			}	
			});   
		
		tblEmpleados.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e){
				ctrl.CtrlFrmPrincipal.empleadoSeleccionado();
			}	
			});

		
		mntmConexion.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuConexion());
		mntmLogin.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuLogin());
		mntmTest.addActionListener(e -> ctrl.CtrlFrmPrincipal.menuTest());

	}

}
