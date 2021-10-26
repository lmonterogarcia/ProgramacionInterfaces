package model;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {
 
	private int iId;
	private String sNombre;
	private double dPrecio;
	private int iStock;
	private boolean booFragil;
	private String sCategoria;
	
	public Producto() {
		this.iId = -1;
		this.sNombre = "";
		this.dPrecio = -1;
		this.iStock = -1;
		this.booFragil = false;
		this.sCategoria = "";
	}
	
	public Producto(int iId) {
		setiId(iId);
		this.sNombre = "";
		this.dPrecio = -1;
		this.iStock = -1;
		this.booFragil = false;
		this.sCategoria = "";
	}
	
	public Producto(int iId, String sNombre, double dPrecio, int iStock, boolean booFragil, String sCategoria) {
		setiId(iId);
		setsNombre(sNombre);
		setdPrecio(dPrecio);
		setiStock(iStock);
		setBooFragil(booFragil);
		setsCategoria(sCategoria);
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

	public double getdPrecio() {
		return dPrecio;
	}

	public void setdPrecio(double dPrecio) {
		this.dPrecio = dPrecio;
	}

	public int getiStock() {
		return iStock;
	}

	public void setiStock(int iStock) {
		this.iStock = iStock;
	}

	public boolean isBooFragil() {
		return booFragil;
	}

	public void setBooFragil(boolean booFragil) {
		this.booFragil = booFragil;
	}

	public String getsCategoria() {
		return sCategoria;
	}

	public void setsCategoria(String sCategoria) {
		this.sCategoria = sCategoria;
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
		Producto other = (Producto) obj;
		return iId == other.iId;
	}

	@Override
	public String toString() {
		return "Producto [iId=" + iId + ", sNombre=" + sNombre + ", dPrecio=" + dPrecio + ", iStock=" + iStock
				+ ", booFragil=" + booFragil + ", sCategoria=" + sCategoria + "]";
	}
	
	
	
	
}
