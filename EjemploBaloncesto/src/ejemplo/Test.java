package ejemplo;

import ejemplo.modelo.Equipo;
import ejemplo.service.EquipoService;

public class Test {

	public static void main(String[] args) {
		Equipo e = new Equipo();
		e.setJugadores(13);
		e.setNombre("Bulls");
		//e.setId((long) 3);
		EquipoService es = new EquipoService();
		//es.insertarEquipo(e);
		
		//es.actualizarEquipo(e);
		//es.eliminarEquipo(e);
		Equipo e2= es.consultarEquipo((long)2);
		System.out.println(e2);
	}

}
