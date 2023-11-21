package ceu.dam.ad.examen.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {

	public Connection getNewConnection() throws SQLException {
		String urlConexion = "jdbc:mariadb://localhost:3306/sakila";
		String claseDriver = "org.mariadb.jdbc.Driver";
		String usuario = "sakila";
		String password = "sakila";

		try {
			Class.forName(claseDriver);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		Connection conn = DriverManager.getConnection(urlConexion, usuario, password);
		return DriverManager.getConnection(urlConexion, usuario, password);

	}

}
