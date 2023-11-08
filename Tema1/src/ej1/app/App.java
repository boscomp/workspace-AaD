package ej1.app;

import java.util.List;

import ej1.dao.PeliculasServicesException;
import ej1.modelo.Pelicula;
import ej1.services.PeliculasServices;

public class App {

	public static void main(String[] args) {
		PeliculasServices ps = new PeliculasServices();
		try {
			List <Pelicula> lista=ps.nuevaLista(2);
			for (Pelicula pelicula : lista) {
				System.out.println(pelicula);
			}
		} catch (PeliculasServicesException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
