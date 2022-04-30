package com.mycompany.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.apache.tomcat.jni.User;

import com.mycompany.dao.DaoFactory;
import com.mycompany.dao.JoueurDaoImpl;
import com.mycompany.dao.UserDaoImpl;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDaoImpl userdaoimpl;  
    
    public Login() {
        super();
    }
    
   @Override
   		public void init() throws ServletException {
	    DaoFactory daoFactory= DaoFactory.getInstance(); // je cree une instance de daofactory
	    userdaoimpl=new UserDaoImpl(daoFactory);
	   	super.init();
   	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("txtLogin");
		String password=request.getParameter("txtPassword");
		if(login==null)login="inscrire";
		if(password==null)password="";
		// Stocker dans le modele
		HttpSession session=request.getSession(true); // creer session meme si elle n'existe pas 
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("txtLogin");
		String password=request.getParameter("txtPassword");
		
		com.mycompany.beans.User connectedUser = userdaoimpl.isValidLogin(login, password);
				
		if(connectedUser != null)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("connectedUser", connectedUser); 
			response.sendRedirect("/ApplicationJoueur/listjoueur");
		}
		else
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			
		}
	}

}
