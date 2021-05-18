package co.feriaDeProyectos.dao;

import java.sql.SQLException;
import java.util.List;

import co.feriaDeProyectos.model.Asignatura;


public interface AsignaturaDao {

	public void insert(Asignatura asignatura) throws SQLException;
	public Asignatura select(int id);
	public List<Asignatura> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Asignatura asignatura) throws SQLException;
}
