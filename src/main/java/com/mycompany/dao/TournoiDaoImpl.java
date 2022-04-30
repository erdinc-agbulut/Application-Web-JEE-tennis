package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.beans.Joueur;
import com.mycompany.beans.Tournoi;

public class TournoiDaoImpl implements TournoiDao {
	private DaoFactory daoFactory;
	
	public TournoiDaoImpl(DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Tournoi tournoi) {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = daoFactory.getConnection();
			
			statement = connexion.prepareStatement("INSERT INTO tournoi(NOM,CODE) VALUES (?,?)");
			
			statement.setString(1, tournoi.getNom());
			statement.setString(2, tournoi.getCode());
			statement.executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
		
	

	@Override
	public void modifier(Tournoi tournoi) {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = daoFactory.getConnection();
			
			statement = connexion.prepareStatement("UPDATE tournoi set nom=?,code=? where id=?");
			
			statement.setString(1, tournoi.getNom());
			statement.setString(2, tournoi.getCode());
			long idl=Long.valueOf(tournoi.getId());
			statement.setLong(3, idl);
			statement.executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void supprimer(Long id) {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = daoFactory.getConnection();
			
			statement = connexion.prepareStatement("Delete from `tournoi` where id=?");
			statement.setLong(1, id);
			statement.executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Tournoi> rechercher(String chaine) {
		List<Tournoi> tournois = new ArrayList<Tournoi>();
		Connection connexion = null;
		PreparedStatement statement = null;
		
	try {
		connexion = daoFactory.getConnection();
		String strsql = "SELECT * FROM tournoi where nom like ? or code like ? ";
		statement = connexion.prepareStatement(strsql);
		statement.setString(1, "%" + chaine + "%");
		statement.setString(2, "%" + chaine + "%");
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			tournois.add(new Tournoi(rs.getInt("id"), rs.getString("nom"),rs.getString("code")));	
		}
		
		
		}catch(Exception exception){
			throw new RuntimeException(exception);	
			}	
	
	return tournois;
	
	}

	@Override
	public List<Tournoi> lister() {
		List<Tournoi> tournois = new ArrayList<Tournoi>();
		
		Connection connexion = null;
		PreparedStatement statement = null;
		
	try {
		connexion = daoFactory.getConnection();
		String strsql = "SELECT * FROM tournoi";
		statement = connexion.prepareStatement(strsql);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			tournois.add(new Tournoi(rs.getInt("id"), rs.getString("nom"),rs.getString("code")));	
		}
		
		
		}catch(Exception exception){
			throw new RuntimeException(exception);	
			}	
	
	return tournois;
	}
	
	@Override
	public Tournoi lecture(Long id) {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * From tournoi where id=?");
		
			statement.setLong(1, id);
			ResultSet rs= statement.executeQuery();
			
			if(rs.next()) {
				return new Tournoi(
						rs.getInt("id"),
						rs.getString("nom"),
						rs.getString("code")
						);
				}else {
					return null;
				}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		//return joueur;
	}

}
