package co.feriaDeProyectos.model;

import java.io.Serializable;
import java.sql.Date;

public class Evento implements Serializable {

	private int id;
	private String nombre;
	private Date date;
	
	public Evento(String nombre, Date date) {
		this.nombre = nombre;
		this.date = date;
	}
	
	public Evento(int id, String nombre, Date date) {
		this.id = id;
		this.nombre = nombre;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
