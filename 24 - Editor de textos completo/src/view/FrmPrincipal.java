package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;
	public static JMenuBar menuBar;
	public static JMenu mnArchivo;
	public static JMenuItem mntmNuevo;
	public static JMenuItem mntmAbrir;
	public static JMenuItem mntmGuardar;
	public static JMenuItem mntmGuardarComo;
	public static JMenuItem mntmSalir;
	public static JMenu mnAyuda;
	public static JMenuItem mntmManual;
	public static JMenuItem mntmAcercaDe;
	public static JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		ventana = this;
		setTitle("Editor de Texto");
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		
		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						ctrl.CtrlPrincipal.salir();

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

		// MENU
		menuBar = new JMenuBar();
		mnArchivo = new JMenu("Archivo");
		mntmNuevo = new JMenuItem("Nuevo");
		mntmAbrir = new JMenuItem("Abrir");
		mntmGuardar = new JMenuItem("Guardar");
		mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmSalir = new JMenuItem("Salir");
		mnAyuda = new JMenu("Ayuda");
		mntmManual = new JMenuItem("Manual");
		mntmAcercaDe = new JMenuItem("Acerca De");
		
		// COMPONENTES
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		// EVENTOS
		mntmNuevo.addActionListener(e -> ctrl.CtrlPrincipal.nuevo());
		mntmAbrir.addActionListener(e -> ctrl.CtrlPrincipal.abrir());
		mntmGuardar.addActionListener(e -> ctrl.CtrlPrincipal.guardar());
		mntmGuardarComo.addActionListener(e -> ctrl.CtrlPrincipal.guardarComo());
		mntmSalir.addActionListener(e -> ctrl.CtrlPrincipal.salir());
		mntmManual.addActionListener(e -> new FrmManual());
		mntmAcercaDe.addActionListener(e -> new FrmAcercaDe());
		
		// ANIADIR AL FRAME
		setJMenuBar(menuBar);
		menuBar.add(mnArchivo);
		mnArchivo.add(mntmNuevo);
		mnArchivo.add(mntmAbrir);
		mnArchivo.add(mntmGuardar);
		mnArchivo.add(mntmGuardarComo);
		mnArchivo.addSeparator();
		mnArchivo.add(mntmSalir);
		menuBar.add(mnAyuda);
		mnAyuda.add(mntmManual);
		mnAyuda.add(mntmAcercaDe);	

	}

}
