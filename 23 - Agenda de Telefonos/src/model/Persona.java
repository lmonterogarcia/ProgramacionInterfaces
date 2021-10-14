package model;

import java.util.Objects;

public class Persona {

	private String sNombre, sNumTel;
	
	public Persona() {
		this.sNombre = "";
		this.sNumTel = "";
	}

	public Persona(String sNombre, String sNumTel) {
		setsNombre(sNombre);
		setsNumTel(sNumTel);
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsNumTel() {
		return sNumTel;
	}

	public void setsNumTel(String sNumTel) {
		this.sNumTel = sNumTel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sNombre, sNumTel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(sNombre, other.sNombre) && Objects.equals(sNumTel, other.sNumTel);
	}

	@Override
	public String toString() {
		return "Persona [sNombre=" + sNombre + ", sNumTel=" + sNumTel + "]";
	}
	
	
}
