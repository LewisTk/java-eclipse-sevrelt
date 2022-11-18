package interfaces;

import java.util.List;

import model.RegistroProductoLlegada;

public interface RegistroInterface {
	public int registrar (RegistroProductoLlegada r);
	public List<RegistroProductoLlegada> listado();
	
	public RegistroProductoLlegada buscar(String idprod);
}
