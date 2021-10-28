package model;

import java.util.Objects;

public class Alumno {

	private int iId;
	private String sNombre;
	private String sApellidos;
	private byte bTalla, bCiclo, bTurno;
	private String sComentario;
	private byte bSede;
	boolean booResponsableEconomico;
	
	public Alumno() {
		this.iId = -1;
		this.sNombre = "";
		this.sApellidos = "";
		this.bTalla = -1;
		this.bCiclo = -1;
		this.bTurno = -1;
		this.sComentario = "";
		this.bSede = -1;
		this.booResponsableEconomico = false;
	}
	
	public Alumno(int iId) {
		setiId(iId);
		this.sNombre = "";
		this.sApellidos = "";
		this.bTalla = -1;
		this.bCiclo = -1;
		this.bTurno = -1;
		this.sComentario = "";
		this.bSede = -1;
		this.booResponsableEconomico = false;
	}
	
	public Alumno(int iId, String sNombre, String sApellidos, byte bTalla, byte bCiclo, byte bTurno, String sComentario,
			byte bSede, boolean booResponsableEconomico) {
		setiId(iId);
		setsNombre(sNombre);
		setsApellidos(sApellidos);
		setbTalla(bTalla);
		setbCiclo(bCiclo);
		setbTurno(bTurno);
		setsComentario(sComentario);
		setbSede(bSede);
		setBooResponsableEconomico(booResponsableEconomico);
	}

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsApellidos() {
		return sApellidos;
	}

	public void setsApellidos(String sApellidos) {
		this.sApellidos = sApellidos;
	}

	public byte getbTalla() {
		return bTalla;
	}

	public void setbTalla(byte bTalla) {
		this.bTalla = bTalla;
	}

	public byte getbCiclo() {
		return bCiclo;
	}

	public void setbCiclo(byte bCiclo) {
		this.bCiclo = bCiclo;
	}

	public byte getbTurno() {
		return bTurno;
	}

	public void setbTurno(byte bTurno) {
		this.bTurno = bTurno;
	}

	public String getsComentario() {
		return sComentario;
	}

	public void setsComentario(String sComentario) {
		this.sComentario = sComentario;
	}

	public byte getbSede() {
		return bSede;
	}

	public void setbSede(byte bSede) {
		this.bSede = bSede;
	}

	public boolean isBooResponsableEconomico() {
		return booResponsableEconomico;
	}

	public void setBooResponsableEconomico(boolean booResponsableEconomico) {
		this.booResponsableEconomico = booResponsableEconomico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(iId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return iId == other.iId;
	}

	@Override
	public String toString() {
		return "Alumno [iId=" + iId + ", sNombre=" + sNombre + ", sApellidos=" + sApellidos + ", bTalla=" + bTalla
				+ ", bCiclo=" + bCiclo + ", bTurno=" + bTurno + ", sComentario=" + sComentario + ", bSede=" + bSede
				+ ", booResponsableEconomico=" + booResponsableEconomico + "]";
	}

	
	
	
	
}
