package ceu.dam.ad.examen.ej3restServices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import ceu.dam.ad.examen.ej2services.CategoriaServiceImpl;
import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

@RestController
public class CategoriaRestServiceImpl implements CategoriaRestService {

	@Override
	@PostMapping("/categoria")
	public Categoria crearCategoria(@RequestBody Categoria categoria)
			throws InvalidParamException, AccessDatabaseException {
		Categoria cat = new Categoria();
		CategoriaServiceImpl cs = new CategoriaServiceImpl();

		try {
			if (categoria.getName() == null || categoria.getName().isBlank() || categoria.getName().isEmpty()) {
				throw new InvalidParamException("El nombre no puede estar vacío");
			}
			cat = cs.crearCategoria(categoria.getName());
			return cat;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
				throw new AccessDatabaseException("Error al acceder a la BBDD");
			}
			throw e;
		}
	}

	@Override
	@GetMapping("/categoria/{id}")
	public Categoria consultarCategoria(@PathVariable Long id)
			throws InvalidParamException, NotFoundException, AccessDatabaseException {
		Categoria cat = new Categoria();
		CategoriaServiceImpl cs = new CategoriaServiceImpl();
		try {
			if (id == null) {
				throw new InvalidParamException("El id no puede ser nulo");
			}
			cat = cs.consultarCategoria(id);
			return cat;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new NotFoundException("No hay categoria con ese id");
			}
			if (e.getStatusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
				throw new AccessDatabaseException("Error al acceder a la BBDD");
			}
			throw e;
		}

	}

}
