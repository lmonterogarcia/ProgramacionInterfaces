package model;

public class Chaleco {

	private int iID;
	private String sModelo;
	private int iColor, iTalla;
	private double dPrecio;
	private int iStock;
	
	public Chaleco() {
		
	}

	public Chaleco(String sModelo, int iColor, int iTalla, double dPrecio, int iStock) {
		this.sModelo = sModelo;
		this.iColor = iColor;
		this.iTalla = iTalla;
		this.dPrecio = dPrecio;
		this.iStock = iStock;
	}
	
	public Chaleco(int iID, String sModelo, int iColor, int iTalla, double dPrecio, int iStock) {
		this.iID = iID;
		this.sModelo = sModelo;
		this.iColor = iColor;
		this.iTalla = iTalla;
		this.dPrecio = dPrecio;
		this.iStock = iStock;
	}

	public int getiID() {
		return iID;
	}

	public void setiID(int iID) {
		this.iID = iID;
	}

	public String getsModelo() {
		return sModelo;
	}

	public void setsModelo(String sModelo) {
		this.sModelo = sModelo;
	}

	public int getiColor() {
		return iColor;
	}

	public void setiColor(int iColor) {
		this.iColor = iColor;
	}

	public int getiTalla() {
		return iTalla;
	}

	public void setiTalla(int iTalla) {
		this.iTalla = iTalla;
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

	@Override
	public String toString() {
		return "Chaleco [iID=" + iID + ", sModelo=" + sModelo + ", iColor=" + iColor + ", iTalla=" + iTalla
				+ ", dPrecio=" + dPrecio + ", iStock=" + iStock + "]";
	}
	
	
	
	
}
