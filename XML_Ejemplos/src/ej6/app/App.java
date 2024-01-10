package ej6.app;

import java.util.List;

import ej6.modelo.Pelicula;

import ej6.xml.XmlSampleService;



public class App {

public static void main(String[] args) {
	XmlSampleService xss = new XmlSampleService();
	List <Pelicula> pelis = Pelicula.createRandomList(50);
	xss.crearXmlPelis("/C:/temporal/pelis.xml", pelis);
	
}
}
