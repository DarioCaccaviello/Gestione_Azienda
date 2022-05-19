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

import model.DaoProgetti;
import model.PersonaDTO;
import model.ProgettiDTO;
import model.Progetto;

/**
 * Servlet implementation class VisualizzaProgetti
 */
@WebServlet("/VisualizzaProgetti")
public class VisualizzaProgetti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoProgetti Daopro = new DaoProgetti();
	
    public VisualizzaProgetti() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		String permesso = (String)  session.getAttribute("permesso"); //mi setto il permesso 
		//ArrayList<Progetto> array = Daopro.visualizzaProgetti();
		//request.setAttribute("progetto", array);
		
	
		//PER VISUALIZZARE L'INTERO DB 
		ArrayList<Progetto> progetto = Daopro.visualizzaProgetti(); //Metodo per ciclare tutte le persone a DB
		request.setAttribute("progetto", progetto);
		RequestDispatcher dispatcher=request.getRequestDispatcher("VisualizzaProgetti.jsp");
		dispatcher.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
