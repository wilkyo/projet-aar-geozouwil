package com.soccer.valueobjects;

import java.util.ArrayList;
import java.util.Arrays;
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
	 * Number of teams participating.
	 */
	private int nbEquipes;
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
		this.nbEquipes = tournoi.getNbEquipes();
		this.rencontres = new ArrayList<VORencontreLight>();
		for (Rencontre r : tournoi.getRencontres()) {
			this.rencontres.add(new VORencontreLight(r));
		}
		for (int i = tournoi.getRencontres().size(); i < nbEquipes - 1; i++) {
			this.rencontres.add(new VORencontreLight());
		}
		this.rencontres = sort(this.rencontres.toArray(new VORencontreLight[0]));
	}

	private List<VORencontreLight> sort(VORencontreLight[] rencontres) {
		Arrays.sort(rencontres);
		List<VORencontreLight> res = new ArrayList<VORencontreLight>();
		for(int i = 0 ; i < rencontres.length ; i++)
			res.add(rencontres[i]);
		return res;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the nbEquipes
	 */
	public int getNbEquipes() {
		return nbEquipes;
	}

	/**
	 * @return the rencontres
	 */
	public List<VORencontreLight> getRencontres() {
		return rencontres;
	}
}
