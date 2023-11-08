package ej3.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ej1.services.OpenConnection;
import ej2.dao.ClienteDao;
import ej2.modelo.ClienteEj2;

import ej3.dao.PagoDao;
import ej3.modelo.PagoEj3;

public class PagoServices {

	public Map<String, List<PagoEj3>> consultarPagos() throws PagoServicesException {
		Connection conn = null;
		Map<String, List<PagoEj3>> mapa = new HashMap<>();
		try {
			conn = new OpenConnection().getNewConnection();
			ClienteDao cliDao = new ClienteDao();
			List<ClienteEj2> listaClientes = cliDao.listaClientes(conn);
			PagoDao paDao = new PagoDao();
			for (ClienteEj2 clienteEj2 : listaClientes) {
				mapa.put(clienteEj2.getEmail(), paDao.listaPagos(conn, clienteEj2.getId()));
			}
			return mapa;
		} catch (SQLException e) {
			System.err.println("Error al consultar películas");
			throw new PagoServicesException("Error al consultar películas en BBDD", e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}

	}
}
