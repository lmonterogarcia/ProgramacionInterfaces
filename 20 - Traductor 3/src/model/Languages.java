package model;

import java.util.ArrayList;

public class Languages {
	
	public static ArrayList<String> aPreguntas = new ArrayList<String>();
	public static ArrayList<String> aRespuestas = new ArrayList<String>();
	
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
	
	public static void engEsp(){
		aPreguntas.addAll(aEng);
		aRespuestas.addAll(aEsp);
	}
	
	public static void espEng(){
		aPreguntas.addAll(aEsp);
		aRespuestas.addAll(aEng);
	}
	
	public static void indiferente(){
		
		aPreguntas.addAll(aEng);
		aPreguntas.addAll(aEsp);
		
		aRespuestas.addAll(aEsp);
		aRespuestas.addAll(aEng);
	}
}
