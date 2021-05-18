package co.feriaDeProyectos.model;

import java.io.Serializable;
import java.util.List;


public class Alumno implements Serializable {
	
	private String codigo;
	private String nombre;
	private String email; 
	private String clave;
	private List<Proyecto> proyectos;
	
	

	public Alumno(String codigo, String nombre, String email, String clave) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	
}
