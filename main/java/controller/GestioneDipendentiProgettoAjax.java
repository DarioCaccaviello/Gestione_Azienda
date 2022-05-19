package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.DaoPersona;
import model.DaoProgetti;
import model.PersonaDTO;

@WebServlet("/GestioneDipendentiProgettoAjax")
public class GestioneDipendentiProgettoAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GestioneDipendentiProgettoAjax() {
        super();
    }
    
    String nome_progetto;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonaDTO  dto = new PersonaDTO();
		DaoPersona daopersona = new DaoPersona();
		DaoProgetti daoprogetti = new DaoProgetti();
			
	ArrayList<PersonaDTO> persone_assocciate = new ArrayList<PersonaDTO>();
	ArrayList<PersonaDTO> persone_dissociate = new ArrayList<PersonaDTO>();
	
	if(request.getParameter("Dettagli_Dipendenti")!=null) {
		nome_progetto = request.getParameter("nomeProgetto");
	}	
	
	persone_assocciate =daoprogetti.getutentiNonAssociati(nome_progetto);
	persone_dissociate =daoprogetti.getutentiAssociati(nome_progetto);
	
	String persone_assocciateJSON = new Gson().toJson(persone_assocciate);
	String persone_dissociateJSON = new Gson().toJson(persone_dissociate);	
	String personeJson="["+persone_assocciateJSON+","+persone_dissociateJSON+"]";
	
	System.out.println(persone_assocciateJSON);
	System.out.println(persone_dissociateJSON );
	
	response.getWriter().write(personeJson);//passa dai da servelet ad ajax	
	
	request.setAttribute("persone", persone_assocciate);
	request.setAttribute("persone2", persone_dissociate);	
	
	RequestDispatcher rd= request.getRequestDispatcher("GestioneDipendentiProgetti.jsp");
	rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
