package co.feriaDeProyectos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.feriaDeProyectos.model.Asignatura;
import co.feriaDeProyectos.model.Categoria;
import co.feriaDeProyectos.model.Proyecto;
import co.feriaDeProyectos.model.Tipo;
import co.feriaDeProyectos.util.ConexionMySQL;

public class ProyectoDaoMySQL implements ProyectoDao{

	private ConexionMySQL c;
	private static final String INSERT_PROYECTO_SQL = "INSERT INTO proyecto (nombre,resumen,video,tipo,categoria,asignatura,evento) VALUES (?,?,?,?,?,?,?);";
	//private static final String DELETE_PROYECTO_SQL = "DELETE FROM proyecto WHERE id = ?;";
	private static final String UPDATE_PROYECTO_SQL = "UPDATE proyecto SET nombre=?,resumen=?,video=?,tipo=?,categoria=?,asignatura=?,evento=?  WHERE id = ?;";
	//private static final String SELECT_PROYECTO_BY_SQL = "SELECT * FROM proyecto WHERE id = ?;";
	private static final String SELECT_PROYECTO_BY_EVENTO = "SELECT * FROM proyecto WHERE evento = ?;";
	//private static final String SELECT_ALL_PROYECTOS = "SELECT * FROM proyecto;";
	
	public ProyectoDaoMySQL() {
		this.c = ConexionMySQL.getConexion();
	}
	
	@Override
	public void insert(Proyecto proyecto) throws SQLException {
		try {
			c.setPreparedStatement(INSERT_PROYECTO_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, proyecto.getNombre());
			pr.setString(2, proyecto.getResumen());
			pr.setString(3, proyecto.getVideo());
			int idTipo = proyecto.getTipo().getId();
			pr.setInt(4, idTipo);
			int idCat = proyecto.getCat().getId();
			pr.setInt(5, idCat);
			String codAsignatura = proyecto.getAsig().getCodigo();
			pr.setString(6, codAsignatura);
			int idEvento = proyecto.getEvento().getId();
			pr.setInt(7, idEvento);
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Proyecto select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Proyecto> selectByEventId(int eventId) throws SQLException{
		List<Proyecto> proyectos = new ArrayList<>();
		try {
			c.setPreparedStatement(SELECT_PROYECTO_BY_EVENTO);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setInt(1, eventId);
			ResultSet rs = c.query();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String resumen = rs.getString("resumen");
				String video = rs.getString("video");
				Tipo t = consultarTipo(rs.getInt("tipo")); 
				Categoria c = consultarCategoria(rs.getInt("categoria"));
				Asignatura a = consultarAsignatura(rs.getString("asignatura"));
				proyectos.add( new Proyecto (id,nombre,resumen,video,t,c,a) );
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return proyectos;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Proyecto proyecto) throws SQLException {
		try {
			c.setPreparedStatement(UPDATE_PROYECTO_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			
			pr.setString(1, proyecto.getNombre());
			pr.setString(2, proyecto.getResumen());
			pr.setString(3, proyecto.getVideo());
			int idTipo = proyecto.getTipo().getId();
			pr.setInt(4, idTipo);
			int idCat = proyecto.getCat().getId();
			pr.setInt(5, idCat);
			String codAsignatura = proyecto.getAsig().getCodigo();
			pr.setString(6, codAsignatura);
			int idEvento = proyecto.getEvento().getId();
			pr.setInt(7, idEvento);
			pr.setInt(8, proyecto.getId());
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Tipo consultarTipo(int idTipo) throws SQLException
	{
		c.setPreparedStatement("SELECT * FROM tipo WHERE id = ?;");
		PreparedStatement pr = c.getPreparedStatement();
		pr.setInt(1, idTipo);
		ResultSet t = c.query();
		if(t.next())
		{
			String des = t.getString(2);
			return new Tipo(idTipo,des); 
		}
		return null;
	}
	
	private Categoria consultarCategoria(int idCategoria) throws SQLException
	{
		c.setPreparedStatement("SELECT * FROM categoria WHERE id = ?;");
		PreparedStatement pr = c.getPreparedStatement();
		pr.setInt(1, idCategoria);
		ResultSet categoria = c.query();
		if(categoria.next())
			return new Categoria(idCategoria,categoria.getString("descripcion")); 
		return null;
	}
	
	private Asignatura consultarAsignatura(String codigoAsignatura) throws SQLException
	{
		c.setPreparedStatement("SELECT * FROM asignatura WHERE codigo = ?;");
		PreparedStatement pr = c.getPreparedStatement();
		pr.setString(1, codigoAsignatura);
		ResultSet asignatura = c.query();
		if(asignatura.next())
			return new Asignatura(codigoAsignatura,asignatura.getString("codigo")); 
		return null;
	}

}
