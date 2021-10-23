package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

public class FrmColores extends JDialog {

	private JPanel contentPane;
	private final Color[] aColores = { Color.BLACK, Color.WHITE, Color.GRAY, Color.RED, Color.ORANGE, Color.YELLOW,
			Color.GREEN, Color.BLUE, Color.CYAN };

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
		pnlFuente.setLayout(new GridLayout(3, 3, 0, 0));

		JButton btnFntNegro = new JButton("");
		btnFntNegro.setBorderPainted(false);
		btnFntNegro.setContentAreaFilled(false);
		btnFntNegro.setOpaque(true);
		btnFntNegro.setBackground(aColores[0]);
		pnlFuente.add(btnFntNegro);

		JButton btnFntBlanco = new JButton("");//--------------------------
		btnFntBlanco.setBorderPainted(false);
		btnFntBlanco.setContentAreaFilled(false);
		btnFntBlanco.setOpaque(true);
		btnFntBlanco.setBackground(aColores[1]);
		pnlFuente.add(btnFntBlanco);

		JButton btnFntGris = new JButton("");
		btnFntGris.setBorderPainted(false);
		btnFntGris.setContentAreaFilled(false);
		btnFntGris.setOpaque(true);
		btnFntGris.setBackground(aColores[2]);
		pnlFuente.add(btnFntGris);

		JButton btnFntRojo = new JButton("");
		btnFntRojo.setBorderPainted(false);
		btnFntRojo.setContentAreaFilled(false);
		btnFntRojo.setOpaque(true);
		btnFntRojo.setBackground(aColores[3]);
		pnlFuente.add(btnFntRojo);

		JButton btnFntNaranja = new JButton("");
		btnFntNaranja.setBorderPainted(false);
		btnFntNaranja.setContentAreaFilled(false);
		btnFntNaranja.setOpaque(true);
		btnFntNaranja.setBackground(aColores[4]);
		pnlFuente.add(btnFntNaranja);

		JButton btnFntAmarillo = new JButton("");
		btnFntAmarillo.setBorderPainted(false);
		btnFntAmarillo.setContentAreaFilled(false);
		btnFntAmarillo.setOpaque(true);
		btnFntAmarillo.setBackground(aColores[5]);
		pnlFuente.add(btnFntAmarillo);

		JButton btnFntVerde = new JButton("");
		btnFntVerde.setBorderPainted(false);
		btnFntVerde.setContentAreaFilled(false);
		btnFntVerde.setOpaque(true);
		btnFntVerde.setBackground(aColores[6]);
		pnlFuente.add(btnFntVerde);

		JButton btnFntAzul = new JButton("");
		btnFntAzul.setBorderPainted(false);
		btnFntAzul.setContentAreaFilled(false);
		btnFntAzul.setOpaque(true);
		btnFntAzul.setBackground(aColores[7]);
		pnlFuente.add(btnFntAzul);

		JButton btnFntCyan = new JButton("");
		btnFntCyan.setBorderPainted(false);
		btnFntCyan.setContentAreaFilled(false);
		btnFntCyan.setOpaque(true);
		btnFntCyan.setBackground(aColores[8]);
		pnlFuente.add(btnFntCyan);

		JPanel pnlFondo = new JPanel();
		pnlFondo.setBounds(207, 30, 170, 170);
		contentPane.add(pnlFondo);
		pnlFondo.setLayout(new GridLayout(3, 3, 0, 0));

		JButton btnFndNegro = new JButton("");
		btnFndNegro.setBorderPainted(false);
		btnFndNegro.setContentAreaFilled(false);
		btnFndNegro.setOpaque(true);
		btnFndNegro.setBackground(aColores[0]);
		pnlFondo.add(btnFndNegro);

		JButton btnFndBlanco = new JButton("");
		btnFndBlanco.setBorderPainted(false);
		btnFndBlanco.setContentAreaFilled(false);
		btnFndBlanco.setOpaque(true);
		btnFndBlanco.setBackground(aColores[1]);
		pnlFondo.add(btnFndBlanco);

		JButton btnFndGris = new JButton("");
		btnFndGris.setBorderPainted(false);
		btnFndGris.setContentAreaFilled(false);
		btnFndGris.setOpaque(true);
		btnFndGris.setBackground(aColores[2]);
		pnlFondo.add(btnFndGris);

		JButton btnFndRojo = new JButton("");
		btnFndRojo.setBorderPainted(false);
		btnFndRojo.setContentAreaFilled(false);
		btnFndRojo.setOpaque(true);
		btnFndRojo.setBackground(aColores[3]);
		pnlFondo.add(btnFndRojo);

		JButton btnFndNaranja = new JButton("");
		btnFndNaranja.setBorderPainted(false);
		btnFndNaranja.setContentAreaFilled(false);
		btnFndNaranja.setOpaque(true);
		btnFndNaranja.setBackground(aColores[4]);
		pnlFondo.add(btnFndNaranja);

		JButton btnFndAmarillo = new JButton("");
		btnFndAmarillo.setBorderPainted(false);
		btnFndAmarillo.setContentAreaFilled(false);
		btnFndAmarillo.setOpaque(true);
		btnFndAmarillo.setBackground(aColores[5]);
		pnlFondo.add(btnFndAmarillo);

		JButton btnFndVerde = new JButton("");
		btnFndVerde.setBorderPainted(false);
		btnFndVerde.setContentAreaFilled(false);
		btnFndVerde.setOpaque(true);
		btnFndVerde.setBackground(aColores[6]);
		pnlFondo.add(btnFndVerde);

		JButton btnFndAzul = new JButton("");
		btnFndAzul.setBorderPainted(false);
		btnFndAzul.setContentAreaFilled(false);
		btnFndAzul.setOpaque(true);
		btnFndAzul.setBackground(aColores[7]);
		pnlFondo.add(btnFndAzul);

		JButton btnFndCyan = new JButton("");
		btnFndCyan.setBorderPainted(false);
		btnFndCyan.setContentAreaFilled(false);
		btnFndCyan.setOpaque(true);
		btnFndCyan.setBackground(aColores[8]);
		pnlFondo.add(btnFndCyan);

		JLabel lblFuente = new JLabel("Fuente");
		lblFuente.setBounds(16, 6, 61, 16);
		contentPane.add(lblFuente);

		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setBounds(207, 6, 61, 16);
		contentPane.add(lblFondo);

		JLabel lblTextoPrueba = new JLabel("Texto de Prueba");
		lblTextoPrueba.setForeground(Color.BLACK);
		lblTextoPrueba.setBackground(Color.WHITE);
		lblTextoPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPrueba.setBounds(77, 205, 243, 27);
		contentPane.add(lblTextoPrueba);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(16, 237, 170, 29);
		contentPane.add(btnAceptar);

		JButton btnGuardarDef = new JButton("Guardar x Defecto");
		btnGuardarDef.setBounds(207, 237, 170, 29);
		contentPane.add(btnGuardarDef);

		JPanel pnlFondoPrueba = new JPanel();
		pnlFondoPrueba.setBackground(Color.WHITE);
		pnlFondoPrueba.setBounds(80, 205, 240, 27);
		contentPane.add(pnlFondoPrueba);

		setVisible(true);

	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
