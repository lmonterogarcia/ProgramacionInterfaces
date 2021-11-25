package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDetalleChaleco extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JDialog ventana;
	
	public static JTextField txtModelo;
	public static JTextField txtPrecio;
	public static JTextField txtStock;
	public static JComboBox cbTalla;
	
	public static JButton btnRojo;
	public static JButton btnVerde;
	public static JButton btnAzul;
	public static JButton btnAmarillo;
	public static JLabel lblColorChaleco;
	
	public static JButton btnCancelar;
	public static JButton btnGuardar;

	public DlgDetalleChaleco() {
		
		setTitle("Detalles del Chaleco");
		ventana = this;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		crearComponentes();
		
		ctrl.CtrlDlgDetalleChaleco.rellenarDatos();
		
		setModal(true);
		
		setVisible(true);
		
	}

	private void crearComponentes() {
		
		
		addComponentes();
		addEventos();
		
	}

	private void addComponentes() {
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(24, 24, 61, 16);
		contentPanel.add(lblModelo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBackground(Color.BLACK);
		lblColor.setBounds(24, 96, 38, 16);
		contentPanel.add(lblColor);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setBounds(24, 160, 61, 16);
		contentPanel.add(lblTalla);
		
		lblColorChaleco = new JLabel("Color");
		lblColorChaleco.setBounds(296, 96, 124, 16);
		contentPanel.add(lblColorChaleco);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(164, 160, 61, 16);
		contentPanel.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(296, 160, 61, 16);
		contentPanel.add(lblStock);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(88, 215, 117, 29);
		btnGuardar.setBackground(Color.YELLOW);
		contentPanel.add(btnGuardar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(231, 215, 117, 29);
		contentPanel.add(btnCancelar);
		
		txtModelo = new JTextField();
		txtModelo.setBackground(Color.WHITE);
		txtModelo.setBounds(104, 14, 316, 37);
		contentPanel.add(txtModelo);
		txtModelo.setColumns(10);
		
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(216, 155, 68, 26);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(344, 155, 76, 26);
		contentPanel.add(txtStock);
		txtStock.setColumns(10);
		
		cbTalla = new JComboBox(model.IChaleco.sTalla);
		cbTalla.setBounds(66, 156, 68, 27);
		contentPanel.add(cbTalla);
		
		btnRojo = new JButton();
		btnRojo.setBounds(69, 89, 30, 30);
		btnRojo.setBackground(Color.RED);
		btnRojo.setOpaque(true);
		btnRojo.setBorderPainted(false);
		contentPanel.add(btnRojo);
		
		btnAmarillo = new JButton();
		btnAmarillo.setBounds(228, 89, 30, 30);
		btnAmarillo.setBackground(Color.YELLOW);
		btnAmarillo.setOpaque(true);
		btnAmarillo.setBorderPainted(false);
		contentPanel.add(btnAmarillo);
		
		btnAzul = new JButton();
		btnAzul.setBounds(175, 89, 30, 30);
		btnAzul.setBackground(Color.BLUE);
		btnAzul.setOpaque(true);
		btnAzul.setBorderPainted(false);
		contentPanel.add(btnAzul);
		
		btnVerde = new JButton();
		btnVerde.setBounds(122, 89, 30, 30);
		btnVerde.setBackground(Color.GREEN);
		btnVerde.setOpaque(true);
		btnVerde.setBorderPainted(false);
		contentPanel.add(btnVerde);
		
	}

	private void addEventos() {
		
		btnRojo.addActionListener( e-> ctrl.CtrlDlgDetalleChaleco.rojo());
		btnAmarillo.addActionListener( e-> ctrl.CtrlDlgDetalleChaleco.amarillo());
		btnAzul.addActionListener( e-> ctrl.CtrlDlgDetalleChaleco.azul());
		btnVerde.addActionListener( e-> ctrl.CtrlDlgDetalleChaleco.verde());
		
		btnCancelar.addActionListener( e-> ctrl.CtrlDlgDetalleChaleco.cancelar());
		btnGuardar.addActionListener( e-> ctrl.CtrlDlgDetalleChaleco.guardar());
		
		
	}
}
