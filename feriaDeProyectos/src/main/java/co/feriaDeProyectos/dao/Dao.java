package co.feriaDeProyectos.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	public void insert(T t) throws SQLException;
	public T select(int id);
	public List<T> selectAll();
	public void delete(int id) throws SQLException;
	public void update(T t) throws SQLException;
}
