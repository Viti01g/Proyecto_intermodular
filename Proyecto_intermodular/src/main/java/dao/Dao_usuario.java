package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Usuario;

public class Dao_usuario {

	public static Connection con = null;
	
	public Dao_usuario() throws SQLException
	{
		this.con = DBConexion.getConexion();
	}
	
public void insertar(Usuario u) throws SQLException {
		
		String sql = "INSERT INTO usuarios (nombre,apellido_1,apellido_2,dni,cargo,sexo) VALUES (?,?,?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellido1());
		ps.setString(3, u.getApellido2());
		ps.setString(4, u.getDni());
		ps.setString(5, u.getCargo());
		ps.setString(6, u.getSexo());
		
		int filas = ps.executeUpdate();
		ps.close();
		
	}
	
	public void actualizar(Usuario u) throws SQLException {
		String sql = "UPDATE usuarios SET nombre=?,apellido_1=?,apellido_2=?,dni=?,cargo=?,sexo=? WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellido1());
		ps.setString(3, u.getApellido2());
		ps.setString(4, u.getDni());
		ps.setString(5, u.getCargo());
		ps.setString(6, u.getSexo());
		ps.setInt(7,u.getId());
		
		int filas = ps.executeUpdate();
		ps.close();
		
		
		
	}
	
	public void borrar(int id) throws SQLException {
		
		String sql = "DELETE FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		int filas = ps.executeUpdate();
		ps.close();
	}
	
	
	public Usuario obtenerPorID(int id) throws SQLException {
		
		String sql = "SELECT * FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Usuario u = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));

		return u;
	}

	
	public ArrayList<Usuario> listar() throws SQLException{
		
		String sql = "SELECT * FROM usuarios";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> ls = null;
		
		while(rs.next()) {	
			if(ls == null) {
				ls = new ArrayList<Usuario>();
			}
			
			ls.add(new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
		}	
		return ls;

	}
	
	
	/*public Usuario listar(String tel) throws SQLException{
		
	//Mirar que hace en la clase
		String sql = "SELECT * FROM usuarios WHERE tel=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tel);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Usuario> ls = null;
		rs.next();	
		Usuario u = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			
		return u;
	
	}*/
	
	
	public String listarJson() throws SQLException {
		
		String json = "";	
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		
		return json;
	
	}
}
