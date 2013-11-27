package com.soccer.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Class of Joueur.
 */
@Entity
public class Joueur implements Serializable {

	/**
	 * The serial version id.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constants.
	 */
	public static final String XML_JOUEUR = "Joueur";
	public static final String XML_JOUEUR_NOM = "nom";
	public static final String XML_JOUEUR_PRENOM = "prenom";
	public static final String XML_JOUEUR_NUMERO = "numero";
	/**
	 * The id of the player.
	 */
	private int id;
	/**
	 * The team of the player.
	 */
	private Equipe equipe;
	/**
	 * Name of the player.
	 */
	private String nom;
	/**
	 * Nickname of the player.
	 */
	private String prenom;
	/**
	 * Number of the player.
	 */
	private int numero;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the equipe
	 */
	@ManyToOne
	public Equipe getEquipe() {
		return equipe;
	}

	/**
	 * @param equipe
	 *            the equipe to set
	 */
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Returns the XML representation of a player.
	 * 
	 * @return String of the XML representation of a player.
	 */
	public String toXML() {
		return "<" + XML_JOUEUR + " " + XML_JOUEUR_NOM + "=\"" + nom + "\" "
				+ XML_JOUEUR_PRENOM + "=\"" + prenom + "\" "
				+ XML_JOUEUR_NUMERO + "=\"" + numero + "\" />";
	}
}
