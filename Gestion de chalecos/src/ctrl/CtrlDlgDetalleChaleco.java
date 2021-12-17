package ctrl;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Chaleco;

public class CtrlDlgDetalleChaleco {

	private static int iControl, iColor;
	private static Chaleco oChaleco;

	public static void detalleInicio(int iVentanaControl, Chaleco oVentanaChaleco) {
		iControl = iVentanaControl;
		oChaleco = oVentanaChaleco;
		if (iControl != 2) {
			iColor = oChaleco.getiColor();
		}

		new view.DlgDetalleChaleco();
	};

	public static void rellenarDatos() {

		switch (iControl) {
		case 0:
			rellenarDatosNuevo();
			view.DlgDetalleChaleco.ventana.setTitle("Creacion de Chaleco");
			break;
		case 1:
			rellenarDatosEditar();
			view.DlgDetalleChaleco.ventana.setTitle("Modificacion de Chaleco");
			break;
		case 2:
			rellenarDatosConsultar();
			view.DlgDetalleChaleco.ventana.setTitle("Consulta de Chaleco");
			break;
		}
	}

	private static void rellenarDatosNuevo() {

		rojo();

	}

	private static void rellenarDatosEditar() {

		view.DlgDetalleChaleco.txtModelo.setText(oChaleco.getsModelo());
		view.DlgDetalleChaleco.lblColorChaleco.setText(model.IChaleco.sColor[oChaleco.getiColor()]);
		view.DlgDetalleChaleco.cbTalla.setSelectedIndex(oChaleco.getiTalla());
		view.DlgDetalleChaleco.txtPrecio.setText(oChaleco.getdPrecio() + "");
		view.DlgDetalleChaleco.txtStock.setText(oChaleco.getiStock() + "");
	}

	private static void rellenarDatosConsultar() {

		rellenarDatosEditar();

		view.DlgDetalleChaleco.txtModelo.setEditable(false);
		view.DlgDetalleChaleco.cbTalla.setEnabled(false);
		view.DlgDetalleChaleco.cbTalla.setEditable(false);
		view.DlgDetalleChaleco.txtPrecio.setEditable(false);
		view.DlgDetalleChaleco.txtStock.setEditable(false);
		view.DlgDetalleChaleco.btnGuardar.setVisible(false);
		view.DlgDetalleChaleco.btnRojo.setVisible(false);
		view.DlgDetalleChaleco.btnVerde.setVisible(false);
		view.DlgDetalleChaleco.btnAzul.setVisible(false);
		view.DlgDetalleChaleco.btnAmarillo.setVisible(false);

	}

	public static void cancelar() {
		view.DlgDetalleChaleco.ventana.dispose();
	}

	public static void guardar() {
		switch (iControl) {
		case 0:
			Nuevo();
			break;
		case 1:
			Editar();
			break;
		}
	}

	private static void Editar() {

		try {
			logic.LogConsultas.modificar(modificarChaleco());
			view.DlgDetalleChaleco.ventana.dispose();
			ctrl.CtrlFrmPrincipal.actualizar();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Chaleco modificarChaleco() {

		String sModelo = view.DlgDetalleChaleco.txtModelo.getText();
		int iTalla = view.DlgDetalleChaleco.cbTalla.getSelectedIndex();
		double dPrecio = Double.parseDouble(view.DlgDetalleChaleco.txtPrecio.getText());
		int iStock = Integer.parseInt(view.DlgDetalleChaleco.txtStock.getText());

		oChaleco.setsModelo(sModelo);
		oChaleco.setiColor(iColor);
		oChaleco.setiTalla(iTalla);
		oChaleco.setdPrecio(dPrecio);
		oChaleco.setiStock(iStock);

		return oChaleco;
	}

	private static void Nuevo() {
		if (view.DlgDetalleChaleco.txtModelo.getText().equals("")
				|| view.DlgDetalleChaleco.txtPrecio.getText().equals("")
				|| view.DlgDetalleChaleco.txtStock.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
		} else {
			try {
				logic.LogConsultas.insertar(crearChaleco());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			view.DlgDetalleChaleco.ventana.dispose();
			ctrl.CtrlFrmPrincipal.actualizar();
		}

	}

	private static Chaleco crearChaleco() {

		String sModelo = view.DlgDetalleChaleco.txtModelo.getText();
		int iTalla = view.DlgDetalleChaleco.cbTalla.getSelectedIndex();
		double dPrecio = Double.parseDouble(view.DlgDetalleChaleco.txtPrecio.getText());
		int iStock = Integer.parseInt(view.DlgDetalleChaleco.txtStock.getText());

		return new Chaleco(sModelo, iColor, iTalla, dPrecio, iStock);

	}

	public static void rojo() {
		if (iControl != 2) {
			iColor = 0;
			view.DlgDetalleChaleco.lblColorChaleco.setText("Rojo");
		}
	}

	public static void verde() {
		if (iControl != 2) {
			iColor = 1;
			view.DlgDetalleChaleco.lblColorChaleco.setText("Verde");
		}
	}

	public static void azul() {
		if (iControl != 2) {
			iColor = 2;
			view.DlgDetalleChaleco.lblColorChaleco.setText("Azul");
		}
	}

	public static void amarillo() {
		if (iControl != 2) {
			iColor = 3;
			view.DlgDetalleChaleco.lblColorChaleco.setText("Amarillo");
		}
	}
}
