package model;

public class Coche {

	
	private Integer iId;
	private String sMarca;
	private String sModelo;
	private Integer iPotencia;
	
	public Coche() {
		
	}

	public Coche(Integer iId, String sMarca, String sModelo, Integer iPotencia) {
		this.iId = iId;
		this.sMarca = sMarca;
		this.sModelo = sModelo;
		this.iPotencia = iPotencia;
	}



	public Coche(String sMarca, String sModelo, Integer iPotencia) {
		this.sMarca = sMarca;
		this.sModelo = sModelo;
		this.iPotencia = iPotencia;
	}

	public Integer getiId() {
		return iId;
	}

	public void setiId(Integer iId) {
		this.iId = iId;
	}

	public String getsMarca() {
		return sMarca;
	}

	public void setsMarca(String sMarca) {
		this.sMarca = sMarca;
	}

	public String getsModelo() {
		return sModelo;
	}

	public void setsModelo(String sModelo) {
		this.sModelo = sModelo;
	}

	public Integer getiPotencia() {
		return iPotencia;
	}

	public void setiPotencia(Integer iPotencia) {
		this.iPotencia = iPotencia;
	}
	
	
}
