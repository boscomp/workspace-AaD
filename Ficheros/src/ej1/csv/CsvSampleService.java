package ej1.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ej1.dao.PeliculasServicesException;
import ej1.modelo.Pelicula;
import ej1.services.PeliculasServices;



public class CsvSampleService {
	public void escribirCsvAlumno(String ruta) throws FicheroException {
		PeliculasServices services = new PeliculasServices();
		List<Pelicula> pelis=null;
		try {
			pelis = services.nuevaLista(100);
		} catch (PeliculasServicesException e) {

			e.printStackTrace();
		}
		File file = new File(ruta);
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			for (Pelicula peli : pelis) {

				writer.write(peli.toCsv() + "\n");
			}

		} catch (IOException e) {
			throw new FicheroException("Error escribiendo CSV", e);
		} finally {
			try {
				writer.close();
			} catch (Exception ignore) {
			}
		}
	}

}
