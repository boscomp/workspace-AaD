package ceu.dam.test;

import java.util.ArrayList;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import ceu.dam.modelo.Direccion;
import ceu.dam.modelo.Persona;
import ceu.dam.mongo.MongoSession;

public class Test {
	public static void main(String[] args) {
		MongoDatabase db = MongoSession.getDatabase();
//		MongoCollection<Document> c = db.getCollection("personas");
//		Document doc = new Document();
//		doc.append("nombre", "Nabil");
//		doc.append("apellido", "Fekir");
//		doc.append("dni", "2789A");
//		doc.append("edad", 30);
//		c.insertOne(doc);
//		InsertOneResult result= c.insertOne(doc);
//		System.out.println(result.getInsertedId());
//		System.out.println("OK!");
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		Persona p = new Persona();
		p.setDirecciones(new ArrayList<>());
		p.getDirecciones().add(new Direccion("Hola", "Sevilla", 41505));
		p.getDirecciones().add(new Direccion("Triana", "Sevilla", 41010));
		
		InsertOneResult result= c.insertOne(p);
		
		System.out.println(result.getInsertedId());
		System.out.println("OK!");
		
	}
}
