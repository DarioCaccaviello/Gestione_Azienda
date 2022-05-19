package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoAccount;
import model.DaoDipendente;
import model.DaoPersona;
import model.PersonaDTO;

/**
 * Servlet implementation class Elimina
 */
@WebServlet("/Elimina")
public class Elimina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoPersona daop = new DaoPersona();
	DaoDipendente daod = new DaoDipendente();
	DaoAccount daoaccount = new DaoAccount();
	
	
    public Elimina() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Servelet elimina");
		
		PersonaDTO dto = new PersonaDTO();
		
		
		
		
		int idcancellare = daop.getIdCF(request.getParameter("cf"));
		
		daoaccount.eliminaACCOUNT(idcancellare);
		daod.eliminaDipendente(idcancellare);
		daop.eliminaPersona(request.getParameter("cf"));
		
		
		
		
		System.out.println(request.getParameter("cf"));
		RequestDispatcher rd= request.getRequestDispatcher("VisualizzaDB");
		rd.forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
