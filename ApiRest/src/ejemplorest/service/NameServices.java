package ejemplorest.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameServices {
	@GetMapping("/name")
	public String getNombre() {
		return "Nabil Fekir Mago del Balón";
	}
	@GetMapping("/cuadrado")
	public Integer cuadrado(@RequestParam Integer numero) {
		return numero*numero;
	}
	@GetMapping("/potencia/{base}/{pot}")
	public Integer potencia (@PathVariable Integer base,@PathVariable Integer pot) {
	
		return (int) Math.pow(base, pot);
	}
}
