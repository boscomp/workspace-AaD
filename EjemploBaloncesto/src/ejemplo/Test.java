package ejemplo;

import java.util.ArrayList;
import java.util.List;

import ejemplo.modelo.Equipo;
import ejemplo.modelo.Estadio;
import ejemplo.modelo.Jugador;
import ejemplo.modelo.Socio;
import ejemplo.service.EquipoService;
import ejemplo.service.EstadioService;

public class Test {

	public static void main(String[] args) {
		Equipo e = new Equipo();
		e.setNumJugadores(25);
		e.setNombre("REAL BE");
//
//
		Estadio estadio = new Estadio();
//		estadio.setNombre(" Villamarín");
//		estadio.setDireccion("La ");
//		estadio.setEquipo(e);
//		e.setEstadio(estadio);
//	EstadioService estaSer = new EstadioService();
//	estaSer.insertarEstadio(estadio);
//		Estadio estadio2=estaSer.consultarEstadio(5L);
//		System.out.println("estadio: " +estadio2);
//		System.out.println("Equipo del estadio: "+estadio2.getEquipo());
		
//		Jugador j = new Jugador();
//		j.setCodigo("Magia");
//		j.setDorsal(22);
//		j.setNombre("Isco");
//		j.setEquipo(e);
//		
//		Jugador j2 = new Jugador();
//		j2.setCodigo("Morapio");
//		j2.setDorsal(20);
//		j2.setNombre("Chadi Riad");
//		j2.setEquipo(e);
//		List <Jugador> lista = new ArrayList<Jugador>();
//		lista.add(j);
//		lista.add(j2);
//		
//		e.setJugadores(lista);
		EquipoService es = new EquipoService();
//		Socio s1= new Socio();
//	
//		s1.setNombre("Yo");
//		Socio s2= new Socio();
//
//		s2.setNombre("Yo no");
//		List <Socio> listasocio = new ArrayList<Socio>();
//		listasocio.add(s2);
//		listasocio.add(s1);
//		e.setSocios(listasocio);
//		es.insertarEquipo(e);
//		
		Equipo prueba=es.consultarEquipo(12L);
		System.out.println(prueba);
		System.out.println(prueba.getEstadio());
		System.out.println(prueba.getJugadores());
		System.out.println(prueba.getSocios());
		

	}

}
