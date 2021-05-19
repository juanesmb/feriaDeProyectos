package co.feriaDeProyectos.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.feriaDeProyectos.model.Evento;
import co.feriaDeProyectos.util.ConexionMySQL;

public class EventoDaoMySQL implements EventoDao {

	private ConexionMySQL c;
	private static final String INSERT_EVENTO_SQL = "INSERT INTO evento (nombre, fecha) VALUES (?,?);";
	// private static final String DELETE_EVENTO_SQL = "DELETE FROM evento WHERE id
	// = ?;";
	// private static final String UPDATE_EVENTO_SQL = "UPDATE evento SET nombre =
	// ?, email = ?, pais=? WHERE id = ?;";
	// private static final String SELECT_EVENTO_BY_SQL = "SELECT * FROM evento
	// WHERE id = ?;";
	private static final String SELECT_ALL_EVENTOS = "SELECT * FROM evento;";

	public EventoDaoMySQL() {
		this.c = ConexionMySQL.getConexion();
	}

	@Override
	public void insert(Evento evento) throws SQLException {
		try {
			c.setPreparedStatement(INSERT_EVENTO_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, evento.getNombre());
			pr.setDate(2, evento.getDate());
			c.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Evento select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evento> selectAll() {
		List<Evento> eventos = new ArrayList<>();
		try {
			c.setPreparedStatement(SELECT_ALL_EVENTOS);
			PreparedStatement pr = c.getPreparedStatement();
			ResultSet rs = c.query();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Date fecha = rs.getDate("fecha");
				eventos.add(new Evento(id, nombre, fecha));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventos;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Evento evento) throws SQLException {
		// TODO Auto-generated method stub

	}

}
