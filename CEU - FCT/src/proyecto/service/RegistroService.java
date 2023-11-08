package proyecto.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import proyecto.dao.RegistroDao;
import proyecto.db.OpenConnection;
import proyecto.modelo.Registro;

public class RegistroService {

	private RegistroDao dao;
	private OpenConnection connProvider;

	public RegistroService() {
		dao = new RegistroDao();
		connProvider = new OpenConnection();
	}

	public List<Registro> consultarRegistrosUsuario(Long idUsuario) throws FCTException {
		Connection conn = null;
		try {
			conn = connProvider.getNewConnection();
			return dao.consultarRegistro(conn, idUsuario);
		} catch (SQLException e) {
			System.err.println("Error al consultar registros");
			throw new FCTException("Error al consultar registros en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}
	
	public void crearRegistro(Registro registro) throws FCTException {
		Connection conn = null;
		try {
			conn = connProvider.getNewConnection();
			List<Registro> registrosPrevios = dao.consultarRegistro(conn, registro.getIdUsuario());
			for (Registro previo : registrosPrevios) {
				if (previo.getFecha().equals(registro.getFecha())) {
					throw new FCTException("Ya existe un registro para ese usuario en esa fecha");
				}
			}
			dao.nuevoRegistro(conn, registro);
		} catch (SQLException e) {
			System.err.println("Error al insertar registro");
			throw new FCTException("Error al insertar registro en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

}