package ejemploHandler.app;

import java.util.List;

import ejemploHandler.modelo.Curso;
import ejemploHandler.service.XMLCursosServices;
import ejemploXML.xml.CursosXMLException;

public class App {

	public static void main(String[] args) {
		testLeerXMLCursoSax();
	}
	private static void testLeerXMLCursoSax() {
		XMLCursosServices services = new XMLCursosServices();
		
		try {
			List <Curso> cursos= services.leerCursos("/C:/temporal/cursos.xml");
			for (Curso curso : cursos) {
				System.out.println(curso);
			}
		} catch (CursosXMLException e) {
			e.printStackTrace();
		}
	}
}
