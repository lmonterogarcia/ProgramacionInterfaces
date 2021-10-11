package ctrl;

import java.awt.event.ActionEvent;

public class CtrlDoble {
	
	public static void calcualarDoble() {
			try {
				double dNumero  = Double.parseDouble(view.Doble.txtNumero.getText());
				dNumero = dNumero * 2;
				view.Doble.lblResultado.setForeground(view.Theme.CLR_FG_TEXTO);
				view.Doble.lblResultado.setText(Double.toString(dNumero));
			} catch (Exception e2) {
				if (view.Doble.txtNumero.getText().isEmpty()) {
					view.Doble.lblResultado.setForeground(view.Theme.CLR_BG_Resaltado);
					view.Doble.lblResultado.setText("Tiene que introducir ALGO");
				} else {
					view.Doble.lblResultado.setForeground(view.Theme.CLR_BG_Resaltado);
					view.Doble.lblResultado.setText("Solo puedes introducir NUMEROS");
				}
			}
		
	}
	
	public static void finalizarApp() {
		
		System.exit(0);
		
	}

}
