package controller;

import java.io.IOException;

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

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoAccount a = new DaoAccount();
	DaoPersona daop = new DaoPersona();
	Persona p = new Persona();
	DaoPermesso daopermesso = new DaoPermesso();

	PersonaDTO dto = new PersonaDTO();
	
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		String username = request.getParameter("us_email");
		String email = request.getParameter("us_email");
		String password = request.getParameter("password");
		
		//prima controllo account IF controllo Account tramite mail
		//recupero il permsso dalla query
		//daopermesso = permesso
		//a=account
		HttpSession session = request.getSession();

		if(a.controlloAccount(username, password))
		{
				if(daopermesso.login(username).equals("guest"))
				{
					session.setAttribute("permesso", daopermesso.login(username));
					session.setAttribute("username", username);
					RequestDispatcher rd = request.getRequestDispatcher("Gestione.jsp");
					rd.forward(request, response);
					System.out.println("login prova guest");	
				}else {
					session.setAttribute("permesso", daopermesso.login(username));
					session.setAttribute("username", username);
					RequestDispatcher rd = request.getRequestDispatcher("Gestione.jsp");
					rd.forward(request, response);
				}
		}else {
			System.out.println("Login Fallito");
			session.setAttribute("errore", "Username,email o password errati");
			RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
	
	
	
	
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
