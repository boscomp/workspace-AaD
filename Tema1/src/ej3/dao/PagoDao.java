package ej3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ej3.modelo.PagoEj3;



public class PagoDao {

	
	public List <PagoEj3> listaPagos (Connection conn, Integer id) throws SQLException{

		Statement stmt = null;
		ResultSet rs = null;

		try {
			List<PagoEj3> pagos = new ArrayList<PagoEj3>();

			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from payment where customer_id = "+id);
			while (rs.next()) {
				PagoEj3 p = new PagoEj3();
				p.setFecha(rs.getDate("payment_date").toLocalDate());
				p.setImporte(rs.getBigDecimal("amount"));
				pagos.add(p);
			}
			return pagos;
		}  finally {
			try {
				stmt.close();
			} catch (Exception ignore) {

			}
			
		}
		
	}
}
