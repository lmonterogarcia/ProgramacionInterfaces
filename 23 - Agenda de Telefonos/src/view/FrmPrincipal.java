package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;
	public static JList<String> lstAgenda;
	public static JButton btnAbrirAgenda;
	public static JButton btnGuardarAgenda;
	public static JButton btnGuardar;
	public static JButton btnEditar;
	public static JTextField txtNombre;
	public static JTextField txtNumTel;
	public static JLabel lblNumTel;
	public static DefaultListModel<String> sModel = new DefaultListModel<String>();;

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {

		ventana = this;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Agenda Telefonica");
		setBounds(100, 100, 393, 376);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						ctrl.CtrlPrinciapl.salir();

					}
				});
		
		lstAgenda = new JList<String>(sModel);
		JScrollPane scrollPane = new JScrollPane(lstAgenda);
		scrollPane.setBounds(34, 31, 152, 252);
//		scrollPane.setViewportView(lstAgenda);


		btnAbrirAgenda = new JButton("Abrir Agenda");
		btnAbrirAgenda.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnAbrirAgenda.setBounds(6, 295, 190, 40);


		btnGuardarAgenda = new JButton("Guardar Agenda");
		btnGuardarAgenda.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnGuardarAgenda.setBounds(197, 295, 190, 40);
		btnGuardarAgenda.setEnabled(false);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnGuardar.setBounds(234, 218, 117, 29);
		btnGuardar.setVisible(false);


		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnEditar.setBounds(234, 259, 117, 29);
		btnEditar.setEnabled(false);

		txtNombre = new JTextField();
		txtNombre.setBounds(211, 125, 152, 36);
		txtNombre.setColumns(10);
		txtNombre.setVisible(false);

		txtNumTel = new JTextField();
		txtNumTel.setBounds(211, 175, 152, 36);
		txtNumTel.setColumns(10);
		txtNumTel.setVisible(false);

		lblNumTel = new JLabel("");
		lblNumTel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNumTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumTel.setBounds(211, 44, 152, 42);

		// EVENTOS
		btnAbrirAgenda.addActionListener(e -> ctrl.CtrlPrinciapl.pulsarAbrirAgenda());
		btnGuardarAgenda.addActionListener(e -> ctrl.CtrlPrinciapl.guardarAgenda());
		btnEditar.addActionListener(e -> ctrl.CtrlPrinciapl.editar());
		btnGuardar.addActionListener(e -> ctrl.CtrlPrinciapl.guardar());
		lstAgenda.addListSelectionListener(e -> {
			if (e.getValueIsAdjusting()) {
				view.FrmPrincipal.btnEditar.setEnabled(true);
				ctrl.CtrlPrinciapl.mostarNumero();
			}
		});

		// Aniadir al Frame
		contentPane.add(scrollPane);
		contentPane.add(btnAbrirAgenda);
		contentPane.add(btnGuardarAgenda);
		contentPane.add(btnGuardar);
		contentPane.add(btnEditar);
		contentPane.add(txtNombre);
		contentPane.add(txtNumTel);
		contentPane.add(lblNumTel);
		setContentPane(contentPane);
		


		setVisible(true);
	}
}
