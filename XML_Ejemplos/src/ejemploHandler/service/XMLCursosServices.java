package ejemploHandler.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.SAXException;

import ejemploHandler.modelo.Curso;
import ejemploXML.xml.CursosXMLException;

public class XMLCursosServices {


		public List<Curso> leerCursos(String filePath) throws CursosXMLException {
			try {
				//crear saxparser usando SAXPFac
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser parser= factory.newSAXParser();
				//crear instancia de handler
				XMLCursoHandler handler = new XMLCursoHandler();
				//crear file con la ruta
				File file = new File(filePath);
				//ejecutar parser para leer fichero dandole el file
				parser.parse(file, handler);
				//devolver lista cursos registrados
				return handler.getCursos();
				
			} catch (ParserConfigurationException | SAXException | IOException e) {
				System.err.println("Error leyendo XML: "+e.getMessage());
			
				throw new CursosXMLException("Error leyendo XML: "+e.getMessage());
			} 
			
		}
	

}
