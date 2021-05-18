package co.feriaDeProyectos.dao;

import java.sql.SQLException;
import java.util.List;

import co.feriaDeProyectos.model.Evento;



public interface EventoDao {

	public void insert(Evento evento) throws SQLException;
	public Evento select(int id);
	public List<Evento> selectAll();
	public void delete(int id) throws SQLException;
	public void update(Evento evento) throws SQLException;
}
