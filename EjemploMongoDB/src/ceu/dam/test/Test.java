package ceu.dam.test;

import java.util.ArrayList;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import ceu.dam.modelo.Direccion;
import ceu.dam.modelo.Persona;
import ceu.dam.mongo.MongoSession;
import ceu.dam.service.PersonasService;

public class Test {
	public static void main(String[] args) {
		PersonasService ps = new PersonasService();
		Persona p = new Persona();
		p.setDirecciones(new ArrayList<>());
		p.getDirecciones().add(new Direccion("Hola", "Sevilla", 41505));
		p.getDirecciones().add(new Direccion("Triana", "Sevilla", 41010));
		String id = ps.insertarPersona(p);
		System.out.println(id.toString());

	}
}
