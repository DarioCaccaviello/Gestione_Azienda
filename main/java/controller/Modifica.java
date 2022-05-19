package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DaoAccount;
import model.DaoDipendente;
import model.DaoPermesso;
import model.DaoPersona;
import model.Persona;
import model.PersonaDTO;

/**
 * Servlet implementation class Modifica
 */
@WebServlet("/Modifica")
public class Modifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DaoPersona DaoP = new DaoPersona();
    PersonaDTO dto = new PersonaDTO();
    DaoAccount DaoA = new DaoAccount();
    DaoPermesso DaoPermesso = new DaoPermesso();
    DaoDipendente DaoD = new DaoDipendente();
    String cfv;
   
    public Modifica() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//MODIFICA DB 
	System.out.println("sono nel get di Modifica");
	dto = DaoP.ricercaPersona(request.getParameter("cf"));
	cfv = dto.getCf();
	

	request.setAttribute("persona", dto);
	RequestDispatcher rd = request.getRequestDispatcher("Form.jsp");	
	rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String permesso =(String)session.getAttribute("permesso"); 
		
		int id = DaoP.recuperoIDP(cfv);
		System.out.println(id);
		
		System.out.println("sono nel POST di Modifica");
		
		
		if(permesso.equals("admin"))
		{
			dto.setNome(request.getParameter("nome"));
			dto.setCognome(request.getParameter("cognome"));
			dto.setSesso(request.getParameter("sesso"));
			dto.setDataNascita(Date.valueOf(request.getParameter("data")));
			dto.setCf(request.getParameter("cf"));
			dto.setLuogoDiNascita(request.getParameter("luogoDiNascita"));
			
			DaoP.modificaPersona(dto, cfv);
			
			
			dto.setStipendio(Double.parseDouble(request.getParameter("stipendio")));
			DaoD.modificaPersona(dto, id);
			
			dto.setUsername(request.getParameter("username"));
			dto.setEmail(request.getParameter("email"));
			dto.setPassword(request.getParameter("password"));
			
			if(request.getParameter("ruolo").equals("guest"))
			{
				dto.setId(1);

			}else {
				dto.setId(2);

			}
			
			DaoA.modificaAccount(dto, id);
			
			RequestDispatcher rd = request.getRequestDispatcher("confermaModifica.jsp");
	        rd.forward(request, response);	
		}
		
		
		
	}

}
