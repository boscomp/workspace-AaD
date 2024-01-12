package ejemploJackson;

import ejemploHandler.modelo.Alumno;
import ejemploHandler.modelo.Curso;
import ejemploXML.xml.CursosXMLException;

public class App {

	public static void main(String[] args) {
		testCrearXMLCurso();
	}

	private static void testCrearXMLCurso() {
		Alumno a1 = new Alumno("478L", "Rubén Castro");
		Alumno a2 = new Alumno("875A", "Nabil Fekir");
		
		Curso c1 = new Curso("DAM",7);
		c1.getAlumnos().add(a1);
		c1.getAlumnos().add(a2);
		XMLJacksonService xjs = new XMLJacksonService();
		
		try {
			xjs.escribirXMLCurso("/C:/temporal/xmlJackson.xml", c1);
		} catch (CursosXMLException e) {
			
			e.printStackTrace();
		}
		
	}
}
