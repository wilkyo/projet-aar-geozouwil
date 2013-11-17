package com.soccer.valueobjects;

import com.soccer.model.Joueur;

/**
 * ValueObject of Joueur.
 */
public class VOJoueur {

	/**
	 * Id of the player.
	 */
	private int id;
	/**
	 * Name of the player.
	 */
	private String nom;
	/**
	 * First name of the player.
	 */
	private String prenom;
	/**
	 * Number of the player.
	 */
	private int numero;

	/**
	 * Initializes the ValueObject.
	 * 
	 * @param joueur
	 *            The player.
	 */
	public VOJoueur(Joueur joueur) {
		this.id = joueur.getId();
		this.nom = joueur.getNom();
		this.prenom = joueur.getPrenom();
		this.numero = joueur.getNumero();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

}
