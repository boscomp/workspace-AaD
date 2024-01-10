package ej8.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ej4.modelo.Edicion;
import ej4.modelo.Libro;



public class XMLLibrosHandler extends DefaultHandler{
	private Boolean openTag;
	private String texto;
	private List <Libro> libros;
	private Libro libro;
	private Edicion edicion;
	private List <Edicion> ediciones;
	private List<String> autores;
	public XMLLibrosHandler() {
		openTag=false;
		libros = new ArrayList<Libro>();
		ediciones = new ArrayList<Edicion>();
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		openTag=true;
		texto="";
		if (qName.equals("libro" )) {
			libro= new Libro();
			autores=new ArrayList<String>();
			libros.add(libro);
			String isbn=attributes.getValue("isbn");
			libro.setIsbn(Integer.parseInt(isbn));
		}
		else if(qName.equals("edicion")) {
			edicion = new Edicion();			
			ediciones.add(edicion);
			libro.setEdiciones(ediciones);
		}
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		openTag=false;
		if (qName.equals("titulo")) {
			libro.setTitulo(texto);
		}
		else if(qName.equals("autor")) {
			
			autores.add(texto);
			libro.setAutores(autores);
		}
		else if(qName.equals("año")) {
			edicion.setAño(Integer.parseInt(texto));
		}
		else if(qName.equals("editorial")) {
			edicion.setEditorial(texto);
			
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if(openTag) {
			texto+=new String(ch, start, length);
			}
	}
	public List <Libro> getLibros(){
		return libros;
	}
}
