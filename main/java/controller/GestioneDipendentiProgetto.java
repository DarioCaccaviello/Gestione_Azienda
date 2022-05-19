package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoPersona;
import model.DaoProgetti;
import model.PersonaDTO;
import model.DaoDipendente;
/**
 * Servlet implementation class GestioneDipendentiProgetto
 */
@WebServlet("/GestioneDipendentiProgetto")
public class GestioneDipendentiProgetto extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public GestioneDipendentiProgetto() {
        super();
    }
    String nome_progetto;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonaDTO  dto = new PersonaDTO();
		DaoPersona daopersona = new DaoPersona();
		DaoProgetti daoprogetti = new DaoProgetti();
		
		System.out.println("SEI ENTRATO NELLE GESTIONE DIPENDENTI PROGETTI");

		ArrayList<PersonaDTO> persone_assocciate = new ArrayList<PersonaDTO>();
		ArrayList<PersonaDTO> persone_dissociate = new ArrayList<PersonaDTO>();

		if(request.getParameter("Dettagli_Dipendenti")!=null) {
			nome_progetto = request.getParameter("nomeProgetto");
		}
		
		persone_assocciate =daoprogetti.getutentiNonAssociati(nome_progetto);
		persone_dissociate =daoprogetti.getutentiAssociati(nome_progetto);
		
		request.setAttribute("persone", persone_assocciate);
		request.setAttribute("persone2", persone_dissociate);
		
		
		RequestDispatcher rd= request.getRequestDispatcher("GestioneDipendentiProgetti.jsp");
		rd.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonaDTO  dto = new PersonaDTO();
		DaoPersona daopersona = new DaoPersona();
		DaoProgetti daoprogetti = new DaoProgetti();
		DaoDipendente daodipendente = new DaoDipendente();
		
		int idDipendente = daodipendente.getId(daopersona.getIdCF(request.getParameter("cf")));
		System.out.println("cf = "+request.getParameter("cf"));
		System.out.println(idDipendente);

		int idProgetto=daoprogetti.getIdProgetto(nome_progetto);
		System.out.println(idProgetto);

		
		if(request.getParameter("ASSOCIA")!=null) {
			daoprogetti.associa(idDipendente, idProgetto);
			doGet(request,response);
			return;
		}
		
		if(request.getParameter("Dissocia")!=null) {
			daoprogetti.dissoccia(idDipendente);
			doGet(request,response);
			return;
		}
		
		
		
		
		
		
		
	}

}
