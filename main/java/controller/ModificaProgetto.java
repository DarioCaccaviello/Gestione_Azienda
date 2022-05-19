package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DaoProgetti;
import model.ProgettiDTO;

@WebServlet("/ModificaProgetto")
public class ModificaProgetto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	DaoProgetti daopro = new DaoProgetti();
	ProgettiDTO dto = new ProgettiDTO();
	String nomeVecchioProgetti;
	
    public ModificaProgetto() {
        super();
     
    }

	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("Get Modifica Servlet");
	
	dto = daopro.ricercaProgetto(request.getParameter("nomeProgetto"));
	nomeVecchioProgetti = dto.getNomeProgetto();
	
	System.out.println(nomeVecchioProgetti);
	
	
	request.setAttribute("progetto", dto);
	RequestDispatcher rd = request.getRequestDispatcher("InserisciProgetti.jsp");	
	rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("POST MODIFICA PROGETTO");
		
		dto.setNomeProgetto(request.getParameter("nomeProgetto"));
		dto.setDescrizione(request.getParameter("descrizione"));
		dto.setCosto(Double.parseDouble(request.getParameter("costo")));
		dto.setLinkImg(request.getParameter("linkImg"));
		
		
		daopro.ModificaProg(dto,nomeVecchioProgetti);

		
		RequestDispatcher rd = request.getRequestDispatcher("Gestione.jsp");
        rd.forward(request, response);
		
		
		
		
	}

}
