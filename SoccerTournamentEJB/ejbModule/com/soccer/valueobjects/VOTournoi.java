package com.soccer.valueobjects;

import java.util.ArrayList;
import java.util.List;

import com.soccer.model.Rencontre;
import com.soccer.model.Tournoi;

/**
 * ValueObject of Tournoi.
 */
public class VOTournoi {

	/**
	 * Name of the tournament.
	 */
	private String nom;
	/**
	 * List of ValueObjects of Matches.
	 */
	private List<VORencontreLight> rencontres;

	/**
	 * Initializes the ValueObject.
	 * 
	 * @param tournoi
	 *            The tournament.
	 */
	public VOTournoi(Tournoi tournoi) {
		this.nom = tournoi.getNom();
		this.rencontres = new ArrayList<VORencontreLight>();
		for (Rencontre r : tournoi.getRencontres()) {
			this.rencontres.add(new VORencontreLight(r));
		}
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the rencontres
	 */
	public List<VORencontreLight> getRencontres() {
		return rencontres;
	}
}
