package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoProgetti;
import model.ProgettiDTO;

/**
 * Servlet implementation class EliminaProgetto
 */
@WebServlet("/EliminaProgetto")
public class EliminaProgetto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProgettiDTO dto = new ProgettiDTO();
	DaoProgetti daoprogetti = new DaoProgetti();
	
	
    public EliminaProgetto() {
        super();

    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("elimina progetto serverlet");
		
		daoprogetti.eliminaProgetto(request.getParameter("nomeProgetto"));
		
		RequestDispatcher rd= request.getRequestDispatcher("Progetti.jsp");
		rd.forward(request, response);
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
