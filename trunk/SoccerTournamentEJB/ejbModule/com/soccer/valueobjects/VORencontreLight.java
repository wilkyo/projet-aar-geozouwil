package com.soccer.valueobjects;

import java.util.Calendar;

import com.soccer.model.Rencontre;

/**
 * ValueObject of Rencontre in a light version.
 */
public class VORencontreLight {

	/**
	 * Identifier of the match.
	 */
	private int id;
	/**
	 * Name of the host team.
	 */
	private String hotes;
	/**
	 * Name of the visitor team.
	 */
	private String visiteurs;
	/**
	 * Score of the host team.
	 */
	private int scoreHotes;
	/**
	 * Score of the visitor team.
	 */
	private int scoreVisiteurs;
	/**
	 * Date of the match.
	 */
	private Calendar dateRencontre;

	/**
	 * Initializes the ValueObject.
	 * 
	 * @param rencontre
	 *            The match.
	 */
	public VORencontreLight(Rencontre rencontre) {
		this.id = rencontre.getId();
		this.hotes = rencontre.getHotes().getNom();
		this.visiteurs = rencontre.getVisiteurs().getNom();
		this.scoreHotes = rencontre.getScoreHotes();
		this.scoreVisiteurs = rencontre.getScoreVisiteurs();
		;
		this.dateRencontre = rencontre.getDebut();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the hotes
	 */
	public String getHotes() {
		return hotes;
	}

	/**
	 * @return the visiteurs
	 */
	public String getVisiteurs() {
		return visiteurs;
	}

	/**
	 * @return the scoreHotes
	 */
	public int getScoreHotes() {
		return scoreHotes;
	}

	/**
	 * @return the scoreVisiteurs
	 */
	public int getScoreVisiteurs() {
		return scoreVisiteurs;
	}

	/**
	 * @return the dateRencontre
	 */
	public Calendar getDateRencontre() {
		return dateRencontre;
	}
}
