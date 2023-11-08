package ej05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ej05.modelo.City;


public class CityDao {

	public List<City> getCities(Connection conn, String filtroDescripcion) throws SQLException {
		List<City> listaCiudades = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select *from city where city like '%" + filtroDescripcion + "%'");

			while (rs.next()) {
				City ciudad = new City();
				ciudad.setId(rs.getLong("city_id"));
				ciudad.setDescripcion(rs.getString("city"));
				ciudad.setCountryId(rs.getLong("country_id"));
				listaCiudades.add(ciudad);
			}
		
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}

		}

		return listaCiudades;

	}

	public City getCity(Connection conn, Long id) throws SQLException {
		City c = new City();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from city where city_id = " + id);

			if (rs.next()) {
				c.setId(id);
				c.setDescripcion(rs.getString("city"));
				c.setCountryId(rs.getLong("country_id"));
			}
			else {return null;}
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
 
			}
		}

		return c;

	}

	public City createCity(Connection conn, City c) throws SQLException {

		PreparedStatement stmt = null;

		try {
			String sql = "insert into city (city, country_id) values (?,?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			

			stmt.setString(1, c.getDescripcion());
			stmt.setLong(2, c.getCountryId());
			stmt.execute();
			ResultSet rs= stmt.getGeneratedKeys();
			rs.next();
			c.setId(rs.getLong(1));
		
			
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
 
			}
		}
		return c;
		
	}

	public Integer updateCity(Connection conn, City city) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = ("update city set city = '" + city.getDescripcion() + "' ,country_id = "
					+ city.getCountryId() + " where city_id = " + city.getId());
			return stmt.executeUpdate(sql);
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
 
			}
		}

	}

	public Integer updateSelectiveCity(Connection conn, City city) throws SQLException {
		String sql=null;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			if (city.getCountryId() != null) {
				sql = ("update city set country_id = " + city.getCountryId() + " where city_id = "
						+ city.getId());
				
			}
			else if (city.getDescripcion() != null) {
				sql = ("update city set city = '" + city.getDescripcion() + "' where city_id = " + city.getId());
			
			}
			else if (city.getCountryId() != null && city.getDescripcion() != null) {
				updateCity(conn, city);
			}
			
			return stmt.executeUpdate(sql);
		}  finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
 
			}
		}
		

	}
	public Integer deleteCity(Connection conn, Long id) throws SQLException {
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			String sql = "DELETE FROM city WHERE city_id= " + id;
			return stmt.executeUpdate(sql);
			
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
 
			}
		}
		
	}

}
