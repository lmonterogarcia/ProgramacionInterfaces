package ctrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//import javax.swing.plaf.DimensionUIResource;

public class CtrlPrincipal {

	private static ImageIcon[] aIconos;
	private static byte[][] aTablero = new byte[8][8];
//	private static ArrayList<Dimension> alElementosCapturados = new ArrayList<Dimension>();
	private static byte bEmpezar = 0;

	public static void inicio() {

		new view.FrmPrincipal();
		ToastMessage toastMessage = new ToastMessage("Dale a ESPACIO para ver los elementos",1800);
        toastMessage.setVisible(true);

	}

	public static void salir() {

		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null, "Realmente desea salir?", "Asistente de salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (iOpcSeleccionada == JOptionPane.YES_OPTION) {

			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} else if (iOpcSeleccionada == JOptionPane.NO_OPTION) {
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		}

	}
	
	public static void reiniciarJuego() {
		
		Arrays.fill(aTablero, null);
		aTablero = new byte[8][8];
		bEmpezar = 0;
		
		for (int i = 1; i < view.FrmPrincipal.aElementosTablero.length; i++) {
			view.FrmPrincipal.aElementosTablero[i].setVisible(false);
		}
		view.FrmPrincipal.aElementosTablero[0].setVisible(false);
		
		colocarElementos(view.FrmPrincipal.aElementosTablero);
		view.FrmPrincipal.bCalabazas = 0;
		view.FrmPrincipal.bMurcielagos = 0;
		view.FrmPrincipal.bCrucifivo = 0;
		view.FrmPrincipal.bAjo = 0;
		actualizarPuntuacion();
		ToastMessage toastMessage = new ToastMessage("El juego se ha reiniciado, Pulsa ESPACIO para ver lo elementos",2000);
        toastMessage.setVisible(true);
	}

	public static void colocarElementos(JLabel[] aElementosTablero) {
		crearIconos();
		posicionElemento(aElementosTablero[0], aIconos[0], (byte) 1);
		posicionElemento(aElementosTablero[1], aIconos[1], (byte) 2);
		posicionElemento(aElementosTablero[2], aIconos[2], (byte) 3);
		for (int i = 3; i < 6; i++) {
			posicionElemento(aElementosTablero[i], aIconos[3], (byte) 4);
		}
		for (int i = 6; i < 9; i++) {
			posicionElemento(aElementosTablero[i], aIconos[4], (byte) 5);
		}
		for (int i = 9; i < 12; i++) {
			posicionElemento(aElementosTablero[i], aIconos[5], (byte) 6);
		}
		for (int i = 12; i < 15; i++) {
			posicionElemento(aElementosTablero[i], aIconos[6], (byte) 7);
		}
	}

	private static void posicionElemento(JLabel jLabel, ImageIcon imageIcon, byte iTipoElemento) {
		boolean booExito = false;
		int iX, iY;

		jLabel.setIcon(imageIcon);

		do {
			iX = (int) Math.floor(Math.random() * 8);
			;
			iY = (int) Math.floor(Math.random() * 8);
			;
			if (aTablero[iY][iX] == 0) {
				aTablero[iY][iX] = iTipoElemento;
				jLabel.setLocation(iX * 50, iY * 50);
				booExito = true;
			}
		} while (!booExito);
	}

	private static void crearIconos() {
		aIconos = new ImageIcon[view.FrmPrincipal.iNumLabel];
		ImageIcon iiDracula = new ImageIcon("archivos/dracula.png");
		aIconos[0] = iiDracula;
		ImageIcon iiAtaud = new ImageIcon("archivos/ataud.png");
		aIconos[1] = iiAtaud;
		ImageIcon iiSol = new ImageIcon("archivos/sol.png");
		aIconos[2] = iiSol;
		ImageIcon iiAjo = new ImageIcon("archivos/ajo.png");
		aIconos[3] = iiAjo;
		ImageIcon iiCrucifijo = new ImageIcon("archivos/crucifijo.png");
		aIconos[4] = iiCrucifijo;
		ImageIcon iiCalabaza = new ImageIcon("archivos/calabaza.png");
		aIconos[5] = iiCalabaza;
		ImageIcon iiMurcielago = new ImageIcon("archivos/murcielago.png");
		aIconos[6] = iiMurcielago;

	}

	private static void controlPuntos(int iElemento) {
		switch (iElemento) {
		case 2:
			if (view.FrmPrincipal.aElementosTablero[1].isVisible()) {
				verResultados();
			}
			break;
		case 3:
			muerteSol();
			break;
		case 4:
			view.FrmPrincipal.bAjo++;
			break;
		case 5:
			view.FrmPrincipal.bCrucifivo++;
			break;
		case 6:
			view.FrmPrincipal.bCalabazas++;
			break;
		case 7:
			view.FrmPrincipal.bMurcielagos++;
			break;
		}

		actualizarPuntuacion();

		if ((view.FrmPrincipal.bAjo + view.FrmPrincipal.bCrucifivo) == 6) {
			muertePuntos();
		}
		if ((view.FrmPrincipal.bCalabazas + view.FrmPrincipal.bMurcielagos) == 6) {
			view.FrmPrincipal.aElementosTablero[1].setVisible(true);
			ToastMessage toastMessage = new ToastMessage("Ve al ATAUD, ten cuidado de no morir",2000);
	        toastMessage.setVisible(true);
		}
	}

	private static void verResultados() {

		String sPuntuacion = "" + ((view.FrmPrincipal.bCalabazas * 50) + (view.FrmPrincipal.bMurcielagos * 35)
				+ (view.FrmPrincipal.bCrucifivo * -55) + (view.FrmPrincipal.bAjo * -35));
		JOptionPane.showMessageDialog(null, "HAS GANADO. Tu puntuacion ha sido de " + sPuntuacion + ". Se va a reiniciar el juego",
				"HAS GANADO", JOptionPane.OK_OPTION, aIconos[6]);

			reiniciarJuego();
	}

	private static void muertePuntos() {
		String sPuntuacion = "" + ((view.FrmPrincipal.bCalabazas * 50) + (view.FrmPrincipal.bMurcielagos * 35)
				+ (view.FrmPrincipal.bCrucifivo * -55) + (view.FrmPrincipal.bAjo * -35));
		JOptionPane
				.showMessageDialog(
						null, "HAS PERDIDO. Parece que has pasado por muchos ajos y crucifios. Tu puntuacion ha sido de "
								+ sPuntuacion + ". Se va a reiniciar el juego",
						"HAS PERDIDO", JOptionPane.OK_OPTION, aIconos[4]);

			reiniciarJuego();

	}

	private static void muerteSol() {
		JOptionPane.showMessageDialog(null,
				"HAS PERDIDO. Parece que a Dracula no le gusta mucho el sol, y se acaba de convertir en polvo.\nSe va a reiniciar el juego",
				"Dracula se ha volatilizado, HAS PERDIDO", JOptionPane.OK_OPTION, aIconos[2]);

		reiniciarJuego();

	}

	private static void actualizarPuntuacion() {
		view.FrmPrincipal.lblCalabazaNum.setText(view.FrmPrincipal.bCalabazas + "/3   ");
		view.FrmPrincipal.lblMurcielagoNum.setText(view.FrmPrincipal.bMurcielagos + "/3   ");
		view.FrmPrincipal.lblPuntosTotales
				.setText("" + ((view.FrmPrincipal.bCalabazas * 50) + (view.FrmPrincipal.bMurcielagos * 35)
						+ (view.FrmPrincipal.bCrucifivo * -55) + (view.FrmPrincipal.bAjo * -35)));

	}

	public static void moverDracula(int keyCode) {
		int x = view.FrmPrincipal.aElementosTablero[0].getX();
		int y = view.FrmPrincipal.aElementosTablero[0].getY();

		if (bEmpezar > 1) {
			switch (keyCode) {
			case KeyEvent.VK_UP:
				if (y != 0) {
					y -= 50;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (y != 350) {
					y += 50;
				}
				break;
			case KeyEvent.VK_LEFT:
				if (x != 0) {
					x -= 50;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (x != 350) {
					x += 50;
				}
				break;
			}
			view.FrmPrincipal.aElementosTablero[0].setLocation(x, y);
			controlCaptura();
		}
	}

	private static void controlCaptura() {
		boolean booEncima = false;
		int iContadorElementos = view.FrmPrincipal.aElementosTablero.length - 1;

		do {
			if (view.FrmPrincipal.aElementosTablero[0].getX() == view.FrmPrincipal.aElementosTablero[iContadorElementos]
					.getX()
					&& view.FrmPrincipal.aElementosTablero[0]
							.getY() == view.FrmPrincipal.aElementosTablero[iContadorElementos].getY()) {
				if (iContadorElementos == 1) {
					controlPuntos(2);
					booEncima = true;
				} else {
					booEncima = true;
					capturar(iContadorElementos);
				}
				
			}
			iContadorElementos--;
		} while (!booEncima && iContadorElementos > 0);

	}

	private static void capturar(int iContadorElementos) {
		if (!view.FrmPrincipal.aElementosTablero[iContadorElementos].isVisible()) {
//		if (!yaCapturado(iContadorElementos)) {
			view.FrmPrincipal.aElementosTablero[iContadorElementos].setVisible(true);
			int iFila = view.FrmPrincipal.aElementosTablero[0].getY() / 50,
					iColumna = view.FrmPrincipal.aElementosTablero[0].getX() / 50;
			controlPuntos(aTablero[iFila][iColumna]);
		}
	}

	// Se ha encontrado un metodo mas facil de entender!!!!!!!
	//
//	private static boolean yaCapturado(int iContadorElementos) {
//		boolean booYaCapturado = false;
//		int iContadorCapturados = alElementosCapturados.size() - 1;
//
//		do {
//			if (iContadorCapturados >= 0
//					&& view.FrmPrincipal.aElementosTablero[iContadorElementos]
//							.getX() == alElementosCapturados.get(iContadorCapturados).width
//					&& view.FrmPrincipal.aElementosTablero[iContadorElementos]
//							.getY() == alElementosCapturados.get(iContadorCapturados).height) {
//
//				booYaCapturado = true;
//			}
//			iContadorCapturados--;
//		} while (!booYaCapturado && iContadorCapturados > 0);
//
//		if (!booYaCapturado) {
//			alElementosCapturados.add(new Dimension(view.FrmPrincipal.aElementosTablero[iContadorElementos].getX(),
//					view.FrmPrincipal.aElementosTablero[iContadorElementos].getY()));
//		}
//
//		return booYaCapturado;
//	}

	public static void empezar() {
		if (bEmpezar == 0) {
			
			ToastMessage toastMessage = new ToastMessage("Vuelve a darle a ESPACIO para empezar, pero antes memoriza bien el tablero",2800);
            toastMessage.setVisible(true);
			for (int i = 0; i < view.FrmPrincipal.aElementosTablero.length; i++) {
				view.FrmPrincipal.aElementosTablero[i].setVisible(true);
			}
			bEmpezar++;
		} else if (bEmpezar == 1) {
			for (int i = 1; i < view.FrmPrincipal.aElementosTablero.length; i++) {
				view.FrmPrincipal.aElementosTablero[i].setVisible(false);
			}
			bEmpezar++;
		}

	}

}
