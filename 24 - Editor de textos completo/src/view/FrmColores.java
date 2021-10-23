package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

public class FrmColores extends JDialog {

	private JPanel contentPane;
	private final Color[] aColores = { Color.BLACK, Color.WHITE, Color.GRAY, Color.RED, Color.ORANGE, Color.YELLOW,
			Color.GREEN, Color.BLUE, Color.CYAN };
	public static ButtonGroup btngrFuente;
	public static ButtonGroup btngrFondo;
	public static ArrayList<JButton> aBtnFuente = new ArrayList<JButton>();
	public static ArrayList<JButton> aBtnFondo = new ArrayList<JButton>();
	public static JLabel lblTextoPrueba;
	public static JButton btnAceptar;
	public static JButton btnGuardarDef;
	public static JPanel pnlFondoPrueba;

	public FrmColores() {
		setTitle("Editor de Colores");
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel pnlFuente = new JPanel();
		pnlFuente.setBounds(16, 30, 170, 170);
		contentPane.add(pnlFuente);
		pnlFuente.setLayout(new GridLayout(3, 3, 5, 5));

		for (int i = 0; i < aColores.length; i++) {

			aBtnFuente.add(new JButton(""));
			aBtnFuente.get(i).setBorderPainted(false);
			aBtnFuente.get(i).setContentAreaFilled(false);
			aBtnFuente.get(i).setOpaque(true);
			aBtnFuente.get(i).setBackground(aColores[i]);
			pnlFuente.add(aBtnFuente.get(i));
			
			final int IPOSICION = i;
			aBtnFuente.get(i).addActionListener(e -> ctrl.CtrlColores.cambiarColorfuente(IPOSICION));

		}

		JPanel pnlFondo = new JPanel();
		pnlFondo.setBounds(207, 30, 170, 170);
		contentPane.add(pnlFondo);
		pnlFondo.setLayout(new GridLayout(3, 3, 5, 5));

		for (int i = 0; i < aColores.length; i++) {

			aBtnFondo.add(i, new JButton(""));
			aBtnFondo.get(i).setBorderPainted(false);
			aBtnFondo.get(i).setContentAreaFilled(false);
			aBtnFondo.get(i).setOpaque(true);
			aBtnFondo.get(i).setBackground(aColores[i]);
			pnlFondo.add(aBtnFondo.get(i));
			
			final int IPOSICION = i;
			aBtnFondo.get(i).addActionListener(e -> ctrl.CtrlColores.cambiarColorFondo(IPOSICION));

		}

		JLabel lblFuente = new JLabel("Fuente");
		lblFuente.setBounds(16, 6, 61, 16);
		contentPane.add(lblFuente);

		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setBounds(207, 6, 61, 16);
		contentPane.add(lblFondo);

		lblTextoPrueba = new JLabel("Texto de Prueba");
		lblTextoPrueba.setOpaque(true);
		lblTextoPrueba.setForeground(view.FrmPrincipal.textArea.getForeground());
		lblTextoPrueba.setBackground(view.FrmPrincipal.textArea.getBackground());
		lblTextoPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPrueba.setBounds(77, 205, 243, 27);
		contentPane.add(lblTextoPrueba);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(16, 237, 170, 29);
		contentPane.add(btnAceptar);

		btnGuardarDef = new JButton("Guardar x Defecto");
		btnGuardarDef.setBounds(207, 237, 170, 29);
		contentPane.add(btnGuardarDef);

		// EVENTOS
		
		btnAceptar.addActionListener(e -> ctrl.CtrlColores.aceptar());
		btnGuardarDef.addActionListener(e -> ctrl.CtrlColores.guardarDef());

		setVisible(true);

	}

}
