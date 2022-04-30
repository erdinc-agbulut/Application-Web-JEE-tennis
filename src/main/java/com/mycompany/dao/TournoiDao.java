package com.mycompany.dao;

import java.util.List;

import com.mycompany.beans.Joueur;
import com.mycompany.beans.Tournoi;

public interface TournoiDao {
	void ajouter (Tournoi tournoi);
	void modifier (Tournoi tournoi);
	public List<Tournoi> rechercher(String chaine);
	List<Tournoi> lister();
	void supprimer(Long id);
	Tournoi lecture(Long id);

}
