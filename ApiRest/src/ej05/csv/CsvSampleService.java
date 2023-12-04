package ej05.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ej05.CityApiRest;
import ej05.modelo.City;
import ej05.service.CityService;
import ej05.service.ServerErrorException;
import ej1.dao.PeliculasServicesException;
import ej1.modelo.Pelicula;
import ej1.services.PeliculasServices;




public class CsvSampleService {
	public void escribirCity(String ruta)  {
		CityApiRest cs = new CityApiRest();
		List<City> ciudades=null;
		
	
		
		
		try {
			ciudades = leerCsvCity(ruta);
		
			for (City city : ciudades) {
				cs.createCity(city);
		
			}

		} catch (ServerErrorException | FicheroException e) {

			e.printStackTrace();
		} finally {
			try {
			
			} catch (Exception ignore) {
			}
		}
	}
	
	public List<City> leerCsvCity(String ruta) throws FicheroException {
		File file = new File(ruta);
		List<City> ciudades = new ArrayList<City>();
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				City c = new City();
				String[] campos = line.split("	");
				c.setDescripcion(campos[0]);
				c.setCountryId(Long.parseLong(campos[1])); 
				ciudades.add(c);
			}
		} catch (FileNotFoundException e) {
			throw new FicheroException("No existe el fichro en la ruta indicada", e);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return ciudades;
	}

}
