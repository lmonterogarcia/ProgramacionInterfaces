package ctrl;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Alumno;
import start.Inicio;

public class CtrlPrincipal {

	public static ArrayList<Alumno> listadoAlumnos = new ArrayList<Alumno>();
	public static int iPosicion = 0;

	public static void inicio() {
		Inicio init = new Inicio();
		listadoAlumnos = init.getListadoAlumnos();
		new view.FrmPrincipal();
		mostarAlumno(iPosicion);

	}

	private static void mostarAlumno(int iPosicion) {
		view.FrmPrincipal.txtNombre.setText(listadoAlumnos.get(iPosicion).getsNombre());
		view.FrmPrincipal.txtApellidos.setText(listadoAlumnos.get(iPosicion).getsApellidos());
		view.FrmPrincipal.cbTalla.setSelectedIndex(listadoAlumnos.get(iPosicion).getbTalla());

		switch (listadoAlumnos.get(iPosicion).getbCiclo()) {
		case 0:
			view.FrmPrincipal.rdbtnDam.setSelected(true);
			break;
		case 1:
			view.FrmPrincipal.rdbtnDaw.setSelected(true);
			break;
		default:
			view.FrmPrincipal.rdbtnAsir.setSelected(true);
			break;
		}
		
		switch (listadoAlumnos.get(iPosicion).getbTurno()) {
		case 0:
			view.FrmPrincipal.rdbtnManiana.setSelected(true);
			break;
		case 1:
			view.FrmPrincipal.rdbtnTarde.setSelected(true);
			break;
		default:
			view.FrmPrincipal.rdbtnOnLine.setSelected(true);
			break;
		}
		
		view.FrmPrincipal.txtaComentarios.setText(listadoAlumnos.get(iPosicion).getsComentario());
		view.FrmPrincipal.lstSedes.setSelectedIndex(listadoAlumnos.get(iPosicion).getbSede());
		
		if (listadoAlumnos.get(iPosicion).isBooResponsableEconomico()) {
			view.FrmPrincipal.chckReponsable.setSelected(true);
		} else {
			view.FrmPrincipal.chckReponsable.setSelected(false);
		}

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

	public static void primero() {
		mostarAlumno(0);
		iPosicion = 0;
	}
	
	public static void atras() {
		if (iPosicion > 0) {
			iPosicion--;
			mostarAlumno(iPosicion);
			
		} else {
			JOptionPane.showMessageDialog(null, "Ha llegado al primer alumno","Aviso",JOptionPane.OK_OPTION);
		}
	}
	
	public static void siguiente() {
		if (iPosicion < listadoAlumnos.size() -1) {
			iPosicion++;
			mostarAlumno(iPosicion);
			
		} else {
			JOptionPane.showMessageDialog(null, "Ha llegado al ultimo alumno","Aviso",JOptionPane.OK_OPTION);
		}
	}
	
	public static void ultimo() {
		mostarAlumno(listadoAlumnos.size() - 1);
		iPosicion = listadoAlumnos.size() - 1;
	}
	
	public static void editar() {
		view.FrmPrincipal.btnEditar.setVisible(false);
		view.FrmPrincipal.btnGuardar.setVisible(true);
		view.FrmPrincipal.btnCancelar.setVisible(true);
		view.FrmPrincipal.txtNombre.setEnabled(true);
		view.FrmPrincipal.txtApellidos.setEnabled(true);
		view.FrmPrincipal.cbTalla.setEnabled(true);
		view.FrmPrincipal.rdbtnDam.setEnabled(true);
		view.FrmPrincipal.rdbtnDaw.setEnabled(true);
		view.FrmPrincipal.rdbtnAsir.setEnabled(true);
		view.FrmPrincipal.rdbtnManiana.setEnabled(true);
		view.FrmPrincipal.rdbtnTarde.setEnabled(true);
		view.FrmPrincipal.rdbtnOnLine.setEnabled(true);
		view.FrmPrincipal.txtaComentarios.setEnabled(true);
		view.FrmPrincipal.lstSedes.setEnabled(true);
		view.FrmPrincipal.chckReponsable.setEnabled(true);
		view.FrmPrincipal.btnPrincipio.setEnabled(false);
		view.FrmPrincipal.btnAtras.setEnabled(false);
		view.FrmPrincipal.btnSiguiente.setEnabled(false);
		view.FrmPrincipal.btnUltimo.setEnabled(false);
	}
	
	public static void guardar() {
		String sNombre = view.FrmPrincipal.txtNombre.getText();
		String sApellidos = view.FrmPrincipal.txtApellidos.getText();
		byte bTalla = (byte)view.FrmPrincipal.cbTalla.getSelectedIndex();
		byte bCiclo;
		if (view.FrmPrincipal.rdbtnDam.isSelected()) {
			bCiclo = 0;
		} else if(view.FrmPrincipal.rdbtnDaw.isSelected()) {
			bCiclo = 1;
		} else {
			bCiclo = 2;
		}
		byte bTurno;
		if (view.FrmPrincipal.rdbtnManiana.isSelected()) {
			bTurno = 0;
		} else if(view.FrmPrincipal.rdbtnTarde.isSelected()) {
			bTurno = 1;
		} else {
			bTurno = 2;
		}
		
		String sComentario = view.FrmPrincipal.txtaComentarios.getText();
		byte bSede = (byte)view.FrmPrincipal.lstSedes.getSelectedIndex();
		boolean booResponsableEconomico;
		if (view.FrmPrincipal.chckReponsable.isSelected()) {
			booResponsableEconomico = true;
		} else {
			booResponsableEconomico = false;
		}
		
		Alumno oAlumno = new Alumno(listadoAlumnos.get(iPosicion).getiId(), sNombre, sApellidos, bTalla, bCiclo, bTurno, sComentario, bSede, booResponsableEconomico);
				
		listadoAlumnos.set(iPosicion, oAlumno);
		
		
		cancelar();
	}
	
	public static void cancelar() {
		view.FrmPrincipal.btnEditar.setVisible(true);
		view.FrmPrincipal.btnGuardar.setVisible(false);
		view.FrmPrincipal.btnCancelar.setVisible(false);
		view.FrmPrincipal.txtNombre.setEnabled(false);
		view.FrmPrincipal.txtApellidos.setEnabled(false);
		view.FrmPrincipal.cbTalla.setEnabled(false);
		view.FrmPrincipal.rdbtnDam.setEnabled(false);
		view.FrmPrincipal.rdbtnDaw.setEnabled(false);
		view.FrmPrincipal.rdbtnAsir.setEnabled(false);
		view.FrmPrincipal.rdbtnManiana.setEnabled(false);
		view.FrmPrincipal.rdbtnTarde.setEnabled(false);
		view.FrmPrincipal.rdbtnOnLine.setEnabled(false);
		view.FrmPrincipal.txtaComentarios.setEnabled(false);
		view.FrmPrincipal.lstSedes.setEnabled(false);
		view.FrmPrincipal.chckReponsable.setEnabled(false);
		view.FrmPrincipal.btnPrincipio.setEnabled(true);
		view.FrmPrincipal.btnAtras.setEnabled(true);
		view.FrmPrincipal.btnSiguiente.setEnabled(true);
		view.FrmPrincipal.btnUltimo.setEnabled(true);
		mostarAlumno(iPosicion);
	}
}
