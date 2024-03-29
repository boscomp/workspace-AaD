package eje10.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import ej4.modelo.Libro;
@JacksonXmlRootElement(localName = "libros")
public class Libros {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("libro")
	private List<Libro> libros;

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}
