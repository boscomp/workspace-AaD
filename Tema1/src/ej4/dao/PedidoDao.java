package ej4.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ej4.modelo.Pedido;

public class PedidoDao {

	public Long insertar(Connection conn, Pedido pedido) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "insert into pedidos ( fecha_pedido, fecha_entrega, cliente) values (?,?,?,?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setDate(1, Date.valueOf(pedido.getFechaPedido()));
			stmt.setDate(2, Date.valueOf(pedido.getFechaEntrega()));
			stmt.setString(3, pedido.getCliente());
			stmt.execute();
			ResultSet rs= stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong(1);
//			return rs.getLong("id_pedido");
		} finally {
			try {
				stmt.close();
			} catch (Exception ignore) {
			}
		}
	}

}
