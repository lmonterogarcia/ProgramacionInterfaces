package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	public static JTextField tfEscritura = new JTextField();
	public static JLabel lblResultado = new JLabel("");
	public static JButton btnAceptar = new JButton("\u25B6");
	public static JLabel lblTest = new JLabel("HELLO");

	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\Desktop\\world.png"));
		setTitle("Idiomas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 232);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTest.setForeground(new Color(0, 0, 0));
		lblTest.setHorizontalAlignment(SwingConstants.CENTER);
		lblTest.setFont(new Font("Verdana", Font.BOLD, 40));
		lblTest.setBounds(10, 23, 214, 40);
		contentPane.add(lblTest);

		tfEscritura.setBounds(33, 97, 86, 20);
		contentPane.add(tfEscritura);
		tfEscritura.setColumns(10);
		
		btnAceptar.setBounds(154, 96, 46, 23);
		contentPane.add(btnAceptar);

		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Verdana", Font.BOLD, 20));
		lblResultado.setBounds(36, 144, 164, 30);
		contentPane.add(lblResultado);
		
		setVisible(true);

		//events
		btnAceptar.addActionListener(e -> {
			ctrl.CtrPrincipal.seguimos();
		});
	}
}
