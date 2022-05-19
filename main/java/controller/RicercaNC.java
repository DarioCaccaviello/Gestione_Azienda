package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DaoPersona;
import model.PersonaDTO;

/**
 * Servlet implementation class RicercaNC
 */
@WebServlet("/RicercaNC")
public class RicercaNC extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public RicercaNC() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		System.out.println("RICERCA NOME E COGNOME SERVLET");

		DaoPersona dao = new DaoPersona();
	
			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("cognome"));

			
			if(request.getParameter("RicercaNC")!= null)
			{
				//PER VISUALIZZARE L'INTERO DB 
				ArrayList<PersonaDTO> array = dao.ricercaNC(request.getParameter("nome"),request.getParameter("cognome")); 
				request.setAttribute("persone", array);
				RequestDispatcher dispatcher=request.getRequestDispatcher("RicercaNC.jsp");
				dispatcher.forward(request, response);

			}if((request.getParameter("RicercaCF")!=null))
			{
				ArrayList<PersonaDTO> array = dao.ricercaCF(request.getParameter("cf"));
				request.setAttribute("persone", array);
				RequestDispatcher dispatcher=request.getRequestDispatcher("RicercaNC.jsp");
				dispatcher.forward(request, response);	
			}
		
	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}

}