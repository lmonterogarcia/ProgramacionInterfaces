package ctrl;

import view.Theme;

public class CtrlCalculo {

	public static void calcualarDoble() {
		try {
			double dNumero  = Double.parseDouble(view.MiniCalculo.txtNumero.getText());
			dNumero = dNumero * 2;
			view.MiniCalculo.lblResultado.setFont(Theme.FNT_LBL_TITULO);
			view.MiniCalculo.lblResultado.setForeground(view.Theme.CLR_FG_TEXTO);
			view.MiniCalculo.lblResultado.setText(Double.toString(dNumero));
			view.MiniCalculo.lblResultado.setFont(Theme.FNT_LBL_RESULTADO);
		} catch (Exception e2) {
			errores();
		}
	}

	public static void calcualarTriple() {
		try {
			double dNumero  = Double.parseDouble(view.MiniCalculo.txtNumero.getText());
			dNumero = dNumero * 3;
			view.MiniCalculo.lblResultado.setFont(Theme.FNT_LBL_TITULO);
			view.MiniCalculo.lblResultado.setForeground(view.Theme.CLR_FG_TEXTO);
			view.MiniCalculo.lblResultado.setText(Double.toString(dNumero));
			view.MiniCalculo.lblResultado.setFont(Theme.FNT_LBL_RESULTADO);
		} catch (Exception e2) {
			errores();
		}
	}

	public static void calcualarMitad() {
		try {
			double dNumero  = Double.parseDouble(view.MiniCalculo.txtNumero.getText());
			dNumero = dNumero / 2;
			view.MiniCalculo.lblResultado.setFont(Theme.FNT_LBL_TITULO);
			view.MiniCalculo.lblResultado.setForeground(view.Theme.CLR_FG_TEXTO);
			view.MiniCalculo.lblResultado.setText(Double.toString(dNumero));
			view.MiniCalculo.lblResultado.setFont(Theme.FNT_LBL_RESULTADO);
		} catch (Exception e2) {
			errores();
		}
	}

	public static void finalizarApp() {

		System.exit(0);

	}

	private static void errores() {
		if (view.MiniCalculo.txtNumero.getText().isEmpty()) {
			view.MiniCalculo.lblResultado.setForeground(view.Theme.CLR_BG_Resaltado);
			view.MiniCalculo.lblResultado.setText("Tiene que introducir ALGO");
		} else {
			view.MiniCalculo.lblResultado.setForeground(view.Theme.CLR_BG_Resaltado);
			view.MiniCalculo.lblResultado.setText("Solo puedes introducir NUMEROS");
		}
	}
}
