package app;


import java.util.List;

import modelo.Actor;
import servicio.ActoresServices;
import servicio.ActoresServicesException;

public class App {
	public static void main(String[] args) {
		ActoresServices service = new ActoresServices();
		List<Actor> actores;
		try {
			actores = service.consultarActores();
			for (Actor actor : actores) {
				System.out.println(actor);
			}
		} catch (ActoresServicesException e) {
			
			e.printStackTrace();
		}
	}

}
