package co.feriaDeProyectos.dao;

import java.sql.SQLException;
import java.util.List;

import co.feriaDeProyectos.model.Alumno;
import co.feriaDeProyectos.model.Proyecto;

public interface AlumnoParticiparProyecto_Dao {

	public void insert(Alumno alumno, Proyecto proyecto) throws SQLException;
	//public Alumno select(int id);
	//public List<Alumno> selectAll();
	//public void delete(int id) throws SQLException;
	//public void update(Alumno alumno) throws SQLException;
}
