package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.UsuarioInterface;
import model.Usuario;
import utils.MySQLConexion8;

public class GestionUsuario implements UsuarioInterface{

	@Override
	public Usuario validar(String usuario, String clave) {
		Usuario u = null;
		//Plantilla de bd
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet  rs = null;
				try {
					con = MySQLConexion8.getConexion();
					String sql = "SELECT * FROM tb_rusuario where usuario = ? and clave = ?;";	
					pst = con.prepareStatement(sql);				
					pst.setString(1, usuario);
					pst.setString(2, clave);
					rs = pst.executeQuery();
					
					if(rs.next()) {
						u=new Usuario(rs.getString(2), rs.getString(3), usuario, clave, rs.getString(6), rs.getInt(7));
						
					}
				}catch(Exception e) {
					System.out.println("Error en listar : " + e.getMessage());
				}finally {
					MySQLConexion8.closeConexion(con);
				}
		
		
		return u;
	}

	@Override
	public int registrar(Usuario u) {
		int rs = 0;
		// Plantilla de bd
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_rusuario values (null,?,?,?,?,?,?,default,default)";		
			pst = con.prepareStatement(sql);
			
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getUsuario());
			pst.setString(4, u.getClave());
			pst.setString(5, u.getFnacim());
			pst.setInt(6, u.getEcvivil());
			rs = pst.executeUpdate();
		}catch(Exception e) {
			System.out.println("Error >>>> Registrar Producto:" + 
					e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return rs;
	}
	
}
