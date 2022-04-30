package com.mycompany.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Joueur;
import com.mycompany.beans.Tournoi;
import com.mycompany.dao.DaoFactory;
import com.mycompany.dao.JoueurDao;
import com.mycompany.dao.JoueurDaoImpl;
import com.mycompany.dao.TournoiDao;
import com.mycompany.dao.TournoiDaoImpl;

@WebServlet("/modifiertournoi")
public class ModifierTournoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TournoiDao tournoiDao;   
    
    public ModifierTournoi() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	DaoFactory daoFactory=DaoFactory.getInstance();
    	tournoiDao= new TournoiDaoImpl(daoFactory);
    	super.init();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		long idl=Long.parseLong(id);
		Tournoi tournoi = tournoiDao.lecture(idl);
		request.setAttribute("tournoi", tournoi);
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifiertournoi.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tournoi tournoi = new Tournoi();
		
	try{	
		tournoi.setNom(request.getParameter("txtTournoi"));
		tournoi.setCode(request.getParameter("txtCode"));
		int id=Integer.parseInt(request.getParameter("idtournoi"));
		tournoi.setId(id);
		tournoiDao.modifier(tournoi);
		response.sendRedirect("/ApplicationJoueur/listtournoi");
		}
	catch (BeanException e) {
		request.setAttribute("erreur", e.getMessage());
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifiertournoi.jsp").forward(request, response);
	}
		
	}

}
