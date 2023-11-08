package servicio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Actor;
import servicio.OpenConnection;

public class ActoresServices {
	private OpenConnection openConn;
	
	public List <Actor> consultarActores() throws ActoresServicesException {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			List <Actor> actores = new ArrayList<Actor>();
			conn= new OpenConnection().getNewConnection();
			
//			stmt=conn.createStatement();
//			rs=stmt.executeQuery("SELECT * FROM ACTOR");
			String sql = "select * from actor";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Actor a = new Actor();
				a.setId(rs.getInt("actor_id"));
				a.setNombre(rs.getString("first_name"));
				a.setApellido(rs.getString("last_name"));
				actores.add(a);
				return actores;
			}
		}
			catch (SQLException e) {
				System.err.println("Ha habido un error en la base de datos: "+e.getMessage());
				
				throw new ActoresServicesException("Error al obtener datos", e);
			
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
			
			}
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
		
		return null;
	}
}
