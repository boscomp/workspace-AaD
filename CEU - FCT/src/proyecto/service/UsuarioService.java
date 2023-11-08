package proyecto.service;

import java.sql.Connection;
import java.sql.SQLException;

import proyecto.dao.UsuarioDao;
import proyecto.db.OpenConnection;
import proyecto.modelo.Usuario;

public class UsuarioService {
	private OpenConnection connProvider;

	public UsuarioService() {
		connProvider = new OpenConnection();
	}

	public Usuario login(String email, String pass) throws AutenticarException, FCTException {
		Usuario user = new Usuario();
		UsuarioDao userD = new UsuarioDao();
		Connection conn = null;

		try {
			conn = connProvider.getNewConnection();
			user = userD.consultarUsuario(conn, email);
			if (user == null) {
				throw new AutenticarException("El email no es válido");
			}
			if (!user.getContraseña().equals(pass)) {
				throw new AutenticarException("La contraseña no es válida");
			} else {
				return user;
			}
		} catch (SQLException e) {

			throw new FCTException("Error en la base de datos", e);
		}

		finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}

	}

	public void altaUsuario(Usuario usuario) throws FCTException {
		Connection conn = null;
		try {
			UsuarioDao userD = new UsuarioDao();
			Usuario user = new Usuario();
			conn = connProvider.getNewConnection();
			user = userD.consultarUsuario(conn, usuario.getEmail());
			if (user == null) {
				userD.insertarUsuario(conn, usuario);
			}
			
		} catch (SQLException e) {

			throw new FCTException("Error en la base de datos", e);
		}

		finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

}
