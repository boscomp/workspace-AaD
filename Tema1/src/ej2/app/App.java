package ej2.app;

import java.util.Map;

import ej2.modelo.ClienteEj2;
import ej2.servicio.ClienteServices;
import ej2.servicio.ClienteServicesException;

public class App {

	public static void main(String[] args) {
		
		ClienteServices cs = new ClienteServices();
		try {
			Map<String, ClienteEj2>mapa=cs.consultarClientes();
			System.out.println(mapa.get("MARILYN.ROSS@sakilacustomer.org"));
		} catch (ClienteServicesException e) {
			
			e.printStackTrace();
		}
		
	}

}
