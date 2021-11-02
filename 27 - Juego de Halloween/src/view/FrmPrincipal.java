package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import ctrl.CtrlPrincipal;
import ctrl.IConfiguracion;

public class FrmPrincipal extends JFrame implements IConfiguracion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JFrame ventana;
	public static JLabel[] aElementosTablero;
	private static JPanel pnlPrincipal;
	public static JLabel lblCalabazaNum;
	public static JLabel lblMurcielagoNum;
	public static JLabel lblPuntosTotales;
	public static byte bCalabazas = 0;
	public static byte bMurcielagos = 0;
	public static byte bCrucifivo = 0;
	public static byte bAjo = 0;

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

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(((screenSize.width - iANCHOCONTENTPANE[CtrlPrincipal.bDIFICULTAD]) / 2), ((screenSize.height - iALTOCONTENTPANE[CtrlPrincipal.bDIFICULTAD]) / 2), iANCHOCONTENTPANE[CtrlPrincipal.bDIFICULTAD], iALTOCONTENTPANE[CtrlPrincipal.bDIFICULTAD]);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		agregarComponentes();

		setVisible(true);
	}

	private void agregarComponentes() {

		pnlPrincipal = new JPanel();
		pnlPrincipal.setBounds(0, 0, iANCHOPNLPRINCIPAL[CtrlPrincipal.bDIFICULTAD], iALTOPNLPRINCIPAL[CtrlPrincipal.bDIFICULTAD]);
		contentPane.add(pnlPrincipal, BorderLayout.CENTER);
		pnlPrincipal.setLayout(null);

		JPanel pnlPuntuacion = new JPanel();
		contentPane.add(pnlPuntuacion, BorderLayout.SOUTH);

		JLabel lblCalabaza = new JLabel(new ImageIcon("archivos/calabazaPuntos.png"));
		pnlPuntuacion.add(lblCalabaza);

		JLabel lblCalabazaPuntos = new JLabel("50 ptos");
		pnlPuntuacion.add(lblCalabazaPuntos);

		lblCalabazaNum = new JLabel(bCalabazas + "/3   ");
		pnlPuntuacion.add(lblCalabazaNum);

		JLabel lblMurcielago = new JLabel(new ImageIcon("archivos/murcielagoPuntos.png"));
		pnlPuntuacion.add(lblMurcielago);

		JLabel lblMurcielagoPuntos = new JLabel("30 ptos");
		pnlPuntuacion.add(lblMurcielagoPuntos);

		lblMurcielagoNum = new JLabel(bMurcielagos + "/3   ");
		pnlPuntuacion.add(lblMurcielagoNum);

		lblPuntosTotales = new JLabel("" + ((bCalabazas * 50) + (bMurcielagos * 35) + (bCrucifivo * -55) + (bAjo * -35)));
		lblPuntosTotales.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuntosTotales.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		pnlPuntuacion.add(lblPuntosTotales);

		colocarElementos();

		JLabel lblFondo = new JLabel(new ImageIcon("archivos/tablero.jpg"));
		lblFondo.setBounds(0, -12, 400, 426);
		pnlPrincipal.add(lblFondo);

		// EVENTOS

		eventos();

	}

	private void eventos() {
		
		ventana.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					ctrl.CtrlPrincipal.empezar();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					ctrl.CtrlPrincipal.reiniciarJuegoPorUsuario();
				}

				if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
						|| e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					ctrl.CtrlPrincipal.moverDracula(e.getKeyCode());
				}
			}
		});
	}

	 public static void colocarElementos() {

		aElementosTablero = new JLabel[iNUMLABEL[CtrlPrincipal.bDIFICULTAD]];

		for (int i = 0; i < aElementosTablero.length; i++) {

			aElementosTablero[i] = new JLabel();
			aElementosTablero[i].setSize(50, 50);
			aElementosTablero[i].setVisible(false);
			pnlPrincipal.add(aElementosTablero[i]);

		}
		ctrl.CtrlPrincipal.colocarElementos(aElementosTablero);
	}
}
