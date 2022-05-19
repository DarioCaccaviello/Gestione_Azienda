package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaoProgetti;
import model.ProgettiDTO;
import model.Progetto;

@WebServlet("/Progetti")
public class Progetti extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Progetti() {
        super();
    }
	Progetto prog=new Progetto();
	ProgettiDTO progDTO = new ProgettiDTO();
	DaoProgetti Daopro = new DaoProgetti();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		prog.setNomeProgetto(request.getParameter("nomeProgetto"));
		prog.setDescrizione(request.getParameter("descrizione"));
		prog.setCosto(Double.parseDouble(request.getParameter("costo")));
		prog.setLinkImg(request.getParameter("LinkImg"));
		Daopro.inserisciProgetto(prog);
		
		RequestDispatcher rs=request.getRequestDispatcher("Progetti.jsp");
		rs.forward(request, response);
		
	}

}
