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

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;
	public static JComboBox cbComunidad;
	public static JComboBox<String> cbProvincia;
	public static JComboBox<String> cbCiudad;
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
		
		cbComunidad = new JComboBox(ctrl.CtrlFrmPrincipal.crearArrayComunidades().toArray());
		cbComunidad.setBounds(113, 36, 298, 27);
		contentPane.add(cbComunidad);
		
		cbProvincia = new JComboBox<String>();
		cbProvincia.setBounds(113, 84, 298, 27);
		cbProvincia.setEnabled(false);
		contentPane.add(cbProvincia);
		
		cbCiudad = new JComboBox<String>();
		cbCiudad.setBounds(113, 134, 298, 27);
		cbCiudad.setEnabled(false);
		contentPane.add(cbCiudad);
		
		lblTemperaturas = new JLabel("-");
		lblTemperaturas.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblTemperaturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperaturas.setBounds(22, 193, 409, 36);
		lblTemperaturas.setVisible(false);
		contentPane.add(lblTemperaturas);
		
		chckbxGuardarDef = new JCheckBox("Guadar por defecto.");
		chckbxGuardarDef.setBounds(40, 241, 156, 23);
		contentPane.add(chckbxGuardarDef);
		
		crearEventos();
		
	}

	private void crearEventos() {
		

		cbComunidad.addActionListener(e -> ctrl.CtrlFrmPrincipal.comunidadSeleccionada());
//		cbComunidad.addItemListener(e-> ctrl.CtrlFrmPrincipal.comunidadSeleccionada());
		cbProvincia.addActionListener(e -> ctrl.CtrlFrmPrincipal.provinciaSeleccionada());
//		cbProvincia.addItemListener(e -> ctrl.CtrlFrmPrincipal.provinciaSeleccionada());
		cbCiudad.addActionListener(e -> ctrl.CtrlFrmPrincipal.ciudadSeleccionada());
//		cbCiudad.addItemListener(e -> ctrl.CtrlFrmPrincipal.ciudadSeleccionada());
		chckbxGuardarDef.addActionListener(e -> ctrl.CtrlFrmPrincipal.guardarPorDefecto());
		
	}
}
