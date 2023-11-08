package ej04.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ej2.modelo.ClienteEj2;
import ej2.servicio.ClienteServices;
import ej2.servicio.ClienteServicesException;





public class ClientesServiceRest {
	@PostMapping("/clientes")
	public  ClienteEj2 consultarCliente(@RequestParam String correo) throws ClienteServicesException {

			ClienteServices cs = new ClienteServices();
			ClienteEj2 c = new ClienteEj2();
			Map<String, ClienteEj2> clientes = new HashMap<>();
			try {
				clientes = cs.consultarClientes();

				c = clientes.get(correo);

				if (c == null) {
					throw new ClienteServicesException();
				} 

			} catch (ClienteServicesException e) {

				e.printStackTrace();
			}
			return c;

		
	}

}
	
