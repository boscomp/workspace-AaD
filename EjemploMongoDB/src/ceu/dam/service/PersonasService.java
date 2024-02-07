package ceu.dam.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

import ceu.dam.modelo.Direccion;
import ceu.dam.modelo.Persona;
import ceu.dam.mongo.MongoSession;

public class PersonasService {
	public String insertarPersona(Persona p) {
		MongoDatabase db = MongoSession.getDatabase();

				
				MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		
		p.setDirecciones(new ArrayList<>());
		p.getDirecciones().add(new Direccion("Hola", "Sevilla", 41505));
		p.getDirecciones().add(new Direccion("Triana", "Sevilla", 41010));
		
		InsertOneResult result= c.insertOne(p);
		return result.getInsertedId().toString();

	}
	
	public Persona consultarPersona(String id) {
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		
		FindIterable<Persona> result = c.find(Filters.eq("_id",new ObjectId(id)));
		return result.first();

		
		
	}
	
	public List<Persona> consultarPersonas() {
		List <Persona> personas = new ArrayList<Persona>();
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		FindIterable<Persona> result = c.find();
		MongoCursor<Persona> cursor = result.cursor();
		while (cursor.hasNext()) {
			personas.add(cursor.next());
		}
		return personas;
	}
	
	
	public List<Persona> consultarPersons() {
		List <Persona> personas = new ArrayList<Persona>();
		MongoDatabase db = MongoSession.getDatabase();
		MongoCollection<Persona> c = db.getCollection("personas", Persona.class);
		FindIterable<Persona> result = c.find();
		MongoCursor<Persona> cursor = result.cursor();
		while (cursor.hasNext()) {
			personas.add(cursor.next());
		}
		return personas;
	}
}
