package ej3.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnectionEj3 {

	public Connection getNewConnection() throws SQLException {
		String urlConexion = "jdbc:mariadb://localhost:3306/sakila";
		String claseDriver = "org.mariadb.jdbc.Driver";
		String usuario = "sakila";
		String password = "sakila";

		try {
			Class.forName(claseDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Connection conn = DriverManager.getConnection(urlConexion, usuario, password);
		return DriverManager.getConnection(urlConexion, usuario, password);
	}

}
