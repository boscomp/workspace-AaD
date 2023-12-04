package ejemplo.modelo;

public class Asignatura {
private String ciclo;
private Integer id;
private String nombre;
public String getCiclo() {
	return ciclo;
}
public void setCiclo(String ciclo) {
	this.ciclo = ciclo;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String toCsv() {
	return id + ";" + nombre + ";"+ ciclo+ ";";
}
}
