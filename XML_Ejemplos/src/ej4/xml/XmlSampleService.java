package ej4.xml;

import java.io.File;
import java.util.List;

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

import ej4.modelo.Libro;

public class XmlSampleService {

	public XmlSampleService() {
		
	}
	public void crearXmlLibro(String ruta, List <Libro> libros) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
		
			Document xml = builder.newDocument();
			Element root = xml.createElement("libros");
			xml.appendChild(root);
			
			
			for (Libro libro : libros) {
				Element libroTag = xml.createElement("libro");
				
				
				Element tituloTag = xml.createElement("titulo");
				
				
				Element autoresTag = xml.createElement("autores");
				
				
				Element edicionesTag = xml.createElement("ediciones");
			
				
			
				root.appendChild(libroTag);
				libroTag.appendChild(tituloTag);
				libroTag.appendChild(autoresTag);
				libroTag.appendChild(edicionesTag);
				
				
				tituloTag.setTextContent(libro.getTitulo());
				for (int i=0; i<libro.getAutores().size();i++) {
					
					Element autorTag = xml.createElement("autor");
					autoresTag.appendChild(autorTag);
					autorTag.setTextContent(libro.getAutores().get(i));				
				}
				for (int i=0; i<libro.getEdiciones().size();i++) {
					Element anhoTag = xml.createElement("año");
					
					Element editorialTag = xml.createElement("editorial");
					edicionesTag.appendChild(anhoTag);
					edicionesTag.appendChild(editorialTag);
					
					anhoTag.setTextContent(libro.getEdiciones().get(i).getAño().toString());	
					editorialTag.setTextContent(libro.getEdiciones().get(i).getEditorial());
				}
				
			}
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(xml);
			File file = new File(ruta);
			StreamResult stream = new StreamResult(file);
			transformer.transform(source, stream);
		
		} catch (ParserConfigurationException | TransformerException e) {

			e.printStackTrace();
		}

	}

}
