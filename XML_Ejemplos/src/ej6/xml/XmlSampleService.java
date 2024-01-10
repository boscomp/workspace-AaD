package ej6.xml;

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

import ej6.modelo.Pelicula;
import ej6.modelo.Persona;

public class XmlSampleService {

	public XmlSampleService() {
	
	}
	public void crearXmlPelis(String ruta, List<Pelicula> pelis) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.newDocument();
			Element root = xml.createElement("peliculas");
			xml.appendChild(root);
			
			for (Pelicula pelicula : pelis) {
				Element peliculaTag = xml.createElement("pelicula");
				
				
				Element tituloTag = xml.createElement("titulo");
				
				
				Element duracionTag = xml.createElement("duracion");
				
				
				Element anhoTag = xml.createElement("año");
				Element artistasTag = xml.createElement("artistas");
				
			
				root.appendChild(peliculaTag);
				peliculaTag.appendChild(tituloTag);
				peliculaTag.appendChild(duracionTag);
				peliculaTag.appendChild(anhoTag);
				peliculaTag.appendChild(artistasTag);
				
				tituloTag.setTextContent(pelicula.getTitulo());
				duracionTag.setTextContent(pelicula.getDuracion().toString());
				anhoTag.setTextContent(pelicula.getAño().toString());
				

				int cont=0;
				for (Persona actores : pelicula.getActores()) {
					Element artistaTag = xml.createElement("artista");
					Element nombreTag = xml.createElement("nombre");
					Element nacionalidadTag = xml.createElement("nacionalidad");
					if (cont ==0) {
						artistaTag.setAttribute("tipo", Persona.DIRECCION);
					}
					else if (cont ==1) {
						artistaTag.setAttribute("tipo", Persona.PRODUCCION);
					}
					else {
						artistaTag.setAttribute("tipo", Persona.INTERPRETACION);
					}
					
					artistasTag.appendChild(artistaTag);
					artistaTag.appendChild(nombreTag);
					artistaTag.appendChild(nacionalidadTag);
					nombreTag.setTextContent(actores.getNombre());
					nacionalidadTag.setTextContent(actores.getNombre());
					cont++;
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
	
	public void metodo () {
	
	}
}
