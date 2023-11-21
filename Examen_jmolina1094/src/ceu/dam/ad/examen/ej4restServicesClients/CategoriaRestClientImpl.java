package ceu.dam.ad.examen.ej4restServicesClients;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ceu.dam.ad.examen.exceptions.AccessDatabaseException;
import ceu.dam.ad.examen.exceptions.InvalidParamException;
import ceu.dam.ad.examen.exceptions.NotFoundException;
import ceu.dam.ad.examen.modelo.Categoria;

public class CategoriaRestClientImpl implements CategoriaRestClient {
	private String urlBase;
	private RestTemplate restTemplate;

	public CategoriaRestClientImpl(String urlBase, Integer msTimeout) {
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) throws InvalidParamException, AccessDatabaseException {
		try {
			String url = urlBase + "/categoria";
			categoria = restTemplate.postForObject(url, categoria, Categoria.class);
			return categoria;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new AccessDatabaseException("Error en el formato del nombre");
			}
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new AccessDatabaseException("Error en el servidor");
			}
			throw e;
		}
	}

	@Override
	public Categoria consultarCategoria(Long id)
			throws InvalidParamException, NotFoundException, AccessDatabaseException {
		try {
			if (id == null) {
				throw new InvalidParamException("El id no puede ser nulo");
			} else {
				String url = urlBase + "/categoria{id}";
				Categoria cat = restTemplate.getForObject(url, Categoria.class, id);
				return cat;
			}
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new AccessDatabaseException("Error en el formato del nombre");
			}
			if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new AccessDatabaseException("Error en el servidor");
			}
			throw e;
		}

	}

}
