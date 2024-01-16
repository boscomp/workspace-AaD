package eje10.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ej4.modelo.Libro;
import ej8.xml.LibrosXMLException;
import eje10.modelo.Libros;


public class XMLJacksonService {

	public void escribirXMLLibro(String pathName, List<Libro> libro) throws LibrosXMLException {
		try {
			Libros libros = new Libros();
			libros.setLibros(libro);
			XmlMapper mapper = new XmlMapper();
			File file = new File(pathName);
			
				
				mapper.writeValue(file, libros);
			
		} catch (IOException e) {
			System.err.println("Error al escribir XML de curso " + e.getMessage());
			throw new LibrosXMLException("Error al escribir XML de curso " + e.getMessage());
		}
	}
	
	public List <Libro> leerXMLLibros (String pathFile) throws XMLExportException{
		try {
			XmlMapper mapper = new XmlMapper();
			File file = new File(pathFile);
			Libros libro = mapper.readValue(file, Libros.class);
			
			
			return libro.getLibros();
			
		} catch (IOException e) {
		e.printStackTrace();
			throw new XMLExportException("error ",e);
		}
	}

}
