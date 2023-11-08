package ej4.app;

import java.math.BigDecimal;
import java.time.LocalDate;

import ej4.modelo.LineaPedido;
import ej4.modelo.Pedido;
import ej4.services.PedidoException;
import ej4.services.PedidosService;

public class AppEj4 {

	public static void main(String[] args) {
		
		Pedido pedido = new Pedido();
	
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.of(2023, 12, 1));
		pedido.setCliente("Laura Salmerón");
		
		for (int j = 1; j <= 3; j++) {
			LineaPedido linea = new LineaPedido();
			linea.setArticulo("Artículo " + j);
			linea.setPrecio(new BigDecimal(938));
			pedido.getLineaPedido().add(linea);
	
		}
		
		PedidosService service = new PedidosService();
		try {
			service.registrarPedido(pedido);
		} catch (PedidoException e) {
			e.printStackTrace();
		}
		
	}

}
