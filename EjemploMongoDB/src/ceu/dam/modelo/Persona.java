package ceu.dam.modelo;

import java.util.List;

public class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private List <Direccion> direcciones;
	public Persona(String dni, String nombre, String apellido, List<Direccion> direcciones) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direcciones = direcciones;
	}
	public Persona() {
		
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	
}
