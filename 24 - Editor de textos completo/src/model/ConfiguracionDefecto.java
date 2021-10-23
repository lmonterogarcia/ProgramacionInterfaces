package model;


import java.awt.*;
import java.io.Serializable;
import java.util.Objects; 

public class ConfiguracionDefecto implements Serializable {

	private Font fntPredemeditada;
	private Color clrFondo, clrFuente;
	
	public ConfiguracionDefecto() {
		setFntPredemeditada(null);
		setClrFondo(null);
		setClrFuente(null);
	}
	
	public ConfiguracionDefecto(Font fntPredemeditada, Color clrFondo, Color clrFuente) {
		setFntPredemeditada(fntPredemeditada);
		setClrFondo(clrFondo);
		setClrFuente(clrFuente);
	}
	
	public Font getFntPredemeditada() {
		return fntPredemeditada;
	}
	public void setFntPredemeditada(Font fntPredemeditada) {
		if (fntPredemeditada != null) {
			this.fntPredemeditada = fntPredemeditada;
		}
	}
	public Color getClrFondo() {
		return clrFondo;
	}
	public void setClrFondo(Color clrFondo) {
		if (clrFondo != null) {
			this.clrFondo = clrFondo;
		}
	}
	public Color getClrFuente() {
		return clrFuente;
	}
	public void setClrFuente(Color clrFuente) {
		if (clrFuente != null) {
			this.clrFuente = clrFuente;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(clrFondo, clrFuente, fntPredemeditada);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfiguracionDefecto other = (ConfiguracionDefecto) obj;
		return Objects.equals(clrFondo, other.clrFondo) && Objects.equals(clrFuente, other.clrFuente)
				&& Objects.equals(fntPredemeditada, other.fntPredemeditada);
	}
	@Override
	public String toString() {
		return "ConfiguracionDefecto [fntPredemeditada=" + fntPredemeditada + ", clrFondo=" + clrFondo + ", clrFuente="
				+ clrFuente + "]";
	}
	
	
	
	
	
}
