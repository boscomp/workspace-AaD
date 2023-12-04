package ej05.app;

import java.util.List;

import ej05.csv.CsvSampleService;
import ej05.csv.FicheroException;
import ej05.modelo.City;



public class App {
public static void main(String[] args)  {
	CsvSampleService serviceCsv = new CsvSampleService();

	try {
		serviceCsv.escribirCity("/C:/temporal/ciudades.csv");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
