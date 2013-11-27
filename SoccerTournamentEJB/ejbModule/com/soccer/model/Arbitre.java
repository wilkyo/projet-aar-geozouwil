package com.soccer.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class of Arbitre.
 */
@Entity
public class Arbitre implements Serializable {

	/**
	 * The serial version id.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constants.
	 */
	public static final String XML_ARBITRES = "Arbitres";
	public static final String XML_ARBITRE = "Arbitre";
	public static final String XML_ARBITRE_NOM = "nom";
	public static final String XML_ARBITRE_PRENOM = "prenom";
	/**
	 * Id of the referee.
	 */
	private int id;
	/**
	 * Name of the referee.
	 */
	private String nom;
	/**
	 * Nickname of the referee.
	 */
	private String prenom;

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
	 * Returns the XML representation of a referee.
	 * 
	 * @return String of the XML representation of a referee.
	 */
	public String toXML() {
		return "<" + XML_ARBITRE + " " + XML_ARBITRE_NOM + "=\"" + nom + "\" "
				+ XML_ARBITRE_PRENOM + "=\"" + prenom + "\" />";
	}

}
