package ej2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import ej2.modelo.ClienteEj2;

public class ClienteDao {

	public List <ClienteEj2> listaClientes (Connection conn) throws SQLException{

		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<ClienteEj2> clientes = new ArrayList<ClienteEj2>();

			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from customer");
			while (rs.next()) {
				ClienteEj2 c = new ClienteEj2();
				c.setId(rs.getInt("customer_id"));
				c.setNombre(rs.getString("first_name"));
				c.setApellido(rs.getString("last_name"));
				c.setEmail(rs.getString("email"));
				c.setActivo(rs.getBoolean("active"));
				clientes.add(c);
			}
			return clientes;
		}  finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
			
		}
		
	}
	

}
