package model;

public class Producto {
	private String codprod;
	private String descripcion;
	private int cantidad;
	private String fllegada;
	private String fentrega;
	private String direccion;
	private int codmod;
	private int codestacion;
	
	@Override
	public String toString() {
		return "Producto [codprod=" + codprod + ", descripcion=" + descripcion + ", cantidad=" + cantidad
				+ ", fllegada=" + fllegada + ", fentrega=" + fentrega + ", direccion=" + direccion + ", codmod="
				+ codmod + ", codestacion=" + codestacion + "]";
	}

	public Producto() {
	}
	
	public Producto(String codprod, String descripcion, int cantidad, String fllegada, String fentrega, String direccion,
			int codmod, int codestacion) {
		this.codprod = codprod;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.fllegada = fllegada;
		this.fentrega = fentrega;
		this.direccion = direccion;
		this.codmod = codmod;
		this.codestacion = codestacion;
	}

	public String getCodprod() {
		return codprod;
	}

	public void setCodprod(String codprod) {
		this.codprod = codprod;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFllegada() {
		return fllegada;
	}

	public void setFllegada(String fllegada) {
		this.fllegada = fllegada;
	}

	public String getFentrega() {
		return fentrega;
	}

	public void setFentrega(String fentrega) {
		this.fentrega = fentrega;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodmod() {
		return codmod;
	}

	public void setCodmod(int codmod) {
		this.codmod = codmod;
	}

	public int getCodestacion() {
		return codestacion;
	}

	public void setCodestacion(int codestacion) {
		this.codestacion = codestacion;
	}
	
	
	

}
