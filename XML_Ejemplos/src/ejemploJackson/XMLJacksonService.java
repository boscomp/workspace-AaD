package ejemploJackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ejemploHandler.modelo.Curso;
import ejemploXML.xml.CursosXMLException;

public class XMLJacksonService {

	public void escribirXMLCurso(String pathName, Curso curso) throws CursosXMLException {
		try {
			XmlMapper mapper = new XmlMapper();
			File file = new File(pathName);
			mapper.writeValue(file, curso);
		} catch (IOException e) {
			System.err.println("Error al escribir XML de curso " + e.getMessage());
			throw new CursosXMLException("Error al escribir XML de curso " + e.getMessage());
		}
	}

}
