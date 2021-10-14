package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JList lstAgenda;
	public static JButton btnAbrirAgenda;
	public static JButton btnGuardarAgenda;
	public static JButton btnGuardar;
	public static JButton btnEditar;
	public static JTextField txtNombre;
	public static JTextField txtNumTel;
	public static JLabel lblNumTel;

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 450);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lstAgenda = new JList();
		lstAgenda.setBounds(34, 31, 152, 308);


		btnAbrirAgenda = new JButton("Abrir Agenda");
		btnAbrirAgenda.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnAbrirAgenda.setBounds(6, 369, 190, 40);


		btnGuardarAgenda = new JButton("Guardar Agenda");
		btnGuardarAgenda.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnGuardarAgenda.setBounds(201, 369, 190, 40);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnGuardar.setBounds(234, 218, 117, 29);
		btnGuardar.setVisible(false);


		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnEditar.setBounds(234, 310, 117, 29);

		txtNombre = new JTextField();
		txtNombre.setBounds(211, 122, 152, 36);
		txtNombre.setColumns(10);
		txtNombre.setVisible(false);

		txtNumTel = new JTextField();
		txtNumTel.setBounds(211, 170, 152, 36);
		txtNumTel.setColumns(10);
		txtNumTel.setVisible(false);

		lblNumTel = new JLabel("");
		lblNumTel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNumTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumTel.setBounds(211, 44, 152, 42);

		// EVENTOS
		btnAbrirAgenda.addActionListener(e -> ctrl.CtrlPrinciapl.abrirAgenda());
		btnGuardarAgenda.addActionListener(e -> ctrl.CtrlPrinciapl.guardarAgenda());
		btnEditar.addActionListener(e -> ctrl.CtrlPrinciapl.editar());
		btnGuardar.addActionListener(e -> ctrl.CtrlPrinciapl.guardar());
		lstAgenda.addListSelectionListener(e -> ctrl.CtrlPrinciapl.mostarNumero());

		// Aniadir al Frame
		contentPane.add(lstAgenda);
		contentPane.add(btnAbrirAgenda);
		contentPane.add(btnGuardarAgenda);
		contentPane.add(btnGuardar);
		contentPane.add(btnEditar);
		contentPane.add(txtNombre);
		contentPane.add(txtNumTel);
		contentPane.add(lblNumTel);


		setVisible(true);
	}
}
