package ej3.app;

import java.util.List;
import java.util.Map;

import ej3.modelo.PagoEj3;
import ej3.services.PagoServices;
import ej3.services.PagoServicesException;

public class AppEj3 {

	public static void main(String[] args) {
		PagoServices ps = new PagoServices();
		try {
			Map<String, List<PagoEj3>> mapa = ps.consultarPagos();
			System.out.println(mapa.get("MARILYN.ROSS@sakilacustomer.org"));
		} catch (PagoServicesException e) {

			e.printStackTrace();
		}
	}

}
