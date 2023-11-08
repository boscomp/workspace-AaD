package ej06.clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import ej06.modelo.Ciudad;

public class CiudadesClientImpl implements CiudadesClient {
	private String urlBase;
	private RestTemplate restTemplate;

	public CiudadesClientImpl(String urlBase, Integer msTimeout)  {
		
		this.urlBase = urlBase;
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(msTimeout);
		this.restTemplate = new RestTemplate(requestFactory);
		
	}

	@Override
	public List<Ciudad> getCities(String filtroDescripcion) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
		String url = urlBase + "/city";
		Ciudad[] ciudades = restTemplate.getForObject(url, Ciudad[].class, filtroDescripcion);
		return Arrays.asList(ciudades);
		} catch (HttpStatusCodeException e){
			if (e.getStatusCode()== HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existen ciudades con ese filtro");
			}
			if (e.getStatusCode()== HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error en el servidor");
			}
			throw e;
		}
	}

	@Override
	public Ciudad getCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
		String url = urlBase + "/city/{id}";
		Ciudad c = restTemplate.getForObject(url, Ciudad.class, id);

		return c;
		} catch (HttpStatusCodeException e){
			if (e.getStatusCode()== HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existen ciudades con esa id");
			}
			if (e.getStatusCode()== HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error en el servidor");
			}
			throw e;
		}
	}

	@Override
	public Ciudad createCity(Ciudad city) throws CiudadErrorException {
		try {
		String url = urlBase + "/city";
		city = restTemplate.postForObject(url, city, Ciudad.class);
		return city;
		} catch (HttpStatusCodeException e){
			if (e.getStatusCode()== HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error en el servidor");
			}
			throw e;
		}
	}

	@Override
	public void updateCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
		String url = urlBase + "/city";
		restTemplate.put(url, city);
		} catch (HttpStatusCodeException e){
			if (e.getStatusCode()== HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe la ciudad");
			}
			if (e.getStatusCode()== HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error en el servidor");
			}
			throw e;
		}

	}

	@Override
	public Ciudad updateSelectiveCity(Ciudad city) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
		String url = urlBase + "/city";
		city = restTemplate.patchForObject(url, city, Ciudad.class);
		return city;
		} catch (HttpStatusCodeException e){
			if (e.getStatusCode()== HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe la ciudad");
			}
			if (e.getStatusCode()== HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error en el servidor");
			}
			throw e;
		}
	}

	@Override
	public void deleteCity(Long id) throws CiudadNoEncontradaException, CiudadErrorException {
		try {
		String url = urlBase + "/city/{id}";

		restTemplate.delete(url, id	);
		} catch (HttpStatusCodeException e){
			if (e.getStatusCode()== HttpStatus.NOT_FOUND) {
				throw new CiudadNoEncontradaException("No existe la ciudad");
			}
			if (e.getStatusCode()== HttpStatus.INTERNAL_SERVER_ERROR) {
				throw new CiudadErrorException("Error en el servidor");
			}
			throw e;
		}

	}

}