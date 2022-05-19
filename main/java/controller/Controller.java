package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.DaoAccount;
import model.DaoDipendente;
import model.DaoImpaginazione;
import model.DaoPersona;
import model.Dipendente;
import model.Permesso;
import model.Persona;
import model.PersonaDTO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoPersona DaoP = new DaoPersona();
	DaoDipendente Daod = new DaoDipendente();
	DaoAccount DaoA = new DaoAccount();
	DaoImpaginazione DaoImpag = new DaoImpaginazione();
	Persona p = new Persona();
	Account a = new Account();
	Dipendente d = new Dipendente();
	Permesso pp=new Permesso();
    public Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*	
        ArrayList<Persona> array = DaoP.stampaPersone();
		request.setAttribute("persone", array);     // Metodo per ciclare la persona che si inserisce
		
		*/
		/**********************************************/
		int limit = 5;
		int offset = 0;
		

		if (request.getParameter("paginahome") != null) {
			System.out.println("sono nella pagina iniziale");
			PersonaDTO dto = new PersonaDTO();
			offset = 0;
			ArrayList<PersonaDTO> persone = DaoImpag.getutentiPag(limit, offset);
			request.setAttribute("persone", persone);
			RequestDispatcher rd = request.getRequestDispatcher("VisualizzaDB.jsp");
			rd.forward(request, response);

		}
		if (request.getParameter("paginafinale") != null) {
			System.out.println("sono nella pagina finale");
			PersonaDTO dto = new PersonaDTO();
			ArrayList<PersonaDTO> persone=DaoP.stampaPersone2();
			offset = persone.size()-(limit-1);
			persone = DaoImpag.getutentiPag(limit, offset);
			request.setAttribute("persone", persone);
			RequestDispatcher rd = request.getRequestDispatcher("VisualizzaDB.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("paginanext") != null) {
			System.out.println("sono nella pagina next");
			PersonaDTO dto = new PersonaDTO();
			offset += limit;
			ArrayList<PersonaDTO> persone = DaoImpag.getutentiPag(limit, offset);
			request.setAttribute("persone", persone);
			RequestDispatcher rd = request.getRequestDispatcher("VisualizzaDB.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("paginaback") != null && offset!=0 ) {
			System.out.println("sono nella pagina back");
			PersonaDTO dto = new PersonaDTO();
			offset =offset-limit;
			ArrayList<PersonaDTO> persone = DaoImpag.getutentiPag(limit, offset);
			request.setAttribute("persone", persone);
			RequestDispatcher rd = request.getRequestDispatcher("VisualizzaDB.jsp");
			rd.forward(request, response);
		} else {
			PersonaDTO udao = new PersonaDTO();
			offset = 0;
			ArrayList<PersonaDTO> persone = DaoImpag.getutentiPag(limit, offset);
			request.setAttribute("persone", persone);
			RequestDispatcher rd = request.getRequestDispatcher("VisualizzaDB.jsp");
			rd.forward(request, response);
		}
		
		
		
		/*****************************************************/
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
	
		System.out.println("sono in controller inserimento");
		//Persona
		p.setNome(request.getParameter("nome"));
		p.setCognome(request.getParameter("cognome"));
		p.setSesso(request.getParameter("sesso"));
		p.setDataNascita(Date.valueOf(request.getParameter("data")));
		p.setCf(request.getParameter("cf"));
		p.setLuogoDiNascita(request.getParameter("nascita"));

		DaoP.inserisciPersona(p);
		
		//Dipendente
		d.setStipendio(Double.parseDouble(request.getParameter("stipendio")));
		d.setIdPersona(DaoP.recuperoIDP(p.getCf()));
		System.out.println(DaoP.recuperoIDP(p.getCf()));
		Daod.inserisciDip(d);
		System.out.println(d);

		//Account
		a.setUsername(request.getParameter("username"));
		a.setEmail(request.getParameter("email"));
		a.setPassword(request.getParameter("password"));
		//a.setIdPermesso(DaoA.ricercaIdPM1());
		a.setIdPersona(DaoP.recuperoIDP((request.getParameter("cf")))); 

	
		//a.setIdPermesso(DaoA.ricercaIdPermesso());	
		//a.setIdPersona(DaoP.recuperoIDP((request.getParameter("cf")))); 
		//if("permesso".equals(request.getParameter(""))
		
		
		if(request.getParameter("ruolo").equals("guest"))
		{
			a.setIdPermesso(1);
			request.setAttribute("persona", p);

		}else {
			a.setIdPermesso(2);
			request.setAttribute("persona", p);

		}
		
	    DaoA.InserisciAccount(a);
		
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/successo.jsp");
		dispatcher.forward(request, response);
		

		
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	
	
	
	
	}

	
	
	
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
