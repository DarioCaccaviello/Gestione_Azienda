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

import model.DaoAccount;
import model.DaoPermesso;
import model.DaoPersona;
import model.Persona;
import model.PersonaDTO;


@WebServlet("/VisualizzaDB")
public class VisualizzaDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisualizzaDB() {
        super();
    }

    DaoAccount a = new DaoAccount();
	DaoPersona daop = new DaoPersona();
	Persona p = new Persona();
	DaoPermesso daopermesso = new DaoPermesso(); 
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		String permesso = (String)  session.getAttribute("permesso"); //mi setto il permesso 
		
		System.out.println(username);
		
		if(permesso.equals("admin"))
		{
		//PER VISUALIZZARE L'INTERO DB 
		ArrayList<PersonaDTO> array = daop.stampaDB(); //Metodo per ciclare tutte le persone a DB
		request.setAttribute("persone", array);
		RequestDispatcher dispatcher=request.getRequestDispatcher("VisualizzaDB.jsp");
		dispatcher.forward(request, response);
		}else {
			
			PersonaDTO dto = new PersonaDTO();
			System.out.println("prova");
			dto = daop.stampaSingolaPersona(username);
			System.out.println(dto);
			request.setAttribute("persona", dto);
			RequestDispatcher dispatcher=request.getRequestDispatcher("VisualizzaDB.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
