package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.ProductoInterface;
import model.Producto;
import utils.MySQLConexion8;

public class GestionProductos implements ProductoInterface{
	
	public List<Producto> listar() {
		List<Producto> lista = null;
		// Plantilla de bd
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_pcomprados";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			//-------------------------------
			lista = new ArrayList<Producto>();
			while (rs.next()) {
				lista.add(new Producto(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7), rs.getInt(8)));
			}
		}		
		catch (Exception e)
		{
			System.out.println("ERROR AL LISTAR : " + e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		return lista ;
	}

	@Override
	public int actualizar(Producto p) {
		int rs = 0;
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update tb_pcomprados set direntrega=?, codmod=?, codEstacion=? where codprod=?";	
			pst = con.prepareStatement(sql);
			pst.setString(1,p.getDireccion());
			pst.setInt(2, p.getCodmod());
			pst.setInt(3, p.getCodestacion());
			pst.setString(4, p.getCodprod());
			rs = pst.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return rs;
	}

	@Override
	public Producto buscar(String idprod) {
		Producto p = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "SELECT * FROM tb_pcomprados where codprod = ?;";	
			pst = con.prepareStatement(sql);
			
			pst.setString(1, idprod);
			rs = pst.executeQuery();
			//-----------
			
			if(rs.next()) {
				p = new Producto(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
				}
		}catch(Exception e) {
			System.out.println("Error en listar : " + e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return p;
	}
	
	@Override
	public Producto borrar(String idprod) {
		Producto b = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "delete from tb_pcomprados where codprod = ?;";	
			pst = con.prepareStatement(sql);
			
			pst.setString(1, idprod);
			pst.executeUpdate();
			//-----------
			
		}catch(Exception e) {
			System.out.println("Error en b : " + e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return null;
	}
}
