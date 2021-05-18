package co.feriaDeProyectos.controller;

import java.sql.Date;
import java.sql.SQLException;

import co.feriaDeProyectos.dao.AlumnoDaoMySQL;
import co.feriaDeProyectos.dao.EventoDaoMySQL;
import co.feriaDeProyectos.dao.ProyectoDaoMySQL;
import co.feriaDeProyectos.model.Alumno;
import co.feriaDeProyectos.model.Asignatura;
import co.feriaDeProyectos.model.Categoria;
import co.feriaDeProyectos.model.Evento;
import co.feriaDeProyectos.model.Proyecto;
import co.feriaDeProyectos.model.Tipo;
import co.feriaDeProyectos.dao.AlumnoParticiparProyecto_DaoMySQL;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProyectoDaoMySQL proyectoDao;
	private AlumnoDaoMySQL alumnoDao;
	private EventoDaoMySQL eventoDao;
	private AlumnoParticiparProyecto_DaoMySQL participa;

    /**
     * Default constructor. 
     */
    public Test() {
    	
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.proyectoDao = new ProyectoDaoMySQL();
    	this.alumnoDao = new AlumnoDaoMySQL();
    	this.eventoDao = new EventoDaoMySQL();
    	this.participa = new AlumnoParticiparProyecto_DaoMySQL();
    	
    	String nombre = "test";
    	String resumen = "sapesapesape";
    	String video = "https://www.youtube.com/watch?v=61Q6wWu5ziY";
    	Tipo tipo = new Tipo(1,"proyecto de aula");
    	Categoria cat = new Categoria(4,"investigacion");
    	Asignatura asig = new Asignatura("1155605","Base de datos");
    	Date date = new Date(2021,5,18);
    	System.out.println("fecha: anio:" + date.getYear() + " mes:" + date.getMonth() + " dia:" + date.getDay());
    	Evento evento = new Evento(5,"Feria sape",date);
    	Proyecto p = new Proyecto(nombre,resumen,video,tipo,cat,asig,evento);
    	Proyecto p2 = new Proyecto(2,"testNuevo","He bought?",video,tipo,cat,asig,evento);
    	
    	Alumno a = new Alumno("1151858","monk","juanesmoncada@gmail.com","123");
    	
    	try {
    		//eventoDao.insert(evento); //date mal ingresada
			proyectoDao.insert(p); 
			alumnoDao.insert(a);
			participa.insert(a, p);
			proyectoDao.update(p2);
			System.out.print("datos subidos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
	}

}
