package view;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private int x = 183, y = 88;
	private JTextField txtCuadroDeTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new FrmPrincipal();
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIamge = new JLabel(new ImageIcon("image.png"));
		lblIamge.setBounds(x, y, 80, 80);
		contentPane.add(lblIamge);

		txtCuadroDeTexto = new JTextField();
		txtCuadroDeTexto.setBounds(158, 6, 130, 26);
		contentPane.add(txtCuadroDeTexto);
		txtCuadroDeTexto.setColumns(10);

		// EVENTOS
		txtCuadroDeTexto.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_R:
					contentPane.setBackground(Color.red);
					break;
				case KeyEvent.VK_G:
					contentPane.setBackground(Color.green);
					break;
				case KeyEvent.VK_B:
					contentPane.setBackground(Color.blue);
					break;
				}
				try {
					Clip sonido = AudioSystem.getClip();
					sonido.open(AudioSystem.getAudioInputStream(new File("alien_9.wav")));
					sonido.loop(0);
					sonido.start();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		txtCuadroDeTexto.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					y -= 5;
					break;
				case KeyEvent.VK_DOWN:
					y += 5;
					break;
				case KeyEvent.VK_LEFT:
					x -= 5;
					break;
				case KeyEvent.VK_RIGHT:
					x += 5;
					break;

				}

				lblIamge.setLocation(x, y);

			}
		});
		
		setVisible(true);
	}
}
