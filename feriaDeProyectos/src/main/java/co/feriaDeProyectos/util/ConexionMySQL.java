package co.feriaDeProyectos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionMySQL {
	
	private static ConexionMySQL db;
	private Connection c = null;
	private PreparedStatement pr; //sentencia sql para interactuar con la DB
	
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String dbName = "feriaDeProyectos";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String userName = "root";
	private static final String password = "";
	
	private ConexionMySQL() {
		
		try {
			Class.forName(driver).newInstance();
			c = (Connection)DriverManager.getConnection(url+dbName,userName,password);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cerrarConexion()
	{
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Método para realizar consultas a la DB
	public ResultSet query() throws SQLException
	{
		ResultSet res = pr.executeQuery();
		return res;
	}
	
	//Método para actualizaciones a la DB (inserciones, borrados, actualizaciones)
	public int execute() throws SQLException
	{
		int result = pr.executeUpdate();
		return result;
	}
	
	//método para crear el statement dada una sentencia sql
	public void setPreparedStatement(String sql) throws SQLException
	{
		this.pr = c.prepareStatement(sql);
	}
	
	public PreparedStatement getPreparedStatement()
	{
		return this.pr;
	}
	
	public static ConexionMySQL getConexion()
	{
		if(db==null)
			db = new ConexionMySQL();
		return db;
	}
	
	
}
