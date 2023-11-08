package ej2.servicio;


import java.sql.Connection;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ej1.services.OpenConnection;
import ej2.dao.ClienteDao;
import ej2.modelo.ClienteEj2;

public class ClienteServices {

	public Map<String, ClienteEj2> consultarClientes() throws ClienteServicesException{
		Connection conn = null;
		Map <String, ClienteEj2> mapa=new HashMap<>();
		try {
			conn = new OpenConnection().getNewConnection();
			ClienteDao dao =new ClienteDao();
			List <ClienteEj2> lista=dao.listaClientes(conn);
			
			for (ClienteEj2 cliente : lista) {
				mapa.put(cliente.getEmail(), cliente);
			}

			return mapa;
		} catch (SQLException e) {
			System.err.println("Error al consultar películas");
			throw new ClienteServicesException("Error al consultar películas en BBDD", e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
		
		
		
	}

}
