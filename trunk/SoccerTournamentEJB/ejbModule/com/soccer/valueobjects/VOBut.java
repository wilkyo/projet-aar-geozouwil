package com.soccer.valueobjects;

import java.util.Calendar;
import com.soccer.model.But;

/**
 * ValueObject of But.
 */
public class VOBut {

	/**
	 * ValueObject of the goal's author.
	 */
	private VOJoueur auteur;
	/**
	 * Hour of the goal.
	 */
	private Calendar heure;

	/**
	 * Initializes the ValueObject.
	 * 
	 * @param but
	 *            The goal.
	 */
	public VOBut(But but) {
		this.auteur = new VOJoueur(but.getAuteur());
		this.heure = but.getHeure();
	}

	/**
	 * @return the auteur
	 */
	public VOJoueur getAuteur() {
		return auteur;
	}

	/**
	 * @return the heure
	 */
	public Calendar getHeure() {
		return heure;
	}

}
