package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;
	public static JList lstAgenda;
	public static JButton btnAbrirAgenda;
	public static JButton btnGuardarAgenda;
	public static JButton btnGuardar;
	public static JButton btnEditar;
	public static JTextField txtNombre;
	public static JTextField txtNumTel;
	public static JLabel lblNumTel;
	public static DefaultListModel<String> sModel = new DefaultListModel<>();

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {

		ventana = this;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 376);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						ctrl.CtrlPrinciapl.salir();

					}
				});
		
		lstAgenda = new JList(sModel);
//		lstAgenda.setBounds(34, 31, 152, 308);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 31, 152, 252);
		scrollPane.setViewportView(lstAgenda);


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
		btnAbrirAgenda.addActionListener(e -> ctrl.CtrlPrinciapl.abrirAgenda());
		btnGuardarAgenda.addActionListener(e -> ctrl.CtrlPrinciapl.guardarAgenda());
		btnEditar.addActionListener(e -> ctrl.CtrlPrinciapl.editar());
		btnGuardar.addActionListener(e -> ctrl.CtrlPrinciapl.guardar());
		lstAgenda.addListSelectionListener(e -> {
			view.FrmPrincipal.btnEditar.setEnabled(true);
			view.FrmPrincipal.btnGuardar.setVisible(false);
			view.FrmPrincipal.txtNombre.setVisible(false);
			view.FrmPrincipal.txtNumTel.setVisible(false);
			ctrl.CtrlPrinciapl.mostarNumero();
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
