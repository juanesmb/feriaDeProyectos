package co.feriaDeProyectos.dao;

import java.sql.SQLException;
import java.util.List;

import co.feriaDeProyectos.model.Tipo;

public interface TipoDao {

	public void insert(Tipo tipo) throws SQLException;
	public Tipo select(int id);
	public List<Tipo> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Tipo tipo) throws SQLException;
}
