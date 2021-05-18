package co.feriaDeProyectos.model;

import java.io.Serializable;
import java.util.List;


public class Proyecto implements Serializable {

	private int id;
	private String nombre;
	private String resumen;
	private String video;
	private Tipo tipo;
	private Categoria cat;
	private Asignatura asig;
	private Evento evento;
	
	private List<Alumno> integrantes;

	public Proyecto(String nombre, String resumen, String video, Tipo tipo, Categoria cat, Asignatura asig, Evento evento) {
		this.nombre = nombre;
		this.resumen = resumen;
		this.video = video;
		this.tipo = tipo;
		this.cat = cat;
		this.asig = asig;
		this.evento = evento;
	}

	public Proyecto(int id,String nombre, String resumen, String video, Tipo tipo, Categoria cat, Asignatura asig, Evento evento) {
		this.id = id;
		this.nombre = nombre;
		this.resumen = resumen;
		this.video = video;
		this.tipo = tipo;
		this.cat = cat;
		this.asig = asig;
		this.evento = evento;
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

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Categoria getCat() {
		return cat;
	}

	public void setCat(Categoria cat) {
		this.cat = cat;
	}

	public Asignatura getAsig() {
		return asig;
	}

	public void setAsig(Asignatura asig) {
		this.asig = asig;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Alumno> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Alumno> integrantes) {
		this.integrantes = integrantes;
	}
}
