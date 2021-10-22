package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FrmFuentes extends JDialog {

	private JPanel contentPane;
	public static JRadioButton rdbtnNormal;
	public static JRadioButton rdbtnNegrita;
	public static JRadioButton rdbtnCursiva;
	public static JButton btnAceptar;
	public static JButton  btnGuardarDef;
	public static DefaultListModel<String> modFuente = new DefaultListModel<String>();
	public static DefaultListModel<String> modTamanio = new DefaultListModel<String>();
	
	
	// FALTA LA LISTA Y MAS COMPONENTES!!!!!!!!!
	public FrmFuentes() {
		setTitle("Editor de Fuentes");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel pnlFuente = new JPanel();
		pnlFuente.setBounds(18, 6, 120, 190);
		contentPane.add(pnlFuente);
		pnlFuente.setLayout(null);
		
		JLabel lblFuente = new JLabel("Fuente");
		lblFuente.setBounds(6, 5, 108, 16);
		pnlFuente.add(lblFuente);
		
		JScrollPane spFuente = new JScrollPane();
		spFuente.setBounds(6, 30, 108, 154);
		pnlFuente.add(spFuente);
		
		JList lstFuente = new JList(modFuente);
		spFuente.setViewportView(lstFuente);
		
		JPanel pnlTamanio = new JPanel();
		pnlTamanio.setBounds(163, 6, 120, 190);
		contentPane.add(pnlTamanio);
		pnlTamanio.setLayout(null);
		
		JLabel lblTamanio = new JLabel("Tamanio");
		lblTamanio.setBounds(6, 5, 108, 16);
		pnlTamanio.add(lblTamanio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 30, 108, 154);
		pnlTamanio.add(scrollPane_1);
		
		JPanel pnlEstilos = new JPanel();
		pnlEstilos.setBounds(310, 6, 120, 190);
		contentPane.add(pnlEstilos);
		pnlEstilos.setLayout(null);
		
		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setBounds(6, 5, 108, 16);
		pnlEstilos.add(lblEstilo);
		
		rdbtnNormal = new JRadioButton("NORMAL");
		rdbtnNormal.setBounds(0, 52, 114, 23);
		pnlEstilos.add(rdbtnNormal);
		
		rdbtnNegrita = new JRadioButton("NEGRITA");
		rdbtnNegrita.setBounds(0, 99, 114, 23);
		pnlEstilos.add(rdbtnNegrita);
		
		rdbtnCursiva = new JRadioButton("CURSIVA");
		rdbtnCursiva.setBounds(0, 145, 114, 23);
		pnlEstilos.add(rdbtnCursiva);
		
		JLabel lblTextoPrueba = new JLabel("Texto de Prueba");
		lblTextoPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPrueba.setBounds(84, 208, 289, 42);
		contentPane.add(lblTextoPrueba);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(84, 253, 117, 29);
		contentPane.add(btnAceptar);
		
		btnGuardarDef = new JButton("GUARDAR X DEFECTO");
		btnGuardarDef.setBounds(202, 253, 171, 29);
		contentPane.add(btnGuardarDef);
		
		// EVENTOS
		
		
		
		
		setVisible(true);

	}
}
