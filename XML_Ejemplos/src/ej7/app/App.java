package ej7.app;

import java.util.List;

import ej6.modelo.Pelicula;

import ej7.xml.XmlSampleService;
import ejemploXML.xml.CursosXMLException;

public class App {

	public App() {
		
	}
	public static void main(String[] args) {
		XmlSampleService xss= new XmlSampleService();
		try {
		
			List<Pelicula> lista= xss.lerXMLPelis("/C:/temporal/xmlPeliculas.xml");
			for (Pelicula pelicula : lista) {
				System.out.println(pelicula);
			}
		} catch (CursosXMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
