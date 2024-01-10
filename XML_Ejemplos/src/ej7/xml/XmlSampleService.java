package ej7.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ej6.modelo.Pelicula;
import ej6.modelo.Persona;
import ejemploXML.xml.CursosXMLException;

public class XmlSampleService {

	public XmlSampleService() {

	}

	public List<Pelicula> lerXMLPelis(String ruta) throws CursosXMLException {
		List<Pelicula> lista = new ArrayList<Pelicula>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;
		try {
			Pelicula peli = new Pelicula();
			builder = factory.newDocumentBuilder();
			Document xml = builder.parse(new File(ruta));

			Element root = xml.getDocumentElement();

			NodeList listaPeliTag = root.getElementsByTagName("pelicula");
			for (int i = 0; i < listaPeliTag.getLength(); i++) {
				Element pelisTag = (Element) listaPeliTag.item(i);
				Element tituloTag = (Element) pelisTag.getElementsByTagName("titulo").item(0);
				Element duracionTag = (Element) pelisTag.getElementsByTagName("duracion").item(0);
				Element añoTag = (Element) pelisTag.getElementsByTagName("año").item(0);
				peli.setAño(Integer.parseInt(añoTag.getTextContent()));
				peli.setDuracion(Integer.parseInt(duracionTag.getTextContent()));
				peli.setTitulo(tituloTag.getTextContent());

				Element artistasTag = (Element) pelisTag.getElementsByTagName("artistas").item(0);
				NodeList listaArtistasTag = artistasTag.getElementsByTagName("artista");

				List<Persona> listaPersonas = new ArrayList<Persona>();
				for (int j = 0; j < listaArtistasTag.getLength(); j++) {
					Persona p = new Persona();
					Element artistaTag = (Element) artistasTag.getElementsByTagName("artista").item(j);
					Element nombreTag = (Element) artistaTag.getElementsByTagName("nombre").item(0);
					Element nacionalidadTag = (Element) artistaTag.getElementsByTagName("nacionalidad").item(0);
					p.setNacionalidad(nacionalidadTag.getTextContent());
					p.setNombre(nombreTag.getTextContent());
					NamedNodeMap mapaAtributos = artistaTag.getAttributes();
					for (int x = 0; x < mapaAtributos.getLength(); x++) {
						Node atrib = mapaAtributos.item(x);
						if (atrib.getTextContent() == "dirección") {

							peli.setDireccion(p);
						} else if (atrib.getTextContent() == "producción") {
							peli.setProduccion(p);
						} else {
							listaPersonas.add(p);
						}
					}

				}
				peli.setActores(listaPersonas);
				lista.add(peli);

			}

		} catch (Exception e) {

			throw new CursosXMLException("Error leyendo XML", e);
		}
		return lista;

	}
}
