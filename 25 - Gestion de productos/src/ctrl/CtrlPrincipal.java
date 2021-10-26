package ctrl;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.PnlCrearProducto;
import view.PnlVisualizarProducto;

public class CtrlPrincipal {

	private static GestionFch gstFch = new GestionFch();
	
	public static void inicio() {
		gstFch.leerProductos();
		new view.FrmPrincipal();

	}

	public static void elegirPanel() {
		int iCategoria;
		boolean booProductoNuevo = true;

		iCategoria = view.FrmPrincipal.lstCategorias.getSelectedIndex();

		switch (iCategoria) {
		case 0:
			if (gstFch.getListadoMac().size() > 0) {
				booProductoNuevo = false;
			}
			break;
		case 1:
			if (gstFch.getListadoIpad().size() > 0) {
				booProductoNuevo = false;
			}
			break;
		case 2:
			if (gstFch.getListadoIphone().size() > 0) {
				booProductoNuevo = false;
			}
			break;
		case 3:
			if (gstFch.getListadoWatch().size() > 0) {
				booProductoNuevo = false;
			}
			break;
		case 4:
			if (gstFch.getListadoAirpods().size() > 0) {
				booProductoNuevo = false;
			}
			break;
		default:
			if (gstFch.getListadoAccesorios().size() > 0) {
				booProductoNuevo = false;
			}
			break;
		}
		
		if (booProductoNuevo) {
			view.FrmPrincipal.pnlContenido.removeAll();
			view.FrmPrincipal.pnlContenido.add(new PnlCrearProducto(), BorderLayout.CENTER);
			view.FrmPrincipal.pnlContenido.repaint();
			view.FrmPrincipal.pnlContenido.revalidate();
			
		} else {
			view.FrmPrincipal.pnlContenido.removeAll();
			view.FrmPrincipal.pnlContenido.add(new PnlVisualizarProducto(), BorderLayout.CENTER);
			view.FrmPrincipal.pnlContenido.repaint();
			view.FrmPrincipal.pnlContenido.revalidate();
		}
		
	}

	public static void salir() {

		int iOpcSeleccionada = JOptionPane.showConfirmDialog(null, "Desea salir?", "Asistente de salida",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (iOpcSeleccionada == JOptionPane.YES_OPTION) {

			gstFch.guardarProductos();
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} else if (iOpcSeleccionada == JOptionPane.NO_OPTION) {
			view.FrmPrincipal.ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		}

	}

}
