package ej01.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ej1.dao.PeliculasServicesException;
import ej1.modelo.Pelicula;
import ej1.services.PeliculasServices;
@RestController
public class PeliculasServiceRest {
	@PostMapping("/peliculas")
	public List<Pelicula> getPeliculas(@RequestParam int id){
		
		PeliculasServices ps=new PeliculasServices();
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			peliculas = ps.nuevaLista(id);
		} catch (PeliculasServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peliculas;
		
		
		
		
		
	}

}
