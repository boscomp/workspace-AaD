package ej05;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ej05.dao.CityDao;
import ej05.dao.OpenConnection;
import ej05.modelo.City;
import ej05.service.CityService;
import ej05.service.NotFoundException;
import ej05.service.ServerErrorException;


@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class CityApiRest implements CityService {
	private OpenConnection connProvider;
	private CityDao cd;
	private Connection conn;

	public static void main(String[] args) {
		SpringApplication.run(CityApiRest.class, args);
	}

	public CityApiRest() {
		connProvider = new OpenConnection();
		cd = new CityDao();
		conn = null;
	}

	@Override
	@GetMapping("/city")
	public List<City> getCities(@RequestParam(required=false) String filtroDescripcion) throws NotFoundException, ServerErrorException {
		List<City> ciudades = new ArrayList<>();
		try {
			conn = connProvider.getNewConnection();
			ciudades = cd.getCities(conn, filtroDescripcion);
			if (ciudades==null) {
				throw new NotFoundException ("No se encuentra");
			}
		} catch (SQLException e) {

			throw new ServerErrorException("Error en el servidor", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
		return ciudades;
	}

	@Override
	@GetMapping("/city/{id}")
	public City getCity(@PathVariable Long id) throws NotFoundException, ServerErrorException {
	City ciudad = new City();
		try {
			conn = connProvider.getNewConnection();
			ciudad = cd.getCity(conn, id);
			if (ciudad==null) {
				throw new NotFoundException ("No se encuentra");
			}
			
		} catch (SQLException e) {

			throw new ServerErrorException("Error en el servidor", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
		return ciudad;
	}

	@Override
	@PostMapping("/city")
	public City createCity(@RequestBody City city) throws ServerErrorException {
		City c=new City();
		try {
			conn = connProvider.getNewConnection();
			c=cd.createCity(conn, city);
			
		} catch (SQLException e) {
e.printStackTrace();
			throw new ServerErrorException("Error en el servidor", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
		return c;
	}

	@Override
	@PutMapping("/city")
	public void updateCity(@RequestBody City city) throws NotFoundException, ServerErrorException {
		
		try {
			conn = connProvider.getNewConnection();
			if (cd.updateCity(conn, city)==0) {
				throw new NotFoundException ("No se encuentra");
			}
			
		} catch (SQLException e) {

		throw new ServerErrorException("Error en el servidor", e);
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

	@Override
	@PatchMapping("/city")
	public City updateSelectiveCity(@RequestBody City city) throws NotFoundException, ServerErrorException {
	City c= new City();
		try {
			conn = connProvider.getNewConnection();
			
			if (cd.updateSelectiveCity(conn, city)==0) {
				throw new NotFoundException ("No se encuentra");
			}else {
			c= cd.getCity(conn, city.getId());
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
		return c;
	}

	@Override
	@DeleteMapping("/city/{id}")
	public void deleteCity(@PathVariable Long id) throws NotFoundException, ServerErrorException {
		try {
			conn = connProvider.getNewConnection();
			if (cd.deleteCity(conn, id)==0) {
				
				throw new NotFoundException ("No se encuentra");
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception ignore) {
			}
		}
	}

}
