package ceu.dam.ad.examen.ej2services;

import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;

import ceu.dam.ad.examen.db.OpenConnection;
import ceu.dam.ad.examen.ej1dao.CategoriaDaoImpl;

public class CategoriaServiceImpl implements CategoriaService {
	private OpenConnection connProvider;
	private Connection conn;

	public CategoriaServiceImpl() {
		connProvider = new OpenConnection();
		conn = null;
	}

	@Override
	public Categoria crearCategoria(String nombre) throws InvalidParamException, AccessDatabaseException {
		Categoria cat = new Categoria();
		CategoriaDaoImpl cd = new CategoriaDaoImpl();
		Long id;

		try {
			conn = connProvider.getNewConnection();
			if (nombre == null || nombre.isBlank() || nombre.isEmpty() || nombre.length() > 25) {
				throw new InvalidParamException("Error en el formato del nombre");
			} else {

				id = cd.insertarCategoria(conn, nombre);
				conn = connProvider.getNewConnection();
				cat = cd.consultarCategoria(conn, id);
				return cat;
			}
		} catch (SQLException e) {

			throw new AccessDatabaseException("Error al consultar la BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

	@Override
	public Categoria consultarCategoria(Long id)
			throws InvalidParamException, NotFoundException, AccessDatabaseException {
		Categoria cat = new Categoria();
		CategoriaDaoImpl cd = new CategoriaDaoImpl();
		try {
			conn = connProvider.getNewConnection();
			cat = cd.consultarCategoria(conn, id);

			if (id == null) {
				throw new InvalidParamException("El id no puede ser nulo");
			}
			if (cat == null) {
				throw new NotFoundException("No hay categorias con ese id");
			} else {
				return cat;
			}
		} catch (SQLException e) {
			throw new AccessDatabaseException("Error al consultar la BBDD", e);
		}
	}

}
