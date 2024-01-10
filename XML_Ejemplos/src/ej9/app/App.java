package ej9.app;

import java.util.List;


import ej6.modelo.Pelicula;
import ej8.xml.LibrosXMLException;

import ej9.xml.XMLPelisServices;

public class App {

	public static void main(String[] args) {
		testLeerXMLPeliSax();
	}
	private static void testLeerXMLPeliSax() {
		XMLPelisServices services = new XMLPelisServices();
		
		try {
			List <Pelicula> pelis= services.leerXmlPeli("/C:/temporal/xmlPeliculas.xml");
			for (Pelicula pelicula : pelis) {
				System.out.println(pelicula);
			}
		} catch (LibrosXMLException e) {
			e.printStackTrace();
		}
	}

}
