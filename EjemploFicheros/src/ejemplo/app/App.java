package ejemplo.app;

import java.util.List;

import ejemplo.csv.CsvSampleService;
import ejemplo.csv.FicheroException;
import ejemplo.modelo.Asignatura;

public class App {
public static void main(String[] args) {
	CsvSampleService serviceCsv = new CsvSampleService();
	try {
//		serviceCsv.escribirCsvAlumno("/C:/temporal/asignaturas.txt");
		List<Asignatura> resultado = serviceCsv.leerCsvAsignaturas("/C:/temporal/asignaturas.txt");
		for (Asignatura asignatura : resultado) {
			System.out.println(asignatura);
		}
	} catch (FicheroException e) {

		e.printStackTrace();
	}
}
}
