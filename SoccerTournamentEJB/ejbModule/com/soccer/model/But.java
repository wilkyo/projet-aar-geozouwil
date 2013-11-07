package com.soccer.model;

import java.util.Calendar;

public class But {

	private int id;
	private Rencontre recontre;
	private Joueur auteur;
	private Calendar heure;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rencontre getRencontre() {
		return recontre;
	}

	public void setRencontre(Rencontre rencontre) {
		this.recontre = rencontre;
	}

	public Joueur getAuteur() {
		return auteur;
	}

	public void setAuteur(Joueur auteur) {
		this.auteur = auteur;
	}

	public Calendar getHeure() {
		return heure;
	}

	public void setHeure(Calendar heure) {
		this.heure = heure;
	}

}
