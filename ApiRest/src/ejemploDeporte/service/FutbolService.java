package ejemploDeporte.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejemploDeporte.modelo.Futbol;

@RestController
public class FutbolService {
	
	@GetMapping("/equipo")
	public Futbol getFutbol(@RequestParam Integer posicion) throws FutbolNotFoundException {
		Futbol f = new Futbol();
		if (posicion==99) {
			throw new FutbolNotFoundException("No va");
		}
		f.setEstadio("Benito Villamarín");
		f.setLiga("La Liga");
		f.setNombre("REAL BETIS BALOMPIÉ");
		f.setPosicion(posicion);
		return f;
		
	}
	@PostMapping("/equipo")
	public void crearFutbol(@RequestBody Futbol fut) {
		System.out.println("Creando equipo");
		System.out.println(fut);
		
		System.out.println("deporte creado");
	}

}
