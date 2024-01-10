package ej4.app;

import java.util.List;

import ej4.modelo.Libro;
import ej4.xml.XmlSampleService;

public class App {

	public static void main(String[] args) {
	
		XmlSampleService xss = new XmlSampleService();
		List <Libro> libros = Libro.createRandomList(50);
		xss.crearXmlLibro("/C:/temporal/libros.xml", libros);
	}

}
