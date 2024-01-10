package ej9.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ej6.modelo.Pelicula;
import ej6.modelo.Persona;

public class XMLPelisHandler extends DefaultHandler {
	private Boolean openTag;
	private String texto;
	private List<Pelicula> pelis;
	private List<Persona> personas;
	private Pelicula peli;
	private Persona persona;
	private String tipo;

	public XMLPelisHandler() {
		openTag = false;
		pelis = new ArrayList<Pelicula>();
		personas = new ArrayList<Persona>();
		tipo = "";
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		openTag = true;
		texto = "";
		if (qName.equals("pelicula")) {
			peli = new Pelicula();
			pelis.add(peli);

		}
		if (qName.equals("artista")) {
			tipo = attributes.getValue("tipo");
			persona = new Persona();
			

			if (tipo.equals(Persona.DIRECCION)) {
				peli.setDireccion(persona);
			} else if (tipo.equals(Persona.PRODUCCION)) {
				peli.setProduccion(persona);
			} else if (tipo.equals(Persona.INTERPRETACION)) {
				personas.add(persona);
				peli.setActores(personas);
				
			}
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag = false;
		if (qName.equals("titulo")) {
			peli.setTitulo(texto);
		} else if (qName.equals("duracion")) {
			peli.setDuracion(Integer.parseInt(texto));
		} else if (qName.equals("año")) {
			peli.setAño(Integer.parseInt(texto));
		} else if (qName.equals("nombre")) {
			persona.setNombre(texto);
		} else if (qName.equals("nacionalidad")) {
			persona.setNacionalidad(texto);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

	public List<Pelicula> getPelis() {
		return pelis;
	}
}
