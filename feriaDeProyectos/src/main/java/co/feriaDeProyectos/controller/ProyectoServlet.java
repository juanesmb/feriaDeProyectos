package co.feriaDeProyectos.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.feriaDeProyectos.dao.EventoDaoMySQL;
import co.feriaDeProyectos.dao.ProyectoDaoMySQL;
import co.feriaDeProyectos.model.Evento;
import co.feriaDeProyectos.model.Proyecto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProyectoServlet
 */
@WebServlet("/")
public class ProyectoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EventoDaoMySQL eventoDao;
	private ProyectoDaoMySQL proyectoDao;

    /**
     * Default constructor. 
     */
    public ProyectoServlet() {
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.eventoDao = new EventoDaoMySQL();
    	this.proyectoDao = new ProyectoDaoMySQL();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch(action){
			case "/listProyectos":
				listProyectos(request,response);
				break;
			default:
				listEventos(request,response);
				break;
			}
		}catch(SQLException e)
		{
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listEventos(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException
	{
		List<Evento> eventos = this.eventoDao.selectAll();
		request.setAttribute("eventos", eventos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("eventosProyectos.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listProyectos(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException{
		List<Evento> eventos = this.eventoDao.selectAll();
		request.setAttribute("eventos", eventos);
		List<Proyecto> proyectos = this.proyectoDao.selectByEventId(Integer.parseInt(request.getParameter("eventId")));
		request.setAttribute("proyectos", proyectos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("eventosProyectos.jsp");
		dispatcher.forward(request, response);
	}

}
