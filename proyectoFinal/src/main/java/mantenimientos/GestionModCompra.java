package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.ModCompraInterface;
import model.ModCompra;
import utils.MySQLConexion8;

public class GestionModCompra implements ModCompraInterface{

	@Override
	public ArrayList<ModCompra> listaModCompra() {
		ArrayList<ModCompra> lista = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet  rs = null;
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "select*from tb_modCompra;";	
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			//-----------
			lista = new ArrayList<ModCompra>();
			while(rs.next()) {
				lista.add(new ModCompra(rs.getInt(1), rs.getString(2)));
			}
		}catch(Exception e) {
			System.out.println("Error en listado : " + e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		return lista;
	}
}
