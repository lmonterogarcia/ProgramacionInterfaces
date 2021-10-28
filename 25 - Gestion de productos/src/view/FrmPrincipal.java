package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;

public class FrmPrincipal extends JFrame {

	public static JPanel contentPane;
	public static JFrame ventana;
	public static JList lstCategorias;
	public static JPanel pnlContenido;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		ventana = this;
		setTitle("Gestion de Productos");
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlPrincipal.salir();

			}
		});
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		crearComponentes();
		
		setVisible(true);
		
		
	}

	private void crearComponentes() {
		
		lstCategorias = new JList(model.IProducto.listadoCategorias);
		lstCategorias.setPrototypeCellValue("xxxxxxxxxxxx");
//		lstCategorias.setVisibleRowCount(20);
		
		JScrollPane scrollPane = new JScrollPane(lstCategorias);
		scrollPane.setBounds(0,0,100,300);
		contentPane.add(scrollPane, BorderLayout.WEST);
		
		pnlContenido = new JPanel(); //500x268
		contentPane.add(pnlContenido, BorderLayout.CENTER);
		pnlContenido.setLayout(new CardLayout(0, 0));
		
		
		// EVENTOS
		lstCategorias.addListSelectionListener(e -> {
			if (e.getValueIsAdjusting()) {
				
				ctrl.CtrlPrincipal.elegirPanel();
			}
		});
		
	}
}
