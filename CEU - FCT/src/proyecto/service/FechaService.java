package proyecto.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import proyecto.dao.FechaDao;
import proyecto.db.OpenConnection;
import proyecto.modelo.Fecha;

public class FechaService {
	private OpenConnection connProvider;
	public FechaService() {
		connProvider= new OpenConnection();
	}
	public List <Fecha> consultarFechasActuales() {
		FechaDao fd = new FechaDao();
		Connection conn = null;
		List <Fecha> fechasActuales = new ArrayList<>();
		Integer anho= LocalDate.now().getYear();
		Integer mes = LocalDate.now().getMonthValue();
		Integer evaluacion=1;
		if (mes>2 && mes<6) {
			evaluacion = 3;
		}
		else if(mes>11 && mes < 3){
			evaluacion = 2;
		}
		else if (mes > 8 && mes < 12) {
			evaluacion = 1;
		}
		
		try {
			conn = connProvider.getNewConnection();			
			fechasActuales = fd.consultarFechas(conn, anho, evaluacion);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return fechasActuales;
	}
	
}
