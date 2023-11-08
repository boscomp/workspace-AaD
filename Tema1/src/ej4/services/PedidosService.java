package ej4.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ej1.services.OpenConnection;
import ej4.dao.LineaPedidoDao;
import ej4.dao.PedidoDao;
import ej4.modelo.LineaPedido;
import ej4.modelo.Pedido;

public class PedidosService {

private OpenConnection connProvider;
	
	public PedidosService() {
		connProvider = new OpenConnection();
	}
	
	public void registrarPedido(Pedido pedido) throws PedidoException {
		PedidoDao daoPedido = new PedidoDao();
		LineaPedidoDao daoLinea = new LineaPedidoDao();
		Connection conn = null;
		try {
			conn = connProvider.getNewConnection();
			conn.setAutoCommit(false);
			// 1. Insertar los datos de la tabla pedido (los datos principales)
			Long idPedidoGenerado=daoPedido.insertar(conn, pedido);
			// 2. Recorrer todas las líneas del pedido (pedido.getLineas()) ...for..
			List<LineaPedido> lineas = pedido.getLineaPedido();
			int numLinea = 1;
			for (LineaPedido linea : lineas) {
				// 3. Para cada línea --> Insertar la línea en tabla pedidos_lineas
				linea.setIdPedido(idPedidoGenerado);
				linea.setNumeroLinea(numLinea);
				daoLinea.insertar(conn, linea);
				numLinea++;
			}
			conn.commit();
		}
		catch(SQLException e) {
			System.err.println("Error al registrar pedido");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.err.println("No se ha podido hacer rollback");
			}
			throw new PedidoException("Error al registrar pedido", e);
		}
		finally {
			try {
				conn.close();
			}catch(Exception ignore) {}
		}
	}

}
