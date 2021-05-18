package co.feriaDeProyectos.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import co.feriaDeProyectos.model.Alumno;
import co.feriaDeProyectos.util.ConexionMySQL;

public class AlumnoDaoMySQL implements AlumnoDao{

	private ConexionMySQL c;
	private static final String INSERT_ALUMNO_SQL = "INSERT INTO alumno (codigo, nombre, email, clave) VALUES (?, ?,?,?);";
	//private static final String DELETE_ALUMNO_SQL = "DELETE FROM alumno WHERE codigo = ?;";
	//private static final String UPDATE_ALUMNO_SQL = "UPDATE alumno SET nombre = ?, email = ?, clave=? WHERE codigo = ?;";
	//private static final String SELECT_ALUMNO_BY_SQL = "SELECT * FROM usuario WHERE id = ?;";
	//private static final String SELECT_ALL_ALUMNOS = "SELECT * FROM usuario;";
	
	public AlumnoDaoMySQL() {
		this.c = ConexionMySQL.getConexion();
	}
	
	@Override
	public void insert(Alumno alumno) throws SQLException {
		try {
			c.setPreparedStatement(INSERT_ALUMNO_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, alumno.getCodigo());
			pr.setString(2, alumno.getNombre());
			pr.setString(3, alumno.getEmail());
			pr.setString(4, alumno.getClave());
			c.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Alumno select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Alumno alumno) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
