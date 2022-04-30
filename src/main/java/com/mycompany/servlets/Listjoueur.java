package com.mycompany.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.mycompany.beans.Joueur;
import com.mycompany.dao.DaoFactory;
import com.mycompany.dao.JoueurDao;
import com.mycompany.dao.JoueurDaoImpl;

@WebServlet("/listjoueur")
public class Listjoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JoueurDao joueurDao;
       
    
    public Listjoueur() {
        super();
     }
    
    @Override
    public void init() throws ServletException {
    	DaoFactory daoFactory= DaoFactory.getInstance(); // je cree une instance de daoFactory
    	joueurDao = new JoueurDaoImpl(daoFactory);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JoueurDaoImpl joueurDao = new JoueurDaoImpl();
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/ApplicationJoueur/login");
			return;
		}
		request.setAttribute("joueurs", joueurDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/listjoueur.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("connectedUser") == null)
		{
			response.sendRedirect("/ApplicationJoueur/login");
			return;
		}
		
		if (request.getParameter("action1").equals("Rechercher")) {
				if (joueurDao.rechercher(request.getParameter("txtsearch")).size()==0) {
					request.setAttribute("nboccurence", 0);
					
				}
			request.setAttribute("joueurs", joueurDao.rechercher(request.getParameter("txtsearch")));
			this.getServletContext().getRequestDispatcher("/WEB-INF/listjoueur.jsp").forward(request, response);
	
		} else if (request.getParameter("action1").equals("Deconnexion")){
				session.setAttribute ( "connectedUser", null);
				response.sendRedirect("/ApplicationJoueur/login");
				return;
		}
		
	}

}
