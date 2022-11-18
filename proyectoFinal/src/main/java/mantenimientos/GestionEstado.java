package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.EstadoInterface;
import model.Estado;
import utils.MySQLConexion8;

public class GestionEstado implements EstadoInterface{

	@Override
	public ArrayList<Estado> listaEstado() {
		ArrayList<Estado> lista = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet  rs = null;
		try {
			con = MySQLConexion8.getConexion();
			
			String sql = "select*from tb_ecivil;";	
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			//-----------
			lista = new ArrayList<Estado>();
			while(rs.next()) {
				lista.add(new Estado(rs.getInt(1), rs.getString(2)));
			}
		}catch(Exception e) {
			System.out.println("Error en listado : " + e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		return lista;
	}
	
}
