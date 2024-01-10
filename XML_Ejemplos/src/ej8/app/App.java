package ej8.app;

import java.util.List;

import ej4.modelo.Libro;
import ej8.xml.LibrosXMLException;
import ej8.xml.XMLLibrosServices;



public class App {

	public static void main(String[] args) {
		testLeerXMLLibroSax();
	}
	private static void testLeerXMLLibroSax() {
		XMLLibrosServices services = new XMLLibrosServices();
		
		try {
			List <Libro> libros= services.leerXmlLibro("/C:/temporal/xmlLibros.xml");
			for (Libro libro : libros) {
				System.out.println(libro);
			}
		} catch (LibrosXMLException e) {
			e.printStackTrace();
		}
	}
}
