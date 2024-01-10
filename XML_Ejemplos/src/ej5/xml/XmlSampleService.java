package ej5.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ej4.modelo.Edicion;
import ej4.modelo.Libro;
import ejemploXML.xml.CursosXMLException;

public class XmlSampleService {

	public XmlSampleService() {

	}

	public List<Libro> leerXmlLibro(String ruta) throws CursosXMLException {
		List<Libro> lista = new ArrayList<Libro>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document xml = builder.parse(new File(ruta));

			Element root = xml.getDocumentElement();

			NodeList listaLibrosTag = root.getElementsByTagName("libro");
			for (int i = 0; i < listaLibrosTag.getLength(); i++) {
				Libro libro = new Libro();
				Element libroTag = (Element) listaLibrosTag.item(i);

				String isbn = libroTag.getAttribute("isbn");

				Element tituloTag = (Element) libroTag.getElementsByTagName("titulo").item(0);
				String titulo = tituloTag.getTextContent();

				libro.setIsbn(Integer.parseInt(isbn));
				libro.setTitulo(titulo);

				Element autoresTag = (Element) libroTag.getElementsByTagName("autores").item(0);
				NodeList listaAutoresTag = autoresTag.getElementsByTagName("autor");
				List<String> listaAutores = new ArrayList<String>();
				for (int j = 0; j < listaAutoresTag.getLength(); j++) {
					Element autorTag = (Element) autoresTag.getElementsByTagName("autor").item(j);
					String autor = autorTag.getTextContent();
					listaAutores.add(autor);
				}
				libro.setAutores(listaAutores);
				Element edicionesTag = (Element) libroTag.getElementsByTagName("ediciones").item(0);
				NodeList listaedicionesTag = edicionesTag.getElementsByTagName("edicion");
				List<Edicion> listaEdiciones = new ArrayList<Edicion>();
				for (int j = 0; j < listaedicionesTag.getLength(); j++) {
					Element edicionTag = (Element) edicionesTag.getElementsByTagName("edicion").item(j);
					Element añoTag = (Element) edicionTag.getElementsByTagName("año").item(0);
					String año = añoTag.getTextContent();
					Element editorialTag = (Element) edicionTag.getElementsByTagName("editorial").item(0);
					String editorial = editorialTag.getTextContent();
					Edicion e = new Edicion();
					e.setAño(Integer.parseInt(año));
					e.setEditorial(editorial);
					listaEdiciones.add(e);
				}
				libro.setEdiciones(listaEdiciones);
				
				lista.add(libro);
			}
			return lista;
		} catch (Exception e) {

			throw new CursosXMLException("Error leyendo XML", e);
		}


	}
}
