package start;

import java.util.ArrayList;

import model.Alumno;

public class Inicio {

	public ArrayList<Alumno> listadoAlumnos = new ArrayList<Alumno>();
	public static void main(String[] args) {

		ctrl.CtrlPrincipal.inicio();

	}

	
	
	public ArrayList<Alumno> getListadoAlumnos() {
		return listadoAlumnos;
	}


	public Inicio() {
		Alumno oAlumno1 = new Alumno(1, "Irene", "Cejas Gomez", (byte)0, (byte)0, (byte)1, "Comentario", (byte)0, false);
		Alumno oAlumno2 = new Alumno(2, "Anotnio", "Garcia Lopez", (byte)1, (byte)2, (byte)1, "Comentario", (byte)1, false);
		Alumno oAlumno3 = new Alumno(3, "Javier", "Lopez Gomara", (byte)0, (byte)0, (byte)1, "Comentario", (byte)0, false);
		Alumno oAlumno4 = new Alumno(4, "Francisco", "Nuniez Jimenez", (byte)0, (byte)0, (byte)1, "Comentario", (byte)0, false);
		Alumno oAlumno5 = new Alumno(5, "Miguel", "Cifredo Gomares", (byte)0, (byte)0, (byte)1, "Comentario", (byte)0, false);
		Alumno oAlumno6 = new Alumno(6, "Jesus", "Solana Guru", (byte)0, (byte)0, (byte)1, "Comentario", (byte)0, false);
		Alumno oAlumno7 = new Alumno(7, "Alberto", "Garcia Garcia", (byte)0, (byte)0, (byte)1, "Comentario", (byte)0, false);
		
		listadoAlumnos.add(oAlumno1);
		listadoAlumnos.add(oAlumno2);
		listadoAlumnos.add(oAlumno3);
		listadoAlumnos.add(oAlumno4);
		listadoAlumnos.add(oAlumno5);
		listadoAlumnos.add(oAlumno6);
		listadoAlumnos.add(oAlumno7);
	}
	
}
