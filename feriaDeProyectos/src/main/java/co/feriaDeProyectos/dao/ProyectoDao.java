package co.feriaDeProyectos.dao;

import java.sql.SQLException;
import java.util.List;

import co.feriaDeProyectos.model.Proyecto;

public interface ProyectoDao {

	public void insert(Proyecto proyecto) throws SQLException;
	public Proyecto select(int id);
	public List<Proyecto> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Proyecto proyecto) throws SQLException;
}
