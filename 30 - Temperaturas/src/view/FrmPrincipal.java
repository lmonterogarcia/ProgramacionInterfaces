package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Choice;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;
	public static Choice cbComunidad;
	public static Choice cbProvincia;
	public static Choice cbCiudad;
	public static JCheckBox chckbxGuardarDef;
	public static JLabel lblTemperaturas;

	public FrmPrincipal() {
		ventana = this;
		setTitle("Temperaturas");
		setIconImage(Toolkit.getDefaultToolkit().createImage("faviconAhoraViajar.png"));
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlFrmPrincipal.salir();
			}
		});
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		crearComponentes();
		
		setVisible(true);
	}

	private void crearComponentes() {

		JLabel lblComuniad = new JLabel("Comunidad");
		lblComuniad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComuniad.setBounds(22, 40, 79, 16);
		contentPane.add(lblComuniad);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setBounds(40, 88, 61, 16);
		contentPane.add(lblProvincia);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCiudad.setBounds(40, 138, 61, 16);
		contentPane.add(lblCiudad);
		
		cbComunidad = new Choice();
		cbComunidad.setBounds(113, 36, 298, 27);
		contentPane.add(cbComunidad);
		
		cbProvincia = new Choice();
		cbProvincia.setBounds(113, 84, 298, 27);
		contentPane.add(cbProvincia);
		
		cbCiudad = new Choice();
		cbCiudad.setBounds(113, 134, 298, 27);
		contentPane.add(cbCiudad);
		
		lblTemperaturas = new JLabel("-");
		lblTemperaturas.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblTemperaturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperaturas.setBounds(22, 193, 409, 36);
		contentPane.add(lblTemperaturas);
		
		chckbxGuardarDef = new JCheckBox("Guadar por defecto.");
		chckbxGuardarDef.setBounds(40, 241, 156, 23);
		contentPane.add(chckbxGuardarDef);
		

		
		crearEventos();
		
	}

	private void crearEventos() {
		
		cbComunidad.addItemListener(e -> ctrl.CtrlFrmPrincipal.comunidadSeleccionada());
		cbProvincia.addItemListener(e -> ctrl.CtrlFrmPrincipal.provinciaSeleccionada());
		cbCiudad.addItemListener(e -> ctrl.CtrlFrmPrincipal.ciudadSeleccionada());
		
	}
}
