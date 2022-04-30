package com.mycompany.dao;

import java.util.List;

import com.mycompany.beans.Joueur;

public interface JoueurDao {
	void ajouter (Joueur joueur);
	List<Joueur> lister();
	List<Joueur> listerVainqueurs();
	List<Joueur> listerFinaliste();
	List<Joueur> epreuve();
	Joueur lecture(Long id);
	void modifier(Joueur joueur);
	void supprimer(Long id);
	public List<Joueur> rechercher(String chaine);
	public List<Joueur> rechercherSexe(String chaine);
	
}
