package ejemploXML.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlSampleService {

	public XmlSampleService() {
	}

	public void crearXmlCurso(String nombreFichero) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document xml = builder.newDocument();
			Element root = xml.createElement("cursos");

			xml.appendChild(root);

			Element cursoTag = xml.createElement("curso");

			root.appendChild(cursoTag);

			Element nombreTag = xml.createElement("nombre");

			cursoTag.appendChild(nombreTag);

			Element horasTag = xml.createElement("horas");

			nombreTag.appendChild(horasTag);

			Element alumnosTag = xml.createElement("alumnos");

			horasTag.appendChild(alumnosTag);

			Element alumnoTag = xml.createElement("alumno");

			alumnosTag.appendChild(alumnoTag);
			alumnoTag.setTextContent("Rubén Catro Martín");
			alumnoTag.setAttribute("dni", "123456789A");
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(nombreFichero);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}

	}
	public void leerXMLCursos(String rutafichero) throws CursosXMLException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
 
			Document xml = builder.parse(new File(rutafichero));
 
			Element root = xml.getDocumentElement();
 
			NodeList listaCursosTag = root.getElementsByTagName("curso");
 
			for (int i = 0; i < listaCursosTag.getLength(); i++) {
				Element cursoTag = (Element) listaCursosTag.item(i);
				Element nombreTag = (Element) cursoTag.getElementsByTagName("nombre").item(0);
				String nombre = nombreTag.getTextContent();
				System.out.println("Nombre curso: " + nombre);
 
				Element horasTag = (Element) cursoTag.getElementsByTagName("horas").item(0);
				String horas = horasTag.getTextContent();
				System.out.println("Horas del curso: " + horas);
 
				Element alumnosTag = (Element) cursoTag.getElementsByTagName("alumnos").item(0);
				NodeList listaAlumnoTag = alumnosTag.getElementsByTagName("alumno");
 
				for (int j = 0; j < listaAlumnoTag.getLength(); j++) {
					Element alumnoTag = (Element) listaAlumnoTag.item(j);
					String nombreAlumno = alumnoTag.getTextContent();
					System.out.println("\tNombreAlumno: " + nombreAlumno);
					String dni = alumnoTag.getAttribute("dni");
					System.out.println("\tDniALumno= " + dni);
				}
 
			}
 
		} catch (Exception e) {
			throw new CursosXMLException("Error leyendo XML", e);
		}

	}
}
