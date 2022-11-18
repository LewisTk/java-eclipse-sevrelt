package model;

public class RegistroProductoLlegada {
	private int codreg;
	private String codprod;
	private String descripcion;
	private int codestacion;
	private String hllegada;
	private String descripcionActualProd;
	
	public RegistroProductoLlegada() {
	}

	public RegistroProductoLlegada(int codreg, String codprod, String descripcion, int codestacion, String hllegada,
			String descripcionActualProd) {
		this.codreg = codreg;
		this.codprod = codprod;
		this.descripcion = descripcion;
		this.codestacion = codestacion;
		this.hllegada = hllegada;
		this.descripcionActualProd = descripcionActualProd;
	}

	public int getCodreg() {
		return codreg;
	}

	public void setCodreg(int codreg) {
		this.codreg = codreg;
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

	public int getCodestacion() {
		return codestacion;
	}

	public void setCodestacion(int codestacion) {
		this.codestacion = codestacion;
	}

	public String getHllegada() {
		return hllegada;
	}

	public void setHllegada(String hllegada) {
		this.hllegada = hllegada;
	}

	public String getDescripcionActualProd() {
		return descripcionActualProd;
	}

	public void setDescripcionActualProd(String descripcionActualProd) {
		this.descripcionActualProd = descripcionActualProd;
	}
	
	
	
	
	
	
}
