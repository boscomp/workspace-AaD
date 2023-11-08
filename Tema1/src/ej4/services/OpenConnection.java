package ej4.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {

	public Connection getNewConnection() throws SQLException {
		String urlConexion = "jdbc:mariadb://localhost:3306/pedidos";
		String claseDriver = "org.mariadb.jdbc.Driver";
		String usuario = "pedidos";
		String password = "pedidos";

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
