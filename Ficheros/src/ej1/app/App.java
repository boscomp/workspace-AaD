package ej1.app;

import java.util.List;

import ej1.csv.CsvSampleService;
import ej1.csv.FicheroException;
import ej1.dao.PeliculasServicesException;
import ej1.modelo.Pelicula;
import ej1.services.PeliculasServices;


public class App {

	public static void main(String[] args) {
		PeliculasServices ps = new PeliculasServices();
		CsvSampleService serviceCsv = new CsvSampleService();
	
			
				try {
					serviceCsv.escribirCsvAlumno("/C:/temporal/peliculas.txt");
				} catch (FicheroException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		
		
		
		}

}
