package interfaces;

import java.util.List;

import model.Producto;

public interface ProductoInterface {
	public List<Producto> listar();
	public int actualizar(Producto p);
	
	public Producto buscar(String idprod);
	public Producto borrar(String idprod);
	

}
