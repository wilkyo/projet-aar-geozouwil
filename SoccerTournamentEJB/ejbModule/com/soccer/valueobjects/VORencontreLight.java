package com.soccer.valueobjects;

import java.util.Calendar;

import com.soccer.model.Rencontre;

/**
 * ValueObject of Rencontre in a light version.
 */
public class VORencontreLight implements Comparable<VORencontreLight> {

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
	 * Round of the match.
	 */
	private int tour;
	/**
	 * Date of the match.
	 */
	private Calendar dateRencontre;
	/**
	 * Tells whether the match is ended or not.
	 */
	private boolean finie;

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
		this.tour = rencontre.getTour();
		this.dateRencontre = rencontre.getDebut();
		this.finie = rencontre.getFin() != null;
	}

	/**
	 * Initializes a fake VORencontreLight.
	 */
	public VORencontreLight() {
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
	 * @return the tour
	 */
	public int getTour() {
		return tour;
	}

	/**
	 * @return the dateRencontre
	 */
	public Calendar getDateRencontre() {
		return dateRencontre;
	}

	/**
	 * @return the finie
	 */
	public boolean getFinie() {
		return finie;
	}

	/**
	 * Returns true if this is a fake match.
	 * 
	 * @return The existence of the match.
	 */
	public boolean isFake() {
		return this.getHotes() == null;
	}

	@Override
	public int compareTo(VORencontreLight o) {
		if (this.isFake())
			return -10;
		else if (o.isFake())
			return 10;
		else {
			return o.getTour() - this.getTour();
		}
	}
}
