package co.feriaDeProyectos.dao;

import java.sql.SQLException;
import java.util.List;

import co.feriaDeProyectos.model.Alumno;

public interface AlumnoDao {

	public void insert(Alumno alumno) throws SQLException;
	public Alumno select(int id);
	public List<Alumno> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Alumno alumno) throws SQLException;
}
