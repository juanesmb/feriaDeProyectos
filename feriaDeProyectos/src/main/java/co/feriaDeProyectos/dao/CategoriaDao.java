package co.feriaDeProyectos.dao;

import java.sql.SQLException;
import java.util.List;

import co.feriaDeProyectos.model.Categoria;


public interface CategoriaDao {

	public void insert(Categoria categoria) throws SQLException;
	public Categoria select(int id);
	public List<Categoria> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Categoria Categoria) throws SQLException;
}
