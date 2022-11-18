package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.RegistroInterface;
import model.RegistroProductoLlegada;
import utils.MySQLConexion8;

public class GestionRegistroLlegadaProducto implements RegistroInterface{

	@Override
	public int registrar(RegistroProductoLlegada r) {
		int rs=0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_registrar_llegada values(?,?,?,?,?,?)";		
			pst = con.prepareStatement(sql);
			pst.setInt(1, r.getCodreg());
			pst.setString(2, r.getCodprod());
			pst.setString(3, r.getDescripcion());
			pst.setInt(4, r.getCodestacion());
			pst.setString(5, r.getHllegada());
			pst.setString(6, r.getDescripcionActualProd());
			rs = pst.executeUpdate();
		}catch(Exception e) {
			System.out.println("Error >>>> Registrar Llegada de Producto:" + 
					e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		return rs;
	}

	@Override
	public List<RegistroProductoLlegada> listado() {
		List<RegistroProductoLlegada> listado = null;
		// Plantilla de bd
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_registrar_llegada";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			//-------------------------------
			listado = new ArrayList<RegistroProductoLlegada>();
			while (rs.next()) {
				listado.add(new RegistroProductoLlegada(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
						rs.getString(5), rs.getString(6)));
			}
		}		
		catch (Exception e)
		{
			System.out.println("ERROR AL LISTAR : " + e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		return listado ;
	}

	@Override
	public RegistroProductoLlegada buscar(String idprod) {
		RegistroProductoLlegada r = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "SELECT * FROM tb_registrar_llegada where cod_reg = ?;";	
			pst = con.prepareStatement(sql);
			
			pst.setString(1, idprod);
			rs = pst.executeQuery();
			//-----------
			
			if(rs.next()) {
				r = new RegistroProductoLlegada(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
						rs.getString(5), rs.getString(6));
				}
		}catch(Exception e) {
			System.out.println("Error en listar : " + e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return r;
	}
	
}
