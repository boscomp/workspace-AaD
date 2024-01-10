package ej5.app;

import java.util.List;

import ej4.modelo.Libro;
import ej5.xml.XmlSampleService;
import ejemploXML.xml.CursosXMLException;

public class App {

	public static void main(String[] args) {
		XmlSampleService xss = new XmlSampleService();
		List<Libro> libros;
		try {
			libros = xss.leerXmlLibro("/C:/temporal/xmlLibros.xml");
			for (Libro libro : libros) {
				System.out.println(libro);
			}
		} catch (CursosXMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
