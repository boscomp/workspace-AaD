package ejemplo.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ejemplo.modelo.Asignatura;
import ejemplo.servicio.AsignaturaService;

public class CsvSampleService {
	public void escribirCsvAlumno(String ruta) throws FicheroException {
		AsignaturaService services = new AsignaturaService();
		List<Asignatura> asignaturas = services.consultarAsignaturas();
		File file = new File(ruta);
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, true);
			for (Asignatura asignatura : asignaturas) {

				writer.write(asignatura.toCsv() + "\n");
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

	public List<Asignatura> leerCsvAsignaturas(String ruta) throws FicheroException {
		File file = new File(ruta);
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				Asignatura a = new Asignatura();
				String[] campos = line.split(";");
				a.setId(Integer.parseInt(campos[0]));
				a.setNombre(campos[1]);
				a.setCiclo(campos[2]);
				asignaturas.add(a);
			}
		} catch (FileNotFoundException e) {
			throw new FicheroException("No existe el fichro en la ruta indicada", e);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return asignaturas;
	}
}
