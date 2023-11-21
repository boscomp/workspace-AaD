package ceu.dam.ad.examen.ej1dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ceu.dam.ad.examen.modelo.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {

	@Override
	public Long insertarCategoria(Connection conn, String nombreCategoria) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "insert into category (name) values (?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nombreCategoria);
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong(1);
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
		}
	}

	@Override
	public Categoria consultarCategoria(Connection conn, Long id) throws SQLException {
		Categoria cat = new Categoria();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from category where category_id = '" + id + "'");
			if (rs.next()) {
				cat.setId(rs.getLong("category_id"));
				cat.setName(rs.getString("name"));
				cat.setLastUpdate(rs.getDate("last_update"));
				return cat;
			} else {
				return null;
			}
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}
	}

}
