package ctrl;

import java.awt.Color;

import javax.swing.JOptionPane;

import view.Principal;

public class CtrPrincipal {

	public static int numPreg;

	public static void inicio() {
		model.Languages.cargarLenguajes();
		generarNumPreguntas();

		new view.Principal();
		view.Principal.lblTest.setText(model.Languages.aEng.get(numPreg));
	}

	public static void generarNumPreguntas() {
		numPreg = (int)(Math.random()*(model.Languages.aEsp.size()));
	}

	public static void seguimos() {
		byte bSeleccion = -1;

		if (model.Languages.aEsp.size() != 0) {
			verificar();
		} else {
			bSeleccion = (byte) JOptionPane.showConfirmDialog(null, "Quieres empezar de nuevo?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (bSeleccion == 0) {
				model.Languages.cargarLenguajes();
				reiniciar();
			} else if (bSeleccion == 1){
				System.exit(0);
			}
		}
		
	}

	public static void verificar() {
		Color CL_FALSE = new Color(255,50,50);
		Color CL_TRUE  = new Color(50,50,255);

		int iOpcSelected = 1;
		if(model.Languages.aEsp.get(numPreg).equals(view.Principal.tfEscritura.getText().toUpperCase())) {
			view.Principal.lblResultado.setText("CORRECTO!");
			view.Principal.lblResultado.setForeground(CL_TRUE);
			model.Languages.aEsp.remove(numPreg);
			model.Languages.aEng.remove(numPreg);
			if (!model.Languages.aEsp.isEmpty()) {
				iOpcSelected = JOptionPane.showConfirmDialog(null,"Quiere otra palabra?","Idiomas",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(iOpcSelected == 0) {
					reiniciar();
				} else {
					System.exit(0);
				}
			} else {
				seguimos();
			}

		}
		else {
			view.Principal.lblResultado.setText("INCORRECTO!");
			view.Principal.lblResultado.setForeground(CL_FALSE);
		}
	}
	
	private static void reiniciar() {
		generarNumPreguntas();
		view.Principal.lblTest.setText(model.Languages.aEng.get(numPreg));
		view.Principal.lblResultado.setText("");
		view.Principal.tfEscritura.setText("");
	}
}
