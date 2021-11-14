package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JTable tblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					ctrl.CtrlPrincipal.rellenarTabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tblResultado = new JTable();
		contentPane.add(new JScrollPane(tblResultado), BorderLayout.CENTER);
		
		tblResultado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblResultado.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
			ctrl.CtrlPrincipal.filaSeleccionada();
		}	
		});  
		
		
	}

}
