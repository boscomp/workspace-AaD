package ej1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ej1.modelo.Pelicula;

public class PeliculaDao {

	public List<Pelicula> ListaPeliculas(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<Pelicula> peliculas = new ArrayList<Pelicula>();

			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from film");
			while (rs.next()) {
				Pelicula p = new Pelicula();
				p.setId(rs.getInt("film_id"));
				p.setTitulo(rs.getString("title"));
				p.setLongitud(rs.getInt("length"));
				peliculas.add(p);
			}
			return peliculas;
		}  finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
			
		}
		
	}

}
