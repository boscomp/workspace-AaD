package ej9.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import ej6.modelo.Pelicula;
import ej8.xml.LibrosXMLException;

public class XMLPelisServices {

	public XMLPelisServices() {
	}

	public List<Pelicula> leerXmlPeli(String ruta) throws LibrosXMLException {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser;

			parser = factory.newSAXParser();

			// crear instancia de handler
			XMLPelisHandler handler = new XMLPelisHandler();
			// crear file con la ruta
			File file = new File(ruta);
			// ejecutar parser para leer fichero dandole el file
			parser.parse(file, handler);
			return handler.getPelis();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println("Error leyendo XML: " + e.getMessage());
			throw new LibrosXMLException("Error leyendo XML: " + e.getMessage());
		}

	}
}
