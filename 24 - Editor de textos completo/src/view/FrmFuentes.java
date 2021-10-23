package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class FrmFuentes extends JDialog {

	private JPanel contentPane;
	public static JRadioButton rdbtnNormal;
	public static JRadioButton rdbtnNegrita;
	public static JRadioButton rdbtnCursiva;
	public static JButton btnAceptar;
	public static JButton btnGuardarDef;
	public final static String[] aFuente = {"Arial","TimesRoman","Helvetica","Avenir","Garamon","Futura"};
	public final static String[] aTamanio = {"9","11","13","15","17","19","21","23","25"};
	private static Font fuente = new Font(aFuente[0],Font.PLAIN,Integer.parseInt(aTamanio[0]));
	public static JList<String> lstFuente;
	public static JList<String> lstTamanio;
	public static JLabel lblTextoPrueba;

	public FrmFuentes() {
		setTitle("Editor de Fuentes");
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 320);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// COMPONENTES ################################################
		
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

		lstFuente = new JList<String>(aFuente);
		lstFuente.setSelectedIndex(0);
		spFuente.setViewportView(lstFuente);

		JPanel pnlTamanio = new JPanel();
		pnlTamanio.setBounds(163, 6, 120, 190);
		contentPane.add(pnlTamanio);
		pnlTamanio.setLayout(null);

		JLabel lblTamanio = new JLabel("Tamanio");
		lblTamanio.setBounds(6, 5, 108, 16);
		pnlTamanio.add(lblTamanio);

		JScrollPane spTamanio = new JScrollPane();
		spTamanio.setBounds(6, 30, 108, 154);
		pnlTamanio.add(spTamanio);

		lstTamanio = new JList<String>(aTamanio);
		lstTamanio.setSelectedIndex(0);
		spTamanio.setViewportView(lstTamanio);

		JPanel pnlEstilos = new JPanel();
		pnlEstilos.setBounds(310, 6, 120, 190);
		contentPane.add(pnlEstilos);
		pnlEstilos.setLayout(null);

		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setBounds(6, 5, 108, 16);
		pnlEstilos.add(lblEstilo);

		rdbtnNormal = new JRadioButton("NORMAL");
		rdbtnNormal.setBounds(0, 52, 114, 23);
		rdbtnNormal.setSelected(true);
		;
		pnlEstilos.add(rdbtnNormal);

		rdbtnNegrita = new JRadioButton("NEGRITA");
		rdbtnNegrita.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		rdbtnNegrita.setBounds(0, 99, 114, 23);
		pnlEstilos.add(rdbtnNegrita);

		rdbtnCursiva = new JRadioButton("CURSIVA");
		rdbtnCursiva.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		rdbtnCursiva.setBounds(0, 145, 114, 23);
		pnlEstilos.add(rdbtnCursiva);

		ButtonGroup bntGroup = new ButtonGroup();
		bntGroup.add(rdbtnNormal);
		bntGroup.add(rdbtnNegrita);
		bntGroup.add(rdbtnCursiva);

		lblTextoPrueba = new JLabel("Texto de Prueba");
		lblTextoPrueba.setFont(new Font("Arial", Font.PLAIN, 9));
		lblTextoPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPrueba.setBounds(84, 205, 289, 42);
		lblTextoPrueba.setFont(fuente);
		contentPane.add(lblTextoPrueba);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(84, 253, 117, 29);
		contentPane.add(btnAceptar);

		btnGuardarDef = new JButton("GUARDAR X DEFECTO");
		btnGuardarDef.setBounds(202, 253, 171, 29);
		contentPane.add(btnGuardarDef);

		// EVENTOS ########################################################

		btnAceptar.addActionListener(e -> ctrl.CtrlFuente.aceptar());
		btnGuardarDef.addActionListener(e -> ctrl.CtrlFuente.guardarDef());
		rdbtnNormal.addActionListener(e -> ctrl.CtrlFuente.fuenteElegida());
		rdbtnNegrita.addActionListener(e -> ctrl.CtrlFuente.fuenteElegida());
		rdbtnCursiva.addActionListener(e -> ctrl.CtrlFuente.fuenteElegida());
		lstFuente.addListSelectionListener(e -> {
			if (e.getValueIsAdjusting()) {
				ctrl.CtrlFuente.fuenteElegida();
			}
		});
		lstTamanio.addListSelectionListener(e -> {
			if (e.getValueIsAdjusting()) {
				ctrl.CtrlFuente.fuenteElegida();
			}
		});

		setVisible(true);

	}
}
