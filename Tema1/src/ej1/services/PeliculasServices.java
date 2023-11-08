package ej1.services;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.Iterator;
import java.util.List;

import ej1.dao.PeliculaDao;
import ej1.dao.PeliculasServicesException;
import ej1.modelo.Pelicula;

public class PeliculasServices {

	public PeliculasServices() {
	}

	public List<Pelicula> nuevaLista(Integer longitud) throws PeliculasServicesException {
		Connection conn = null;
		 
		try {
			conn = new OpenConnection().getNewConnection();

			PeliculaDao pd = new PeliculaDao();
			List<Pelicula> peliculas = pd.ListaPeliculas(conn);
			Iterator<Pelicula> it = peliculas.iterator();
			while (it.hasNext()) {
				if (it.next().getLongitud() > longitud) {
					it.remove();
				}
			}
			return peliculas;
		} catch (SQLException e) {
			System.err.println("Error al consultar películas");
			throw new PeliculasServicesException("Error al consultar películas en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
	
	}
}
