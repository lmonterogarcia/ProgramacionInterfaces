package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Icon;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JFrame ventana;


	public FrmPrincipal() {
		ventana = this;
		setTitle("Halloween Game");
		setIconImage(Toolkit.getDefaultToolkit().createImage("archivos/faviconAhoraViajar.png"));
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrlPrincipal.salir();

			}
		});
		
		setBounds(100, 100, 410, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		agregarComponentes();
		
		setVisible(true);
	}


	private void agregarComponentes() {
		
		JPanel pnlPrincipal = new JPanel();
		pnlPrincipal.setBounds(0,0,400,400);
		contentPane.add(pnlPrincipal, BorderLayout.CENTER);
		pnlPrincipal.setLayout(null);
		
		JPanel pnlPuntuacion = new JPanel();
		contentPane.add(pnlPuntuacion, BorderLayout.SOUTH);
		
		JLabel lblCalabaza = new JLabel(new ImageIcon("archivos/calabazaPuntos.png"));
		pnlPuntuacion.add(lblCalabaza);
		
		JLabel lblCalabazaPuntos = new JLabel("50 ptos");
		pnlPuntuacion.add(lblCalabazaPuntos);
		
		JLabel lblCalabazaNum = new JLabel("3/3   ");
		pnlPuntuacion.add(lblCalabazaNum);
		
		JLabel lblMurcielago = new JLabel(new ImageIcon("archivos/murcielagoPuntos.png"));
		pnlPuntuacion.add(lblMurcielago);
		
		JLabel lblMurcielagoPuntos = new JLabel("30 ptos");
		pnlPuntuacion.add(lblMurcielagoPuntos);
		
		JLabel lblMurcielagoNum = new JLabel("3/3   ");
		pnlPuntuacion.add(lblMurcielagoNum);
		
		JLabel lblPuntosTotales = new JLabel("200");
		lblPuntosTotales.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuntosTotales.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		pnlPuntuacion.add(lblPuntosTotales);
		
	}

}
