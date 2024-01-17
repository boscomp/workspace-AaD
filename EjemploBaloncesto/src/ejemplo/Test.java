package ejemplo;

import java.util.ArrayList;
import java.util.List;

import ejemplo.modelo.Equipo;
import ejemplo.modelo.Estadio;
import ejemplo.modelo.Jugador;
import ejemplo.service.EquipoService;
import ejemplo.service.EstadioService;

public class Test {

	public static void main(String[] args) {
		Equipo e = new Equipo();
		e.setNumJugadores(25);
		e.setNombre("REAL BETIS BALOMPIÉ");
//
//
		Estadio estadio = new Estadio();
		estadio.setNombre("Benito Villamarín");
		estadio.setDireccion("La Palmera");
		estadio.setEquipo(e);
		e.setEstadio(estadio);
//	EstadioService estaSer = new EstadioService();
//	estaSer.insertarEstadio(estadio);
//		Estadio estadio2=estaSer.consultarEstadio(5L);
//		System.out.println("estadio: " +estadio2);
//		System.out.println("Equipo del estadio: "+estadio2.getEquipo());
		
		Jugador j = new Jugador();
		j.setCodigo("PANDA");
		j.setDorsal(9);
		j.setNombre("Borja Iglesias");
		j.setEquipo(e);
		
		Jugador j2 = new Jugador();
		j2.setCodigo("NABILON");
		j2.setDorsal(8);
		j2.setNombre("Nabil Fekir");
		j2.setEquipo(e);
		List <Jugador> lista = new ArrayList<Jugador>();
		lista.add(j);
		lista.add(j2);
		
		e.setJugadores(lista);
		EquipoService es = new EquipoService();
		
//		es.insertarEquipo(e);
		Equipo prueba=es.consultarEquipo(8L);
		System.out.println(prueba);
		System.out.println(prueba.getEstadio());
		System.out.println(prueba.getJugadores());
		

	}

}
