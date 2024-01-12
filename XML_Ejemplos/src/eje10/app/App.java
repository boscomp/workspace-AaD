package eje10.app;

import java.util.ArrayList;
import java.util.List;

import ej4.modelo.Libro;
import ej8.xml.LibrosXMLException;
import eje10.xml.XMLJacksonService;

public class App {

	public static void main(String[] args) {
		testCrearXMLLibro();
	}

	private static void testCrearXMLLibro() {
		XMLJacksonService service = new XMLJacksonService();
		
		List <Libro> libros = new ArrayList<Libro>();
		try {
			libros=Libro.createRandomList(8);
			System.out.println(libros.size());
			
				
				service.escribirXMLLibro("/C:/temporal/jacksonLibros.xml", libros);
			
		} catch (LibrosXMLException e) {
			e.printStackTrace();
		}
	}

}
