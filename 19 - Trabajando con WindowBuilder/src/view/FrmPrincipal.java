package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	public FrmPrincipal() {
		
		// CONFIGURACION FRAME
		setTitle("Window Builder");
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						salir();

					}
				});

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// COMPONENTES
		JMenuBar menuBar = new JMenuBar();
		JMenu mnEditar = new JMenu("Editar");
		JMenuItem mntmColores = new JMenuItem("Colores");
		JMenuItem mntmSalir = new JMenuItem("Salir");
		
		// EVENTOS
		mntmSalir.addActionListener(e -> salir());
		mntmColores.addActionListener(e -> new FrmColores());
		
		// ANIADIR 
		setJMenuBar(menuBar);
		menuBar.add(mnEditar);
		mnEditar.add(mntmColores);
		mnEditar.addSeparator();
		mnEditar.add(mntmSalir);
		setVisible(true);
		
	}
	
	private void salir() {
		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null,"Estas seguro que quiere salir?", "Asistente de salida", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (iOpcSeleccionada == JOptionPane.YES_OPTION) {
			//System.exit(0);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		} else {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}
}
