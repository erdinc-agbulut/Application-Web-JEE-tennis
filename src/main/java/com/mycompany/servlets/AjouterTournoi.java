package com.mycompany.servlets;

import java.io.IOException;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Joueur;
import com.mycompany.beans.Tournoi;
import com.mycompany.dao.DaoFactory;
import com.mycompany.dao.JoueurDao;
import com.mycompany.dao.JoueurDaoImpl;
import com.mycompany.dao.TournoiDao;
import com.mycompany.dao.TournoiDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ajoutertournoi")
public class AjouterTournoi extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private TournoiDao tournoiDao;
       
    
    public AjouterTournoi() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	DaoFactory daoFactory=DaoFactory.getInstance();
    	tournoiDao = new TournoiDaoImpl(daoFactory);
    	super.init();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("connectedUser") == null) {
			response.sendRedirect("/ApplicationJoueur/login");
			return;
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutertournoi.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tournoi tournoi = new Tournoi();
	try {
		tournoi.setNom(request.getParameter("txtTournoi"));
		tournoi.setCode(request.getParameter("txtCode"));
		tournoiDao.ajouter(tournoi);
		request.setAttribute("tournois", tournoiDao.lister());
		response.sendRedirect("/ApplicationJoueur/listtournoi");
	}
	catch (BeanException e) {
		request.setAttribute("erreur", e.getMessage());
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutertournoi.jsp").forward(request, response);
	}
		
	}

}
