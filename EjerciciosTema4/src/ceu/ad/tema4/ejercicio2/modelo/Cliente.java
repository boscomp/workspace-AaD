package ceu.ad.tema4.ejercicio2.modelo;

import java.util.Set;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class Cliente {
	@Id
	private String dni;
	private String nombre;
	private String apellidos;
	
	//mappedby atributo Cliente de otra clase  //-tomany eager -toone lazy
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER) //Fetch por consultar, eager porque trae todo
	// NO LLEVA CASCADE	no tiene cascade: ACTUALIZARCLIENTE()
	private Set<Pedido> pedidos;
	
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Set<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
}
