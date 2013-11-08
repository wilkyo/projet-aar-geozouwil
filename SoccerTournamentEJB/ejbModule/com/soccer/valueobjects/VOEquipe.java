package com.soccer.valueobjects;

import java.util.ArrayList;
import java.util.List;
import com.soccer.model.Equipe;
import com.soccer.model.Joueur;

/**
 * ValueObject of Equipe.
 */
public class VOEquipe {

	/**
	 * Name of the team.
	 */
	private String nom;
	/**
	 * List of ValueObjects of Players.
	 */
	private List<VOJoueur> joueurs;
	/**
	 * Name of the representative.
	 */
	private String nomRepresentant;
	/**
	 * First name of the representative.
	 */
	private String prenomRepresentant;

	/**
	 * Initializes the ValueObject.
	 * 
	 * @param equipe
	 *            The team.
	 */
	public VOEquipe(Equipe equipe) {
		this.nom = equipe.getNom();
		this.joueurs = new ArrayList<VOJoueur>();
		for (Joueur j : equipe.getJoueurs()) {
			this.joueurs.add(new VOJoueur(j));
		}
		this.nomRepresentant = equipe.getNomRepresentant();
		this.prenomRepresentant = equipe.getPrenomRepresentant();
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the joueurs
	 */
	public List<VOJoueur> getJoueurs() {
		return joueurs;
	}

	/**
	 * @return the nomRepresentant
	 */
	public String getNomRepresentant() {
		return nomRepresentant;
	}

	/**
	 * @return the prenomRepresentant
	 */
	public String getPrenomRepresentant() {
		return prenomRepresentant;
	}

}
