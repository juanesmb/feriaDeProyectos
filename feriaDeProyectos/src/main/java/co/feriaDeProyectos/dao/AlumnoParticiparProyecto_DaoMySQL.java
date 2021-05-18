package co.feriaDeProyectos.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.feriaDeProyectos.model.Alumno;
import co.feriaDeProyectos.model.Proyecto;
import co.feriaDeProyectos.util.ConexionMySQL;

public class AlumnoParticiparProyecto_DaoMySQL implements AlumnoParticiparProyecto_Dao{

	private ConexionMySQL c;
	private static final String INSERT_PARTICIPA_SQL = "INSERT INTO participa (alumno,proyecto) VALUES (?,?);";
	
	public AlumnoParticiparProyecto_DaoMySQL() {
		this.c = ConexionMySQL.getConexion();
	}
	
	@Override
	public void insert(Alumno alumno, Proyecto proyecto) throws SQLException {
		try {
			c.setPreparedStatement(INSERT_PARTICIPA_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, alumno.getCodigo());
			pr.setInt(2, proyecto.getId());
			c.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
