package model;

public class Estado {
	private int codEcivil;
	private String eCivil;
	
	
	public Estado() {
	}


	public Estado(int codEcivil, String eCivil) {
		this.codEcivil = codEcivil;
		this.eCivil = eCivil;
	}
	
	
	public int getCodEcivil() {
		return codEcivil;
	}
	public void setCodEcivil(int codEcivil) {
		this.codEcivil = codEcivil;
	}
	public String geteCivil() {
		return eCivil;
	}
	public void seteCivil(String eCivil) {
		this.eCivil = eCivil;
	}
	
	

}
