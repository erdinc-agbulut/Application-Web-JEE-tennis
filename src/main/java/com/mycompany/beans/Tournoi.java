package com.mycompany.beans;

public class Tournoi {
	int id;
	String nom;
	String code;
	
	public Tournoi(int id, String nom, String code) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
	}
	
	public Tournoi() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws BeanException {
		if (nom.length() > 20) {
			throw new BeanException("Le nom est trop grand ! (20 caractères au maximum)");
		} else {
			this.nom = nom;
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) throws BeanException {
		if (code.length() > 2) {
			throw new BeanException("Le code du Tournoi est trop grand ! (2 caractères au maximum)");
		} else {
			this.code = code;
		}
	}
	
	
	
	
}


