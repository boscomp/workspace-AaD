package ejemploXML.app;

import ejemploXML.xml.XmlSampleService;

public class App {

	public static void main(String[] args) {
		XmlSampleService xss = new XmlSampleService();
		xss.crearXmlCurso("/C:/temporal/cursos.xml");
	}

}
