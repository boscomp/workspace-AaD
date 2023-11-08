package ej03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ej1.dao.PeliculasServicesException;
import ej1.modelo.Pelicula;
import ej1.services.PeliculasServices;
public class PeliculasServiceRest {

	@PostMapping("/peliculas")
	public List<Pelicula> getPeliculas(@RequestParam int longitud) throws DuracionPeliculaNoEncontrada{
		
		PeliculasServices ps=new PeliculasServices();
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			
			if(longitud<20||longitud>300) {
				throw new DuracionPeliculaNoEncontrada("La duración de las peliculas no existe");
			}
			
			
			peliculas = ps.nuevaLista(longitud);
			
			
			
			
			
			
		} catch (PeliculasServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peliculas;
		
		
		
		
		
	}

}
