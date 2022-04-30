package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.beans.Joueur;
import com.mycompany.beans.User;

public class JoueurDaoImpl implements JoueurDao {
	private DaoFactory daoFactory;
	
	public JoueurDaoImpl(DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Joueur joueur) {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = daoFactory.getConnection();
			
			statement = connexion.prepareStatement("INSERT INTO JOUEUR(NOM,PRENOM,SEXE) VALUES (?,?,?)");
			
			statement.setString(1, joueur.getNom());
			statement.setString(2, joueur.getPrenom());
			statement.setString(3, joueur.getSexe());
			statement.executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void modifier(Joueur joueur) {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = daoFactory.getConnection();
			
			statement = connexion.prepareStatement("UPDATE joueur set nom=?,prenom=?,sexe=? where id=?");
			
			statement.setString(1, joueur.getNom());
			statement.setString(2, joueur.getPrenom());
			statement.setString(3, joueur.getSexe());
			long idl=Long.valueOf(joueur.getId());
			statement.setLong(4, idl);
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
			
			statement = connexion.prepareStatement("Delete from `joueur` where id=?");
			statement.setLong(1, id);
			statement.executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Joueur> lister() {
		List<Joueur> joueurs = new ArrayList<Joueur>();
		
		Connection connexion = null;
		PreparedStatement statement = null;
		
	try {
		connexion = daoFactory.getConnection();
		String strsql = "SELECT * FROM joueur ";
		statement = connexion.prepareStatement(strsql);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			joueurs.add(new Joueur(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"), rs.getString("sexe")));	
		}
		
		
		}catch(Exception exception){
			throw new RuntimeException(exception);	
			}	
	
	return joueurs;
	}

	@Override
	public Joueur lecture(Long id) {
		Connection connexion = null;
		PreparedStatement statement = null;
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT * From joueur where id=?");
		
			statement.setLong(1, id);
			ResultSet rs= statement.executeQuery();
			
			if(rs.next()) {
				return new Joueur(
						rs.getInt("id"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("sexe")
						);
				}else {
					return null;
				}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		//return joueur;
	}
	
	@Override
	public List<Joueur> rechercher(String chaine) {
		List<Joueur> joueurs = new ArrayList<Joueur>();
		Connection connexion = null;
		PreparedStatement statement = null;
		
	try {
		connexion = daoFactory.getConnection();
		String strsql = "SELECT * FROM joueur where nom like ? or prenom like ? ";
		statement = connexion.prepareStatement(strsql);
		statement.setString(1, "%" + chaine + "%");
		statement.setString(2, "%" + chaine + "%");
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			joueurs.add(new Joueur(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"), rs.getString("sexe")));	
		}
		
		
		}catch(Exception exception){
			throw new RuntimeException(exception);	
			}	
	
	return joueurs;
	}
	
	@Override
	public List<Joueur> rechercherSexe(String chaine) {
		List<Joueur> joueurs = new ArrayList<Joueur>();
		Connection connexion = null;
		PreparedStatement statement = null;
		
	try {
		connexion = daoFactory.getConnection();
		String strsql = "select nom,prenom,sexe from joueur inner join match_tennis on ( joueur.id=match_tennis.id_vainqueur  or joueur.id=match_tennis.id_finaliste) inner join epreuve on epreuve.id=match_tennis.ID_EPREUVE and epreuve.ANNEE where sexe like '%H' ";
		statement = connexion.prepareStatement(strsql);
		statement.setString(1, "%" + chaine + "%");
		statement.setString(2, "%" + chaine + "%");
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			joueurs.add(new Joueur(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"), rs.getString("sexe")));	
		}
		
		
		}catch(Exception exception){
			throw new RuntimeException(exception);	
			}	
	
	return joueurs;
	}
	
	@Override
	public List<Joueur> listerVainqueurs() {
		List<Joueur> joueurs = new ArrayList<Joueur>();
		Connection connexion = null;
		PreparedStatement statement = null;
		
	try {
		connexion = daoFactory.getConnection();
		String strsql = "SELECT * from joueur inner join match_tennis on joueur.id = match_tennis.id_vainqueur";
		statement = connexion.prepareStatement(strsql);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			joueurs.add(new Joueur(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"), rs.getString("sexe")));	
		}
		
		
		}catch(Exception exception){
			throw new RuntimeException(exception);	
			}	
	
	return joueurs;
	}
	
	@Override
	public List<Joueur> listerFinaliste() {
		List<Joueur> joueurs = new ArrayList<Joueur>();
		Connection connexion = null;
		PreparedStatement statement = null;
		
	try {
		connexion = daoFactory.getConnection();
		String strsql = "SELECT * from joueur inner join match_tennis on joueur.id = match_tennis.id_finaliste";
		statement = connexion.prepareStatement(strsql);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			joueurs.add(new Joueur(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"), rs.getString("sexe")));	
		}
		
		
		}catch(Exception exception){
			throw new RuntimeException(exception);	
			}	
	
	return joueurs;
	}
	
	@Override
	public List<Joueur> epreuve() {
		List<Joueur> joueurs = new ArrayList<Joueur>();
		Connection connexion = null;
		PreparedStatement statement = null;
		
	try {
		connexion = daoFactory.getConnection();
		String strsql = "select * from joueur inner join match_tennis on ( joueur.id=match_tennis.id_vainqueur  or joueur.id=match_tennis.id_finaliste) inner join epreuve on epreuve.id=match_tennis.ID_EPREUVE and epreuve.ANNEE ";
		statement = connexion.prepareStatement(strsql);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			joueurs.add(new Joueur(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"), rs.getString("sexe")));	
		}
		
		
		}catch(Exception exception){
			throw new RuntimeException(exception);	
			}	
	
	return joueurs;
	}
	
	
}
