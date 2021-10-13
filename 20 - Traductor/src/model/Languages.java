package model;

import java.util.ArrayList;

public class Languages {
	public static ArrayList<String> aEng = new ArrayList<String>();
	public static ArrayList<String> aEsp = new ArrayList<String>();
	
	public static void cargarLenguajes() {
		aEng.add("HELLO");
		aEng.add("CAT");
		aEng.add("DOG");
		aEng.add("MONDAY");
		aEng.add("PLAY");
		
		aEsp.add("HOLA");
		aEsp.add("GATO");
		aEsp.add("PERRO");
		aEsp.add("LUNES");
		aEsp.add("JUGAR");
	}
}
