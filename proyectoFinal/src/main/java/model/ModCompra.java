package model;

public class ModCompra {
	private int codmod;
	private String modalidad;
	
	
	public ModCompra() {
	}


	public ModCompra(int codmod, String modalidad) {
		this.codmod = codmod;
		this.modalidad = modalidad;
	}


	public int getCodmod() {
		return codmod;
	}


	public void setCodmod(int codmod) {
		this.codmod = codmod;
	}


	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	
	
	
	
}
